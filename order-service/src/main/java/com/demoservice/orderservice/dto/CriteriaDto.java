package com.demoservice.orderservice.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CriteriaDto {
    private int orderId;
    
    private String billingAddress;
    private String email;
    private String mobileNumber;
}
