package sampleapp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import sampleapp.dto.OrderDtlDTO;
import sampleapp.entity.OrderDetail;

@Mapper
public interface OrderDetailMapper {

    List<OrderDtlDTO> getAllOrderDetails();

    OrderDtlDTO getOrderDetailById(int id);
    
    List<OrderDtlDTO> getOrderDetailsByOrderId(int id);

    void addOrderDetail(OrderDetail orderDetail);

    void updateOrderDetail(OrderDetail orderDetail);

    void deleteOrderDetail(int id);
    
    void deleteOrderAllDtls(int id);
}
