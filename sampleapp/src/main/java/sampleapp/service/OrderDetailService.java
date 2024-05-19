package sampleapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import sampleapp.dto.OrderDtlDTO;
import sampleapp.entity.OrderDetail;
import sampleapp.mapper.OrderDetailMapper;

@Service
public class OrderDetailService {

    private final OrderDetailMapper orderDetailMapper;

    public OrderDetailService(OrderDetailMapper orderDetailMapper) {
        this.orderDetailMapper = orderDetailMapper;
    }

    public List<OrderDtlDTO> getAllOrderDetails() {
        return orderDetailMapper.getAllOrderDetails();
    }

    public OrderDtlDTO getOrderDetailById(int id) {
        return orderDetailMapper.getOrderDetailById(id);
    }

    public List<OrderDtlDTO> getOrderDetailsByOrderId(int id) {
        return orderDetailMapper.getOrderDetailsByOrderId(id);
    }
    
    public void addOrderDetail(OrderDetail orderDetail) {
        orderDetailMapper.addOrderDetail(orderDetail);
    }

    public void updateOrderDetail(OrderDetail orderDetail) {
        orderDetailMapper.updateOrderDetail(orderDetail);
    }

    public void deleteOrderDetail(int id) {
        orderDetailMapper.deleteOrderDetail(id);
    }
    
    public void deleteOrderAllDtls(int id) {
        orderDetailMapper.deleteOrderAllDtls(id);
    }
}
