
package com.demoservice.orderservice;

		import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import com.demoservice.orderservice.dto.CriteriaDto;
import com.demoservice.orderservice.entity.Order;
import com.demoservice.orderservice.repository.OrderRepository;
import com.demoservice.orderservice.service.OrderService;
import com.fasterxml.jackson.databind.ObjectMapper;




@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
class OrderServiceApplicationTests {

	@Autowired
	MockMvc mockMvc ;

	@Mock
	OrderRepository mockRepository ;

	@Mock
	OrderService orderService ;

	ObjectMapper objectMapper = new ObjectMapper();

	@Test
	void shouldReturnOneParticularOrderBasedOnOrderId() throws Exception {
		Order order = new Order(1, "a", "b", "c", true, LocalDateTime.now(), 20.0);
		
		String stringOrder = objectMapper.writeValueAsString(order);

		Mockito.when(mockRepository.findById(1)).thenReturn(Optional.of(order));

		mockMvc.perform(get("/order/getOrder/" + order.getOrderId()))
				.andDo(print())
				.andExpect(status().isFound());
//				.andExpect(jsonPath("$.orderId" , is(order.getOrderId()))) ;
//				.andExpect(jsonPath("$.orderId" , is(order.getOrderId()))) ;
	}

//	@Test
//	void bookOrder() throws Exception{
//		Order order = new Order(1, "a", "b", "c", true, LocalDateTime.now(), 20.0);
//		String stringOrder = objectMapper.writeValueAsString(order);
//
//		Mockito.when(mockRepository.save(order)).thenReturn(order) ;
//
//		mockMvc.perform(get("/order/bookorder"))
//				.andDo(print())
//				.andExpect(status().isCreated());
//	}
//
//	@Test
//	void queryOrder() throws Exception{
//		Order order = new Order(1, "a", "b", "c", true, LocalDateTime.now(), 20.0);
//		String stringOrder = objectMapper.writeValueAsString(order);
//
//		Mockito.when(mockRepository.save(order)).thenReturn(order) ;
//
//		mockMvc.perform(get("/order/query-criteria/{queryCategory}/{queryParam}" ))
//				.andDo(print())
//				.andExpect(status().isCreated());
//	}

	
	@Test
	void saveOrderTest()
	{
		Order order = new Order(1, "a", "b", "c", true, LocalDateTime.of(2021, 11, 10, 03, 36), 20.0);
		order.setOrderCost(50.0);
		when((order)).thenReturn(order);
		
		//Order response = orderService.saveOrder(order);
		
		//assertEquals(response.getOrderId(), order.getOrderId());
		
		
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
		
		when(mockRepository.findById(1)).thenReturn(expected);
		
		ResponseEntity<Order> response = orderService.updateOrder(criteria);
		
		assertEquals(response.getBody(), order);
		
		
	}
}
