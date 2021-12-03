package com.example.cassandra.service;

import com.example.cassandra.model.Cart;
import com.example.cassandra.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    @Autowired
    CartRepository cartRepository;

    public void addCart(Cart cart)
    {
        cartRepository.save(cart);
    }

    public Cart getCart(){
        return cartRepository.findById(1).get();
    }
}
