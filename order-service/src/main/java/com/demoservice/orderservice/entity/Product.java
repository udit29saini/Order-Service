package com.demoservice.orderservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "Product_TB")
public class Product{
    @Id
    private int productId ;
    private String productName;
    private double productPrice ;
    private String productDescription ;
    private double dimension ;
    private double weight ;

    @ManyToOne
    @JoinColumn(name = "orderid", nullable = false)
    @JsonIgnore
    private Order order;
}
