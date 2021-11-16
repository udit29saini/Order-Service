package com.example.cassandra.service;

import com.example.cassandra.model.Product;
import com.example.cassandra.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    public ProductRepository productRepository;

    public List<Product> fetchProduct()
    {
        List<Product> list= new ArrayList<>();
        RestTemplate restTemplate= new RestTemplate();
        list=restTemplate.getForObject("http://localhost:9000/products/",List.class);
        return list;
    }
}
