package com.demoservice.orderservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.joda.time.LocalDate;

import javax.persistence.*;
import java.time.LocalDateTime;
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
    private String nameCustomer;
    private String shippingAddress;
    private String billingAddress;
    private boolean paymentStatus;
    private LocalDateTime orderDate;
    private double orderCost;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "oId",referencedColumnName = "orderId")
    private List<Product> products;

    public double orderCost()
    {
        double sum=0.0;
        for(Product i: products)
        {
            sum+=i.getProductPrice();
        }
        return sum;
    }

}