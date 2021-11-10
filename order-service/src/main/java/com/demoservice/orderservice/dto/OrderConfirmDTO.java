package com.demoservice.orderservice.dto;

import lombok.Data;

@Data
public class OrderConfirmDTO {

    private String warehouseLocation;
    private String orderStatus;
}
