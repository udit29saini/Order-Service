package com.demoservice.orderservice.controller;

import com.demoservice.orderservice.entity.Product;
import com.demoservice.orderservice.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/hyy")
    public String firstApi()
    {
        log.info("In Product Service");
        return "Hello Product Service";
    }

    @PostMapping("/products")
    public void addingProduct(@RequestBody Product product)
    {
        log.info("In Product Service {}",product);
        productService.addProduct(product);
    }
}
