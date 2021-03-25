package com.yykj.springboot;

import com.yykj.springboot.pojo.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springboot03Jsr303ApplicationTests {

	@Autowired
	private Person person;

	@Test
	void contextLoads() {
		System.out.println(person.toString());
	}
}
