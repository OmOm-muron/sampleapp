package sampleapp.dto;

import java.time.LocalDate;

import lombok.Data;
import sampleapp.entity.Supplier;

@Data
public class OrderHdrDTO {
    private int orderId;
    private LocalDate orderDate;
    private int supplierId;
    private Supplier supplier;
}
