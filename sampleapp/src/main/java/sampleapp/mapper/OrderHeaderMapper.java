package sampleapp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import sampleapp.dto.OrderDTO;
import sampleapp.dto.OrderHdrDTO;
import sampleapp.entity.OrderHeader;

@Mapper
public interface OrderHeaderMapper {

    OrderHeader getLatestOrder();
    
    List<OrderHdrDTO> getAllOrderHeaders();

    OrderHdrDTO getOrderHeaderById(int id);
    
    OrderDTO getOrderById(int id);

    void addOrderHeader(OrderHeader orderHeader);

    void updateOrderHeader(OrderHeader orderHeader);

    void deleteOrderHeader(int id);
}
