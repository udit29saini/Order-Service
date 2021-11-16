package com.example.cassandra;
import com.example.cassandra.controller.OrderController;
import com.example.cassandra.dto.CriteriaDto;
import com.example.cassandra.model.Order;
import com.example.cassandra.service.OrderService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OrderControllerTest {
	@Mock
	OrderService orderService;
	
	@InjectMocks
	OrderController orderController;

	@Test
	void testBookOrder() {
		/*
		 * Order order = new Order(1, "a", "b", "c", true, LocalDateTime.of(2021, 11,
		 * 10, 03, 36), 20.0,); order.setOrderCost(50.0);
		 * 
		 * 
		 * when(orderService.saveOrder(order)).thenReturn(order);
		 * 
		 * ResponseEntity<Order> response = orderController.bookOrder(order);
		 * 
		 * assertEquals(response.getBody(), order);
		 */
	}
	@Test
	void testUpdateOrder() {
		CriteriaDto criteria = new CriteriaDto();
		criteria.setOrderId(1);
		criteria.setBillingAddress("c");
		Order order = new Order(1, "a", "b", "c", true, LocalDate.of(2021, 11, 10), 20.0,null,null);
		order.setOrderCost(50.0);
		
		ResponseEntity<Order> expected= new ResponseEntity<Order>(order, HttpStatus.OK);
		
		
		when(orderService.updateOrder(criteria)).thenReturn(expected);
		
		ResponseEntity<Order> response = orderController.updateOrder(criteria);
		
		assertEquals(response.getBody(), expected.getBody());
	}
	
	@Test
	void testGetOrder() {
		Order order = new Order(1, "a", "b", "c", true, LocalDate.of(2021, 11, 10), 20.0,null,null);
		order.setOrderCost(50.0);
		
		
		when(orderService.getOrderByOrderId(1)).thenReturn(order);
		
		Order response = (orderController.getOrderFromOrderId(1)).getBody();
		
		assertEquals(response, order);
	}
	
	@Test
	void testQueryOrder() {
		List<Order> list= new ArrayList<Order>();
		
		Order order = new Order(1, "a", "b", "c", true, LocalDate.of(2021, 11, 10), 20.0,null,null);
		order.setOrderCost(50.0);
		
		list.add(order);
		
		
		when(orderService.queryOrder("Billing_Address","c")).thenReturn(list);
		
		List<Order>response = orderController.queryOrder("Billing_Address","c").getBody();
		
		assertEquals(response, list);
	}

}
