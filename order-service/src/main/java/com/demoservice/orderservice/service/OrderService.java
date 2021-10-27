package com.demoservice.orderservice.service;

import com.demoservice.orderservice.entity.Order;
import com.demoservice.orderservice.repository.OrderRepository;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository ;

    public Order saveOrder(Order order){
        return orderRepository.save(order) ;
    }

    public Order getOrderByOrderId(int orderId) {
        Order order = orderRepository.getById(orderId) ;
        return order ;
    }
}
