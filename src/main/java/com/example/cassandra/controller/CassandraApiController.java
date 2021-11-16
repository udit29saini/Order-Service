package com.example.cassandra.controller;

import com.example.cassandra.model.Product;
import com.example.cassandra.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api")
public class CassandraApiController {

    @Autowired
    ProductRepository productRepository;

    @GetMapping("/")
    public String check(){
        log.info("Cassandra Service is running");
        return "Hello!!";
    }

    @PostMapping("/add")
    void addProduct(@RequestBody Product product) throws Exception
    {
        productRepository.save(product);
    }
}
