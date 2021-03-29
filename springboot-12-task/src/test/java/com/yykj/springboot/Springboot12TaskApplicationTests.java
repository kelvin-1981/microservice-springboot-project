package com.yykj.springboot;

import com.yykj.springboot.service.MailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.HashMap;

@SpringBootTest
class Springboot12TaskApplicationTests {

	@Autowired
	private JavaMailSenderImpl javaMailSender;

	@Autowired
	private MailService mailService;

	/**
	 * 1.使用SpringBoot发出简单邮件
	 */
	@Test
	public void sendSimpleMailTest(){
		String subject = "springboot test mail";
		String text = "使用SpringBoot发出的简单邮件!";
		String toMail = "hanqi_kelvin@163.com";
		String fromMail = "hanqi_kelvin@163.com";
		mailService.sendSimpleMail(subject, text, toMail, fromMail);
	}

	/**
	 * 1.使用SpringBoot发出复杂邮件
	 */
	@Test
	public void sendMimeMailTest() throws MessagingException {
		String subject = "springboot test mail";
		String text = "<p style='color:red'>使用SpringBoot发出的复杂邮件!</p>";
		String toMail = "hanqi_kelvin@163.com";
		String fromMail = "hanqi_kelvin@163.com";

		HashMap<String, String> map = new HashMap<>();
		map.put("1.png", "d:/1.png");

		mailService.sendMimeMail(true, subject, text, toMail, fromMail, map);
	}
}
