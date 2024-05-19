package sampleapp.entity;

import java.time.LocalDate;

import lombok.Data;

@Data
public class OrderHeader {
    private int id;
    private LocalDate orderDate;
    private int supplierId;
}
