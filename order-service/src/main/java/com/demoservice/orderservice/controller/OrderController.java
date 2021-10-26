package com.demoservice.orderservice.controller;

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

    @PutMapping("/bookorder")
    public Order bookOrder(@RequestBody Order order){
    	
    	//log.info("In the bookOrder {}",order);

        return orderService.saveOrder(order) ;
    }
    @GetMapping("/User")
    public String firstApi()
    {
        return "Hello Order Service";
    }

//    @PostMapping("/{username}")
//    public ResponseEntity<Holding> addHolding(@RequestBody HoldingRequestDto holdingRequestDto, @PathVariable String username){
//        log.info("Going to add holding {}", holdingRequestDto);
//        Holding response =  holdingService.addHolding(holdingRequestDto, username, true);
//        return  new ResponseEntity<Holding>(response, HttpStatus.CREATED);
//
//    }

//    @PostMapping("/Order")
//    public ResponseEntity<Order> addOrder(@RequestBody orderDto)
//    {
//        log.info("In add Order {}",orderDto);
//        orderResponseDto responseDto =  orderService.saveOrder()
//        return new ResponseEntity<Order>(response, HttpStatus.CREATED);
//
//    }

}
