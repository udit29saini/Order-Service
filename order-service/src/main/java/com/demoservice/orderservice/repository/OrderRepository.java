package com.demoservice.orderservice.repository;

import com.demoservice.orderservice.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order , Integer> {
}
