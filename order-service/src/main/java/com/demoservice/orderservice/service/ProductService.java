package com.demoservice.orderservice.service;

import com.demoservice.orderservice.entity.Product;
import com.demoservice.orderservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    public ProductRepository productRepository;
    public void addProduct(Product product)
    {
        productRepository.save(product);
    }
}
