package com.demoservice.orderservice.service;

import com.demoservice.orderservice.dto.CriteriaDto;
import com.demoservice.orderservice.entity.Order;
import com.demoservice.orderservice.repository.OrderRepository;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository ;

    public Order saveOrder(Order order){
        //order.setOrderDate(localDateTime.now);
        order.setOrderDate(LocalDateTime.now());
        order.setOrderCost(order.orderCost());
        return orderRepository.save(order) ;
    }

    public Order getOrderByOrderId(int orderId) {
        Order order = orderRepository.findById(orderId).get() ;
        return order ;
    }

    public void updateOrder(CriteriaDto criteria) {
        if(criteria.getBillingAddress()!="NA")
        {
            Order order = orderRepository.findById(criteria.getOrderId()).get() ;
            Order order1=order;
            order1.setBillingAddress(criteria.getBillingAddress());
            orderRepository.save(order1);
        }
        if(criteria.getShippingAddress()!="NA")
        {
            Order order = orderRepository.findById(criteria.getOrderId()).get() ;
            Order order1=order;
            order1.setShippingAddress(criteria.getShippingAddress());
            orderRepository.save(order1);
        }
        if(criteria.getNameCustomer()!="NA") {
            Order order = orderRepository.findById(criteria.getOrderId()).get() ;
            Order order1=order;
            order1.setNameCustomer(criteria.getNameCustomer());
            orderRepository.save(order1);
        }
    }
}
