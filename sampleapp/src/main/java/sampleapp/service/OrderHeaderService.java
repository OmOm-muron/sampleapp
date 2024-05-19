package sampleapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import sampleapp.dto.OrderDTO;
import sampleapp.dto.OrderHdrDTO;
import sampleapp.entity.OrderHeader;
import sampleapp.mapper.OrderHeaderMapper;

@Service
public class OrderHeaderService {

    private final OrderHeaderMapper orderHeaderMapper;

    public OrderHeaderService(OrderHeaderMapper orderHeaderMapper) {
        this.orderHeaderMapper = orderHeaderMapper;
    }
    
    public OrderHeader getLatestOrder() {
        return orderHeaderMapper.getLatestOrder();
    }

    public List<OrderHdrDTO> getAllOrderHeaders() {
        return orderHeaderMapper.getAllOrderHeaders();
    }

    public OrderHdrDTO getOrderHeaderById(int id) {
        return orderHeaderMapper.getOrderHeaderById(id);
    }
    
    public OrderDTO getOrderById(int id) {
        return orderHeaderMapper.getOrderById(id);
    }

    public void addOrderHeader(OrderHeader orderHeader) {
        orderHeaderMapper.addOrderHeader(orderHeader);
    }

    public void updateOrderHeader(OrderHeader orderHeader) {
        orderHeaderMapper.updateOrderHeader(orderHeader);
    }

    public void deleteOrderHeader(int id) {
        orderHeaderMapper.deleteOrderHeader(id);
    }
}
