package com.demoservice.orderservice.dto;

import lombok.Data;

@Data
public class CriteriaDto {
    private int orderId;
    private String shippingAddress;
    private String billingAddress;
    private boolean paymentStatus;
    private String nameCustomer;
}
