
package com.demoservice.orderservice;

@ExtendWith(MockitoExtension.class)
class OrderServiceApplicationTests {

	@Autowired
	MockMvc mockMvc ;

	@Mock
	OrderRepository mockRepository ;

	@Mock
	OrderService orderService ;

	ObjectMapper objectMapper = new ObjectMapper();

//	@Test
//	void shouldReturnOneParticularOrderBasedOnOrderId() throws Exception {
//		Order order = new Order(1, "a", "b", "c", true, LocalDateTime.now(), 20.0);
//		String stringOrder = objectMapper.writeValueAsString(order);
//
//		Mockito.when(mockRepository.findById(1)).thenReturn(Optional.of(order));
//
//		mockMvc.perform(get("/order/getOrder/" + order.getOrderId()))
//				.andDo(print())
//				.andExpect(status().isFound());
////				.andExpect(jsonPath("$.orderId" , is(order.getOrderId()))) ;
//	}

	@Test
	void shouldReturnOneParticularOrderBasedOnOrderId() throws Exception {
		Order order = new Order(1, "a", "b", "c", true, LocalDateTime.now(), 20.0,"@gmail" , "111");
		Mockito.when(mockRepository.findById(order.getOrderId())).thenReturn(Optional.of(order));

		mockMvc.perform(get("/order/getorder/" + order.getOrderId()))
				.andDo(print())
				.andExpect(status().isFound());
//				.andExpect(jsonPath("$.orderId" , is(order.getOrderId()))) ;
	}


	@Test
	void updateOrder() throws Exception {
		Order order = new Order(1, "a", "b", "c", true, LocalDateTime.now(), 20.0 , "@gmail" , "111");
		CriteriaDto criteriaDto = new CriteriaDto(1 , "bcd" , "@yahoo" , "999") ;
		Order updatedOrder = new Order(1 , "a","b" , criteriaDto.getBillingAddress() , true , LocalDateTime.now() , 20.0 , criteriaDto.getEmail() , criteriaDto.getMobileNumber()) ;



		mockMvc.perform(get("/order/updateorder"))
				.andDo(print())
				.andExpect(status().isFound())
				.andExpect(jsonPath("$.orderId" , is(order.getOrderId()))) ;
	}

	
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
