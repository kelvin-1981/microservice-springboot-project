package com.yykj.springboot;

import com.yykj.springboot.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springboot13DubboConsumerApplicationTests {

	@Autowired
	private UserService userService;

	@Test
	void contextLoads() {
		userService.buyTicket();
	}

}
