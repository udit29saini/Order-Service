package com.demoservice.orderservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
}
