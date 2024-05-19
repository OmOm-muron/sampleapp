package sampleapp.dto;

import lombok.Data;
import sampleapp.entity.Item;

@Data
public class OrderDtlDTO {
    private int orderId;
    private int orderDtlId;
    private int itemId;
    private Item item;
    private int quantity;
}
