package com.Inditex.apiRest;

import com.Inditex.apiRest.controller.PriceInfoController;
import com.Inditex.apiRest.repository.PriceInfoRepository;
import com.Inditex.apiRest.service.PriceInfoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.bind.annotation.ResponseBody;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@SpringBootTest
@AutoConfigureMockMvc
public class PriceControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private PriceInfoService priceInfoService;

	@Autowired
	private PriceInfoRepository priceInfoRepository;

	@Autowired
	private PriceInfoController priceInfoController;

	@Test
	public void testCalculatePrice_ValidParameters_Returns200Test1() throws Exception {

		MvcResult result = mockMvc.perform(get("/api/priceInfo/calculatePrice")
						.param("applicationDate", "2020/06/14 16:00:00")
						.param("productId", "35455")
						.param("brandId", "1"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.price").value(25.45))
				.andReturn();
	}

	@Test
	public void testCalculatePrice_ValidParameters_Returns200Test3() throws Exception {

		MvcResult result = mockMvc.perform(get("/api/priceInfo/calculatePrice")
						.param("applicationDate", "2020/06/14 21:00:00")
						.param("productId", "35455")
						.param("brandId", "1"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.price").value(35.5))
				.andReturn();
	}

	@Test
	public void testCalculatePrice_ValidParameters_Returns200Test4() throws Exception {

		MvcResult result = mockMvc.perform(get("/api/priceInfo/calculatePrice")
						.param("applicationDate", "2020/06/15 10:00:00")
						.param("productId", "35455")
						.param("brandId", "1"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.price").value(30.5))
				.andReturn();
	}

	@Test
	public void testCalculatePrice_ValidParameters_Returns200Test5() throws Exception {

		MvcResult result = mockMvc.perform(get("/api/priceInfo/calculatePrice")
						.param("applicationDate", "2020/06/16 21:00:00")
						.param("productId", "35455")
						.param("brandId", "1"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.price").value(38.95))
				.andReturn();
	}

	@Test
	public void testCalculatePrice_ValidParameters_Returns200Test2() throws Exception {

		MvcResult result = mockMvc.perform(get("/api/priceInfo/calculatePrice")
						.param("applicationDate", "2020/06/14 10:00:00")
						.param("productId", "35455")
						.param("brandId", "1"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.price").value(35.5))
				.andReturn();
	}

	@Test
	public void testCalculatePrice_InvalidProductId_Returns400() throws Exception {
		// Perform the request and verify the response
		mockMvc.perform(get("/api/priceInfo/calculatePrice")
						.param("applicationDate", "2020/0//14 00:00:000")
						.param("productId", "1")  // Invalid productId
						.param("brandId", "1")
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isBadRequest())
				.andExpect(jsonPath("$.message").value("Invalid date format. The correct format is: dd/MM/yyyy HH:mm:ss"));
	}

	@Test
	@ResponseBody
	void testCalculatePrice_ValidParameters_Returns404NotFound() throws Exception {
		mockMvc.perform(get("/calculatePrice")
						.param("applicationDate", "01/01/2023")
						.param("productId", "1")
						.param("brandId", "2"))
				.andExpect(status().isNotFound()); // Make sure to adjust this line
//		mockMvc.perform(get("/calculatePrice").param("applicationDate", "01/01/2023")
//				.param("productId", "1")
//				.param("brandId", "2")).andExpect(status().isNotFound());

	}


}
