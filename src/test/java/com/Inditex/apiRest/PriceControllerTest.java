//package com.Inditex.apiRest;
//
//import com.Inditex.apiRest.model.PriceInfo;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//import java.util.Date;
//import com.Inditex.apiRest.*;
//
//import static org.mockito.ArgumentMatchers.*;
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//
//@WebMvcTest(PriceController.class)
//public class PriceControllerTest {
//
//	@Autowired
//	private MockMvc mockMvc;
//
//	@Mock
//	private PriceInfoService priceInfoService;
//
//	@InjectMocks
//	private PriceController priceController;
//
//	@Test
//	public void testCalculatePrice_ValidParameters_Returns200() throws Exception {
//		// Mocking the service method
//		PriceInfo mockPriceInfo = new PriceInfo(/* Initialize with required data */);
//		when(priceInfoService.calculatePrice(any(), anyLong(), anyLong())).thenReturn(mockPriceInfo);
//
//		// Perform the request and verify the response
//		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/calculatePrice")
//						.param("applicationDate", "01/01/2023")
//						.param("productId", "1")
//						.param("brandId", "2")
//						.contentType(MediaType.APPLICATION_JSON))
//				.andExpect(status().isOk())
//				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
//				.andReturn();
//
//		// Additional assertions if needed
//	}
//
//	@Test
//	public void testCalculatePrice_InvalidProductId_Returns400() throws Exception {
//		// Perform the request and verify the response
//		mockMvc.perform(MockMvcRequestBuilders.get("/calculatePrice")
//						.param("applicationDate", "01/01/2023")
//						.param("productId", "-1")  // Invalid productId
//						.param("brandId", "2")
//						.contentType(MediaType.APPLICATION_JSON))
//				.andExpect(status().isBadRequest())
//				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
//				.andExpect(jsonPath("$.message").value("Product ID must be positive"));
//	}
//
//	@Test
//	public void testCalculatePrice_NoPriceInfoFound_Returns404() throws Exception {
//		// Mocking the service method to throw NoPriceInfoFoundException
//		when(priceInfoService.calculatePrice(any(), anyLong(), anyLong())).thenThrow(new NoPriceInfoFoundException("Product not found"));
//
//		// Perform the request and verify the response
//		mockMvc.perform(MockMvcRequestBuilders.get("/calculatePrice")
//						.param("applicationDate", "01/01/2023")
//						.param("productId", "1")
//						.param("brandId", "2")
//						.contentType(MediaType.APPLICATION_JSON))
//				.andExpect(status().isNotFound())
//				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
//				.andExpect(jsonPath("$.message").value("Product not found, please try another search."));
//	}
//
//	// Add more test cases for other scenarios and validations
//}
