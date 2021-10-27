package com.demoservice.orderservice.controller;

import com.demoservice.orderservice.dto.CriteriaDto;
import com.demoservice.orderservice.entity.Order;

import com.demoservice.orderservice.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/order")
public class OrderController {


    @Autowired
    private OrderService orderService ;

    @GetMapping("/User")
    public String firstApi()
    {
        return "Hello Order Service";
    }

    @PostMapping("/bookorder")
    public Order bookOrder(@RequestBody Order order){
    	
    	//log.info("In the bookOrder {}",order);
        return orderService.saveOrder(order) ;
    }

    @PostMapping("/update-criteria")
    public void updateOrder(@RequestBody CriteriaDto criteria)
    {
        log.info("update the order in this criteria {}",criteria);
        orderService.updateOrder(criteria);
    }


    @GetMapping("/getOrder/{orderId}")
    public ResponseEntity<Order> getOrderFromOrderId(@PathVariable int orderId){
        log.info("Fetching the order for orderId {}" , orderId) ;
        Order order = orderService.getOrderByOrderId(orderId) ;
        return new ResponseEntity<Order>(order , HttpStatus.FOUND) ;
    }
}
