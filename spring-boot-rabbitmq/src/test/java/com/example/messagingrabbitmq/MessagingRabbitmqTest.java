package com.example.messagingrabbitmq;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MessagingRabbitmqTest {

	@Autowired
	private Sender sender;

	@Test
	void contextLoads() {
		
	}

	@Test
	public void hello() throws Exception {
		sender.send("Hello World!");
	}

}
