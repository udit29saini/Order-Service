package com.demoservice.orderservice.controller;

//import com.amazonaws.Response;
//import com.amazonaws.services.xray.model.Http;
import com.demoservice.orderservice.dto.CriteriaDto;
import com.demoservice.orderservice.entity.Order;

import com.demoservice.orderservice.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @PostMapping("/createorder")
    public ResponseEntity<Order> bookOrder(@RequestBody Order order){
    	log.info("In the bookOrder {}",order);
    	Order response = orderService.saveOrder(order);
    	return new ResponseEntity<Order>(order , HttpStatus.CREATED) ;
    }

    @PutMapping("/updateorder")
    public ResponseEntity<String> updateOrder(@RequestBody CriteriaDto criteria)
    {
        log.info("update the order in this criteria {}",criteria);
        return orderService.updateOrder(criteria);
    
    }


    @GetMapping("/getorder/{orderId}")
    public ResponseEntity<Order> getOrderFromOrderId(@PathVariable int orderId){
        log.info("Fetching the order for orderId {}" , orderId) ;
        Order order = orderService.getOrderByOrderId(orderId) ;
        return new ResponseEntity<Order>(order , HttpStatus.FOUND) ;
    }

    @GetMapping("/query-criteria/{queryCategory}/{queryParam}")
    public ResponseEntity<List<Order>> queryOrder(@PathVariable String queryCategory ,@PathVariable String queryParam)
    {
        log.info("Query Category {}",queryCategory);
        log.info("Query the order with this criteria {}",queryParam);
        List<Order> list= orderService.queryOrder(queryCategory,queryParam);
        return new ResponseEntity<List<Order>>(list,HttpStatus.FOUND);
    }
    
	

}
