package com.example.demo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

@SpringBootTest
@AutoConfigureMockMvc
class DemoApplicationTests {


	@Autowired
	private MockMvc mockMvc;	
	
	@Test
	void contextLoads() {
	}

	@Test
	public void hello() throws Exception {
		this.mockMvc.perform(get("/api/hello/world"))
		.andDo(MockMvcResultHandlers.print())
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.code").value("00000"))
		.andExpect(jsonPath("$.message").value("OK"))
		.andExpect(jsonPath("$.data").value("Hello world"));
	}
}
