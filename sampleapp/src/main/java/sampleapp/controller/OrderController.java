package sampleapp.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import sampleapp.dto.OrderDTO;
import sampleapp.dto.OrderDtlDTO;
import sampleapp.dto.OrderHdrDTO;
import sampleapp.entity.Item;
import sampleapp.entity.OrderDetail;
import sampleapp.entity.OrderHeader;
import sampleapp.entity.Supplier;
import sampleapp.service.ItemService;
import sampleapp.service.OrderDetailService;
import sampleapp.service.OrderHeaderService;
import sampleapp.service.SupplierService;

@Controller
@RequestMapping("/orders")
public class OrderController {

    private final OrderHeaderService orderHeaderService;
    private final OrderDetailService orderDetailService;
    private final SupplierService supplierService;
    private final ItemService itemService;

    public OrderController(OrderHeaderService orderHeaderService, OrderDetailService orderDetailService, SupplierService supplierService, ItemService itemService) {
        this.orderHeaderService = orderHeaderService;
        this.orderDetailService = orderDetailService;
        this.supplierService = supplierService;
        this.itemService = itemService;
    }

    @GetMapping("")
    public String getAllOrders(Model model) {
        List<OrderHdrDTO> orders = orderHeaderService.getAllOrderHeaders();
        model.addAttribute("orders", orders);
        return "orders/order-list";
    }

    @GetMapping("/{id}")
    public String getOrderById(@PathVariable int id, Model model) {
        OrderHdrDTO orderHdr = orderHeaderService.getOrderHeaderById(id);
        List<OrderDtlDTO> orderDetails = orderDetailService.getOrderDetailsByOrderId(id);
        model.addAttribute("orderHdr", orderHdr);
        model.addAttribute("orderDtls", orderDetails);
        return "orders/order-detail";
    }

    @GetMapping("/add")
    public String showAddOrderForm(Model model) {
        List<Supplier> suppliers = supplierService.getAllSuppliers();
        OrderDTO order = new OrderDTO();
        order.setOrderDtls(new ArrayList<>());
        for (int i = 0; i < 5; i++) {
            order.getOrderDtls().add(new OrderDetail());
        }
        List<Item> items = itemService.getAllItems();
        model.addAttribute("items", items);
        model.addAttribute("suppliers", suppliers);
        model.addAttribute("order", order);
        return "orders/order-add";
    }

    @PostMapping("/add")
    public String addOrder(@ModelAttribute OrderDTO order) {
        OrderHeader orderHeader = new OrderHeader();
        orderHeader.setOrderDate(order.getOrderDate());
        orderHeader.setSupplierId(order.getSupplierId());
        orderHeaderService.addOrderHeader(orderHeader);
        
        int orderId = orderHeaderService.getLatestOrder().getId();
        
        List<OrderDetail> orderDtls = order.getOrderDtls();
        Iterator<OrderDetail> it = orderDtls.iterator();
        while (it.hasNext()) {
            OrderDetail orderDetail = it.next();
            if (orderDetail.getItemId() < 0 || orderDetail.getQuantity() == null) {
                continue;
            }
            orderDetail.setOrderId(orderId);
            orderDetailService.addOrderDetail(orderDetail);
        }
        return "redirect:/orders";
    }

    @GetMapping("/{id}/update")
    public String showUpdateOrderForm(@PathVariable int id, Model model) {
        List<Supplier> suppliers = supplierService.getAllSuppliers();
        List<Item> items = itemService.getAllItems();
        OrderDTO order = orderHeaderService.getOrderById(id);
        for (int i = order.getOrderDtls().size(); i < 5; i++) {
            order.getOrderDtls().add(new OrderDetail());
        }
        model.addAttribute("items", items);
        model.addAttribute("suppliers", suppliers);
        model.addAttribute("order", order);
        return "orders/order-update";
    }

    @PostMapping("/{id}/update")
    public String updateOrder(@PathVariable int id, @ModelAttribute OrderHeader orderHeader) {
        orderHeader.setId(id);
        orderHeaderService.updateOrderHeader(orderHeader);
        return "redirect:/orders";
    }

    @GetMapping("/{id}/delete")
    public String showDeleteOrderForm(@PathVariable int id) {
        return "orders/order-delete";
    }
    
    @PostMapping("/{id}/delete")
    public String deleteOrder(@PathVariable int id) {
        orderDetailService.deleteOrderAllDtls(id);
        orderHeaderService.deleteOrderHeader(id);
        return "redirect:/orders";
    }
}
