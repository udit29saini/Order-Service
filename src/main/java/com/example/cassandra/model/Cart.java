package com.example.cassandra.model;

import lombok.*;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.List;


@Getter
@Setter
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(value="cart")
public class Cart {

    @PrimaryKeyColumn(name = "CartID",ordinal = 0,type= PrimaryKeyType.PARTITIONED)
    @CassandraType(type = CassandraType.Name.INT)
    private int cartId;

    @Column("CheckoutAmount")
    @CassandraType(type = CassandraType.Name.DOUBLE)
    private double checkoutAmount;

    @Column("CartProducts")
    private List<Products> products;

    public double totalCost(List<Products> products)
    {
        double sum=0.0;
        for(Products i: products)
        {
            sum+=i.getPrice()*i.getQty();
        }
        return sum;
    }
}
