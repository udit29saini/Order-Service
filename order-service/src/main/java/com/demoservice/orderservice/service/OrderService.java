package com.demoservice.orderservice.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.demoservice.orderservice.dto.OrderConfirmDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.demoservice.orderservice.dto.CriteriaDto;
import com.demoservice.orderservice.entity.Order;
import com.demoservice.orderservice.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;

	public OrderConfirmDTO saveOrder(Order order) {
		// order.setOrderDate(localDateTime.now);
		order.setOrderDate(LocalDateTime.now());
		order.setOrderCost(order.orderCost());
		orderRepository.save(order);
		OrderConfirmDTO orderConfirmDTO= new OrderConfirmDTO();
		orderConfirmDTO.setOrderStatus("Confirmed");
		orderConfirmDTO.setWarehouseLocation(order.getShippingAddress());
		return orderConfirmDTO;
	}

	public Order getOrderByOrderId(int orderId) {
		Optional<Order> order = orderRepository.findById(orderId);
		return order.get();
	}

	public ResponseEntity<Order> updateOrder(CriteriaDto criteria) {
		
		try {
			Order order = orderRepository.findById(criteria.getOrderId()).get();

			if (criteria.getBillingAddress() != null) {
				
				order.setBillingAddress(criteria.getBillingAddress());
				orderRepository.save(order);
			}

			if (criteria.getEmail() != null) {
				
				order.setEmail(criteria.getEmail());
				orderRepository.save(order);
			}
			if (criteria.getMobileNumber() != null) {
			
				order.setMobileNumber(criteria.getMobileNumber());
				orderRepository.save(order);
			}
			return new ResponseEntity<>(order,HttpStatus.ACCEPTED);
		} catch (Exception e) {
			return new ResponseEntity<>(null,HttpStatus.NOT_ACCEPTABLE);
			
			
		}
		

	}

	public List<Order> queryOrder(String queryCategory, String queryParam) {
		List<Order> list = new ArrayList<>();
		if (queryCategory.compareTo("Billing_Address") == 0) {
			list = orderRepository.findByBA(queryParam);
		}
		if (queryCategory.compareTo("Address") == 0) {
			list = orderRepository.findByA(queryParam);
		}
		if (queryCategory.compareTo("Payment") == 0) {
			if (queryParam.compareTo("true") == 0) {
				list = orderRepository.findByPA(true);
			} else {
				list = orderRepository.findByPA(false);
			}
		}
		if (queryCategory.compareTo("Name") == 0) {
			list = orderRepository.findByName(queryParam);
		}
		return list;
	}

}
