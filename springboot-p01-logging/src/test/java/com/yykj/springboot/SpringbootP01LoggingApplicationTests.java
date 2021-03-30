package com.yykj.springboot;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootP01LoggingApplicationTests {

	//日志记录器：slf4j
	Logger logger = LoggerFactory.getLogger(getClass());

	@Test
	void contextLoads() {
		//日志记录及日志级别
		logger.trace("this is trace message...");
		logger.debug("this is debug message...");
		//spring默认提供info级别日志[root级别]
		//可自设置：logging.level.com.yykj=trace
		logger.info("this is info message...");
		logger.warn("this is warn message...");
		logger.error("this is error message...");
	}

}
