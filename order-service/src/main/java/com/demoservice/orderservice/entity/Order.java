package com.demoservice.orderservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
@Table(name = "Order_TB")
@AllArgsConstructor
public class Order {
    @Id
    private int id;
    private String shippingAddress;
    private String billingAddress;
    private boolean paymentStatus;
    @OneToMany
    private List<Product> productList;

}