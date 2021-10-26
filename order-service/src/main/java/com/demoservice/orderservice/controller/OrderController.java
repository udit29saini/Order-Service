package com.demoservice.orderservice.controller;

import com.demoservice.orderservice.entity.Order;
import com.demoservice.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService ;

    @PutMapping("/bookorder")
    public Order bookOrder(@RequestBody Order order){
        return orderService.saveOrder(order) ;
    }
}
