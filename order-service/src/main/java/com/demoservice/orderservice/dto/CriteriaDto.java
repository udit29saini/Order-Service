package com.demoservice.orderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CriteriaDto {
    private int orderId;
    private String shippingAddress;
    private String billingAddress;
    private boolean paymentStatus;
    private String nameCustomer;
}
