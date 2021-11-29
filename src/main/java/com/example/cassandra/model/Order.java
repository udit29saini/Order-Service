package com.example.cassandra.model;

import com.datastax.oss.driver.api.core.type.DataType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.*;
import com.example.cassandra.model.Product;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(value="order")
public class Order implements Serializable {


//    @PrimaryKey(value = "OrderID")
//    @CassandraType(type = CassandraType.Name.UUID)
//    private int orderId;

    @PrimaryKeyColumn(name = "OrderID",ordinal = 0,type=PrimaryKeyType.PARTITIONED)
    @CassandraType(type = CassandraType.Name.INT)
    private int orderId;

    @Column("NameOfCustomer")
    @CassandraType(type = CassandraType.Name.TEXT)
    private String nameCustomer;

    @Column("ShippingAddress")
    @CassandraType(type = CassandraType.Name.TEXT)
    private String shippingAddress;

    @Column("BillingAddress")
    @CassandraType(type = CassandraType.Name.TEXT)
    private String billingAddress;

    @Column("PaymentStatus")
    @CassandraType(type = CassandraType.Name.BOOLEAN)
    private boolean paymentStatus;

    @Column("OrderDate")
    @CassandraType(type = CassandraType.Name.DATE)
    private LocalDate orderDate;

    @Column("OrderCost")
    @CassandraType(type = CassandraType.Name.DOUBLE)
    private double orderCost;

    @Column("Email")
    @CassandraType(type = CassandraType.Name.TEXT)
    private String email;

    @Column("MobileNumber")
    @CassandraType(type = CassandraType.Name.TEXT)
    private String mobileNumber;

    @Column("Products")
    //@CassandraType(type = CassandraType.Name.LIST)
    private List<Product> products;


    public Order(int orderId, String nameCustomer, String shippingAddress, String billingAddress, boolean b, LocalDate now, double v, String s, String s1){
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
            sum+=i.getPrice();
        }
        return sum;
    }


}