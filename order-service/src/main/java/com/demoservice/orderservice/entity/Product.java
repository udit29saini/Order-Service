package com.demoservice.orderservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data

@Table(name = "Product_Tb")
public class Product{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId ;
    private String name;
    private double productPrice ;
    private String productDescription ;
    private double dimension ;
    private double weight ;

//    @JsonIgnore
//    @ManyToOne
//    @JoinColumn(name = "order_id", nullable = false)
//    private Order order;
}
