package com.example.cassandra.model;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.cassandra.core.mapping.UserDefinedType;

@Getter
@Setter
@UserDefinedType("cart_product_type")
public class Products {

    private String categoryId;

    private String id;

    private String name;

    private double price;

    private String imageUrl;

    private int qty;
}
