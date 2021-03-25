package com.yykj.springboot;

import com.yykj.springboot.pojo.Person;
import com.yykj.springboot.pojo.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springboot02ConfigApplicationTests {

	@Autowired
	private Person person;

	@Autowired
	private Student student;

	/**
	 * 使用yaml配置文件实现自动注入
	 */
	@Test
	public void yamlAutowiredTest(){
		System.out.println(person.toString());
	}

	/**
	 * 使用Peoperties配置文件实现自动注入
	 */
	@Test
	public void peopertiesAutowiredTest(){
		System.out.println(student.toString());
	}
}
