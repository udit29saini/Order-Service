package com.demoservice.orderservice.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import com.demoservice.orderservice.dto.CriteriaDto;
import com.demoservice.orderservice.entity.Order;
import com.demoservice.orderservice.repository.OrderRepository;

@ExtendWith(MockitoExtension.class)

class OrderServiceTest {
	@InjectMocks
	OrderService orderService;
	@Mock
	OrderRepository orderRepository;
	

	@Test
	void saveOrderTest()
	{
		Order order = new Order(1, "a", "b", "c", true, LocalDateTime.of(2021, 11, 10, 03, 36), 20.0);
		order.setOrderCost(50.0);
		when((orderRepository.save(order))).thenReturn(order);
		
		//Order response = orderService.saveOrder(order);
		
		//assertEquals(response.getOrderId(), order.getOrderId());
		
		
	}
	@Test
	void getOrderTest()
	{
		Order order = new Order(1, "a", "b", "c", true, LocalDateTime.of(2021, 11, 10, 03, 36), 20.0);
		order.setOrderCost(50.0);
		
		Optional<Order>expected = Optional.ofNullable(order);
		when((orderRepository.findById(1))).thenReturn(expected);
		
	    Order response = orderService.getOrderByOrderId(order.getOrderId());
		
		assertEquals(expected,Optional.ofNullable(response));
		
		
	}
	
	@Test
	void updateOrderTest()
	{
		CriteriaDto criteria = new CriteriaDto();
		criteria.setOrderId(1);
		criteria.setBillingAddress("c");
		
		
		Order order = new Order(1, "a", "b", "c", true, LocalDateTime.of(2021, 11, 10, 03, 36), 20.0);
		order.setOrderCost(50.0);
		Optional<Order> expected= Optional.ofNullable(order);
		
		when(orderRepository.findById(1)).thenReturn(expected);
		
		ResponseEntity<Order> response = orderService.updateOrder(criteria);
		
		assertEquals(response.getBody(), order);
		
		
	}
	
	@Test
	void updateOrderTest2()
	{
		CriteriaDto criteria = new CriteriaDto();
		criteria.setOrderId(1);
		
		criteria.setEmail("c");
		
		
		
		Order order = new Order(1, "a", "b", "c", true, LocalDateTime.of(2021, 11, 10, 03, 36), 20.0);
		order.setOrderCost(50.0);
		Optional<Order> expected= Optional.ofNullable(order);
		
		when(orderRepository.findById(1)).thenReturn(expected);
		
		ResponseEntity<Order> response = orderService.updateOrder(criteria);
		
		assertEquals(response.getBody(), order);
		
		
	}
	
	@Test
	void updateOrderTest3()
	{
		CriteriaDto criteria = new CriteriaDto();
		criteria.setOrderId(1);
		
		criteria.setMobileNumber("c");
		
		
		Order order = new Order(1, "a", "b", "c", true, LocalDateTime.of(2021, 11, 10, 03, 36), 20.0);
		order.setOrderCost(50.0);
		Optional<Order> expected= Optional.ofNullable(order);
		
		when(orderRepository.findById(1)).thenReturn(expected);
		
		ResponseEntity<Order> response = orderService.updateOrder(criteria);
		
		assertEquals(response.getBody(), order);
		
		
	}
	
	@Test
	void queryOrderTest1()
	{
		Order order = new Order(1, "a", "b", "c", true, LocalDateTime.of(2021, 11, 10, 03, 36), 20.0);
		
		
		List<Order> list = new ArrayList<>();
		list.add(order);
		
		when(orderRepository.findByBA("c")).thenReturn(list);
		
		List<Order> response = orderService.queryOrder("Billing_Address","c");
		
		assertEquals(response,list);
	}
	@Test
	void queryOrderTest2()
	{
		Order order = new Order(1, "a", "b", "c", true, LocalDateTime.of(2021, 11, 10, 03, 36), 20.0);
		
		
		List<Order> list = new ArrayList<>();
		list.add(order);
		
		when(orderRepository.findByA("b")).thenReturn(list);
		
		List<Order> response = orderService.queryOrder("Address","b");
		
		assertEquals(response,list);
	}
	@Test
	void queryOrderTest3()
	{
		Order order = new Order(1, "a", "b", "c", true, LocalDateTime.of(2021, 11, 10, 03, 36), 20.0);
		
		
		List<Order> list = new ArrayList<>();
		list.add(order);
		
		when(orderRepository.findByName("a")).thenReturn(list);
		
		List<Order> response = orderService.queryOrder("Name","a");
		
		assertEquals(response,list);
	}
	@Test
	void queryOrderTest4()
	{
		Order order = new Order(1, "a", "b", "c", true, LocalDateTime.of(2021, 11, 10, 03, 36), 20.0);
		
		
		List<Order> list = new ArrayList<>();
		list.add(order);
		
		when(orderRepository.findByPA(true)).thenReturn(list);
		
		List<Order> response = orderService.queryOrder("Payment","true");
		
		assertEquals(response,list);
	}
	@Test
	void queryOrderTest5()
	{
		Order order = new Order(1, "a", "b", "c", true, LocalDateTime.of(2021, 11, 10, 03, 36), 20.0);
		
		
		List<Order> list = new ArrayList<>();
		list.add(order);
		
		when(orderRepository.findByPA(false)).thenReturn(list);
		
		List<Order> response = orderService.queryOrder("Payment","false");
		
		assertEquals(response,list);
	}
}
