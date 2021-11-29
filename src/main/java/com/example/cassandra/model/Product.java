package com.example.cassandra.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@UserDefinedType("product_type")
public class Product implements Serializable {

    private String categoryId;

    private String id;

    private String name;

    private double price;

    private String imageUrl;

}
