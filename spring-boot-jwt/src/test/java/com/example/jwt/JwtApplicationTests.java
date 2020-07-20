package com.example.jwt;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import java.nio.charset.Charset;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

@SpringBootTest
@AutoConfigureMockMvc
class JwtApplicationTests {
	
	public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(), MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));

	private static final String ACCESS_JSON = "{\r\n\"accessCode\": \"code\",\r\n\"accessKey\":\"key\"\r\n}";


	@Autowired
	private MockMvc mockMvc;	

	@Test
	void contextLoads() {
		
	}

	@Test
	void getUnauthorized() throws Exception {
		this.mockMvc.perform(get("/api/hello")).andExpect(status().isUnauthorized());
	}

	@Test
	void getAuthorized() throws Exception {
		MvcResult result = this.mockMvc.perform(post("/api/login").contentType(APPLICATION_JSON_UTF8)
			.content(ACCESS_JSON)).andExpect(status().isOk()).andReturn();
		String token = result.getResponse().getContentAsString();
		this.mockMvc.perform(get("/api/hello").header("Authorization", "Bearer " + token))
			.andDo(MockMvcResultHandlers.print())
			.andExpect(status().isOk()).andExpect(content().string("Hello"));
	}	

}
