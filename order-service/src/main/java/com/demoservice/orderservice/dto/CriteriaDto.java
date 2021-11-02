package com.demoservice.orderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CriteriaDto {
    private int orderId;
    
    private String billingAddress;
    private String email;
    private String mobileNumber;
}
