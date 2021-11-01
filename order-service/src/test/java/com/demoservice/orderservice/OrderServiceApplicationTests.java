
package com.demoservice.orderservice;

		import com.demoservice.orderservice.entity.Order;
		import com.demoservice.orderservice.repository.OrderRepository;
		import com.demoservice.orderservice.service.OrderService;
		import com.fasterxml.jackson.core.JsonProcessingException;
		import com.fasterxml.jackson.databind.ObjectMapper;
		import org.junit.jupiter.api.Test;
		import org.mockito.Mockito;
		import org.springframework.beans.factory.annotation.Autowired;
		import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
		import org.springframework.boot.test.context.SpringBootTest;
		import org.springframework.boot.test.mock.mockito.MockBean;
		import org.springframework.test.web.servlet.MockMvc;

		import static org.hamcrest.Matchers.any;
		import static org.hamcrest.Matchers.is;
		import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
		import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
		import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
		import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

		import java.time.LocalDateTime;
		import java.util.Date;
		import java.util.Optional;




@SpringBootTest
@AutoConfigureMockMvc
class OrderServiceApplicationTests {

	@Autowired
	MockMvc mockMvc ;

	@MockBean
	OrderRepository mockRepository ;

	@MockBean
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

}
