package com.example.redis;

import com.example.redis.service.HelloService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
class RedisApplicationTests {

	@Autowired
	HelloService helloService;

	@Test
	void contextLoads() {
	}

	@Test
	public void hello() {
		String key = "test";
		String value = "Hello World!";
		helloService.delete(key);
		Assert.isTrue(helloService.get(key) == null, "Value not null");
		helloService.set(key, value);
		Assert.isTrue(value.equals(helloService.get(key)), "Value not as expect");
	}

}
