package com.example.cassandra.controller;

import com.example.cassandra.dto.OrderConfirmDTO;
import com.example.cassandra.model.Cart;
import com.example.cassandra.model.Order;
import com.example.cassandra.model.Products;
import com.example.cassandra.repository.CartRepository;
import com.example.cassandra.service.CartService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(value="*")
@Slf4j
@RestController
@RequestMapping("/cart")
public class CartController {

    Cart cart= new Cart();

    @Autowired
    CartService cartService;

    @Autowired
    CartRepository cartRepository;

    @PostMapping("/cart")
     public ResponseEntity<String> createCart(@RequestBody List<Products> products){
        cart.setCartId(1);
        cart.setCheckoutAmount(cart.totalCost(products));
        cart.setProducts(products);
        cartService.addCart(cart);
        return new ResponseEntity<String>("Cart created", HttpStatus.OK);
    }

    @GetMapping("/getCart")
    public ResponseEntity<Cart> getCart()
    {
        return new ResponseEntity<Cart>(cartRepository.findAll().get(0),HttpStatus.OK);
    }
}
