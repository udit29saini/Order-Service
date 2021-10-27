package com.demoservice.orderservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.joda.time.LocalDate;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
@Table(name = "Order_TB")
@AllArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;
    private String name;
    private String shippingAddress;
    private String billingAddress;
    private boolean paymentStatus;
    //private LocalDate orderDate;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "oId",referencedColumnName = "orderId")
    private List<Product> products;
}