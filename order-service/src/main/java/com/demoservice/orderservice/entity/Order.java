package com.demoservice.orderservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
@Table(name = "Order_Tb")
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
    private String email;
    private String mobileNumber;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "oId",referencedColumnName = "orderId")
    private List<Product> products;

    public Order(int orderId, String nameCustomer, String shippingAddress, String billingAddress, boolean b, LocalDateTime now, double v){
        this.orderId = orderId ;
        this.nameCustomer = nameCustomer ;
        this.shippingAddress = shippingAddress ;
        this.billingAddress = billingAddress ;
    }

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