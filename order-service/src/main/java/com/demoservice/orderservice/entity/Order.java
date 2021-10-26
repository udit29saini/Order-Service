package com.demoservice.orderservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
@Table(name = "Order_TB")
@AllArgsConstructor
public class Order {
    @Id
    private int orderid;
    private String shippingAddress;
    private String billingAddress;
    private boolean paymentStatus;
//    @OneToMany
//    private List<Product> productList;
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Product> products;
}