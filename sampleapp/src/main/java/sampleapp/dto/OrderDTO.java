package sampleapp.dto;

import java.time.LocalDate;
import java.util.List;

import lombok.Data;
import sampleapp.entity.OrderDetail;

@Data
public class OrderDTO {
    private int orderId;
    private LocalDate orderDate;
    private int supplierId;
    private List<OrderDetail> orderDtls;
}
