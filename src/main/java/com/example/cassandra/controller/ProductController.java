package com.example.cassandra.controller;

import com.example.cassandra.model.Product;
import com.example.cassandra.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/hyy")
    public String firstApi()
    {
        log.info("In Product Service");
        return "Hello Product Service";
    }

    @GetMapping("/")
    public ResponseEntity getAllProduct(){
        List<Product> products = productService.fetchProduct();
        return ResponseEntity.status(HttpStatus.OK).body(products);
    }
}
