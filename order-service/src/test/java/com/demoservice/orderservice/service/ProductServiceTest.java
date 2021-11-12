package com.demoservice.orderservice.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import com.demoservice.orderservice.entity.Order;

class ProductServiceTest {

	@Test
	void saveOrderTest()
	{
		Order order = new Order(1, "a", "b", "c", true, LocalDateTime.of(2021, 11, 10, 03, 36), 20.0);
		order.setOrderCost(50.0);
		when((orderRepository.save(order))).thenReturn(order);
		
		//Order response = orderService.saveOrder(order);
		
		//assertEquals(response.getOrderId(), order.getOrderId());
		
		
	}

}
