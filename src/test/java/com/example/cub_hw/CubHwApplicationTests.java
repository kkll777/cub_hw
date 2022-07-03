package com.example.cub_hw;

import com.example.cub_hw.entities.Currency;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CubHwApplicationTests {

	private static final Logger log = LogManager.getLogger(CubHwApplicationTests.class);

	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private ObjectMapper objectMapper;
	@Value("${coinDeskApi}")
	private String api;

	@Test
	@Order(1)
	void testQuery() throws Exception {
		String findAllData = mockMvc.perform(MockMvcRequestBuilders.get("/api/Currency/getData").contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
				.andReturn()
				.getResponse()
				.getContentAsString(StandardCharsets.UTF_8);
		log.info("find all data => {}", findAllData);
	}

	@Test
	@Order(2)
	void testCreate() throws Exception {
		Currency currency = new Currency();
		currency.setCodeEN("TWD");
		currency.setCodeCHN("新台幣");
		String req = objectMapper.writeValueAsString(currency);
		mockMvc.perform(MockMvcRequestBuilders.post("/api/Currency/insert").contentType(MediaType.APPLICATION_JSON).content(req)).andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	@Order(3)
	void testUpdate() throws Exception {
		Currency currency = new Currency();
		currency.setCodeEN("TWD");
		currency.setCodeCHN("泰銖");
		String req = objectMapper.writeValueAsString(currency);

		mockMvc.perform(MockMvcRequestBuilders.put("/api/Currency/update").contentType(MediaType.APPLICATION_JSON).content(req))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.jsonPath("$.respObj.codeEN").value("TWD"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.respObj.codeCHN").value("泰銖"))
				.andReturn()
				.getResponse()
				.getContentAsString(StandardCharsets.UTF_8);
	}

	@Test
	@Order(4)
	void testDelete() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.delete("/api/Currency/delete/TWD").contentType(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	@Order(5)
	void testGetDeskTopApi() {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> res = restTemplate.getForEntity(api,String.class);
		Assertions.assertEquals(HttpStatus.OK,res.getStatusCode());
	}

	@Test
	@Order(6)
	void testGetTransformedData() throws Exception {
		String res = mockMvc.perform(MockMvcRequestBuilders.get("/api/coinDesk/getTransformedData").contentType(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
				.andReturn()
				.getResponse().getContentAsString(StandardCharsets.UTF_8);
		log.info("New CoinDesk Resp => {}",res);
	}

}
