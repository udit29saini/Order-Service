package com.demoservice.orderservice.controller;

//import com.amazonaws.Response;
//import com.amazonaws.services.xray.model.Http;
import com.demoservice.orderservice.dto.CriteriaDto;
import com.demoservice.orderservice.dto.ItemsReservationDTO;
import com.demoservice.orderservice.dto.OrderConfirmDTO;
import com.demoservice.orderservice.entity.Order;

import com.demoservice.orderservice.entity.Product;
import com.demoservice.orderservice.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/order")
public class OrderController {


    @Autowired
    private OrderService orderService ;

    @GetMapping("/User")
    public String firstApi()
    {
        log.info("In the Order Service");
        return "Hello Order Service";
    }

    @PostMapping("/createorder")
    public ResponseEntity<OrderConfirmDTO> bookOrder(@RequestBody Order order){
    	log.info("In the bookOrder {}",order);
        RestTemplate restTemplate= new RestTemplate();

        List<Product> list= new ArrayList<>();
        list=order.getProducts();
        OrderConfirmDTO orderConfirmDTO= new OrderConfirmDTO();
        for(Product product: list )
        {
            ItemsReservationDTO itemsReservationDTO = new ItemsReservationDTO();
            itemsReservationDTO.setLocation(order.getShippingAddress());
            itemsReservationDTO.setProductId(product.getName());

            String s= restTemplate.postForObject("http://localhost:8081/api/itemsreserve",itemsReservationDTO,String.class);
            if(s.compareTo("Warehouse not found")==0)
            {
                orderConfirmDTO.setOrderStatus("Uncomfirmed");
                orderConfirmDTO.setWarehouseLocation("Product not available in this location");
                return new ResponseEntity<OrderConfirmDTO>(orderConfirmDTO , HttpStatus.OK) ;
            }
            System.out.println(s);
        }
    	orderConfirmDTO = orderService.saveOrder(order);
    	return new ResponseEntity<OrderConfirmDTO>(orderConfirmDTO , HttpStatus.CREATED) ;
    }

    @GetMapping("/getorder")
    public ResponseEntity getAllOrders(){
        log.info("Fetching all orders") ;
        List<Order> orderList = orderService.fetchAllOrders();
        return ResponseEntity.status(HttpStatus.OK).body(orderList) ;
    }

    @PutMapping("/updateorder")
    public ResponseEntity<Order> updateOrder(@RequestBody CriteriaDto criteria)
    {
        log.info("update the order in this criteria {}",criteria);
        return orderService.updateOrder(criteria);
    
    }


    @GetMapping("/getorder/{orderId}")
    public ResponseEntity<Order> getOrderFromOrderId(@PathVariable int orderId){
        log.info("Fetching the order for orderId {}" , orderId) ;
        Order order = orderService.getOrderByOrderId(orderId) ;
        return new ResponseEntity<Order>(order , HttpStatus.OK) ;
    }

    @GetMapping("/query-criteria/{queryCategory}/{queryParam}")
    public ResponseEntity<List<Order>> queryOrder(@PathVariable String queryCategory ,@PathVariable String queryParam)
    {
        log.info("Query Category {}",queryCategory);
        log.info("Query the order with this criteria {}",queryParam);
        List<Order> list= orderService.queryOrder(queryCategory,queryParam);
        return new ResponseEntity<List<Order>>(list,HttpStatus.OK);
    }
    
	

}
