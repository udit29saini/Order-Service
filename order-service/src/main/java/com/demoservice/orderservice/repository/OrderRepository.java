package com.demoservice.orderservice.repository;

import com.demoservice.orderservice.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order , Integer> {

//    @Query(value = "SELECT * FROM Users u WHERE u.status = :status and u.name = :name",
//            nativeQuery = true)
//    User findUserByStatusAndNameNamedParamsNative(
//            @Param("status") Integer status, @Param("name") String name);
    @Query(value = "SELECT * FROM order_tb ot WHERE ot.billing_address=?1",nativeQuery = true)
    List<Order> findByBA(String queryParam);

    @Query(value = "SELECT * FROM order_tb ot WHERE ot.shipping_address=?1",nativeQuery = true)
    List<Order> findByA(String queryParam);


    @Query(value = "SELECT * FROM order_tb ot WHERE ot.name_customer=?1",nativeQuery = true)
    List<Order> findByName(String queryParam);

    @Query(value = "SELECT * FROM order_tb ot WHERE ot.payment_status=?1",nativeQuery = true)
    List<Order> findByPA(String queryParam);

}
