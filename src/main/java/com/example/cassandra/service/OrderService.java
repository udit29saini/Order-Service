package com.example.cassandra.service;

import com.example.cassandra.dto.CriteriaDto;
import com.example.cassandra.dto.OrderConfirmDTO;
import com.example.cassandra.model.Order;
import com.example.cassandra.repository.ImplQueryRepository;
import com.example.cassandra.repository.OrderRepository;
import com.example.cassandra.repository.QueryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private QueryRepository queryRepository;

	public OrderConfirmDTO saveOrder(Order order) {
		// order.setOrderDate(localDateTime.now);
		order.setOrderDate(LocalDate.now());
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
			list = queryRepository.findByBA(queryParam);
		}
		if (queryCategory.compareTo("Address") == 0) {
			list = queryRepository.findByA(queryParam);
		}
		if (queryCategory.compareTo("Payment") == 0) {
			if (queryParam.compareTo("true") == 0) {
				list = queryRepository.findByPA(true);
			} else {
				list = queryRepository.findByPA(false);
			}
		}
		if (queryCategory.compareTo("Name") == 0) {
			list = queryRepository.findByName(queryParam);
		}

		if (queryCategory.compareTo("Date") == 0) {
			list = queryRepository.findByDate(LocalDate.parse(queryParam));
		}


		return list;
	}

	public List<Order> fetchAllOrders() {
		return orderRepository.findAll();
	}
}
