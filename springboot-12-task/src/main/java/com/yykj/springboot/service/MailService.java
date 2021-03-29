package com.yykj.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.*;

@Service
public class MailService {

    @Autowired
    private JavaMailSenderImpl javaMailSender;

    public void sendSimpleMail(String subject, String text, String toMail, String fromMail){
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setSubject(subject);
        mailMessage.setText(text);
        mailMessage.setTo(toMail);
        mailMessage.setFrom(fromMail);
        javaMailSender.send(mailMessage);
    }

    public void sendMimeMail(boolean isHtml, String subject, String text, String toMail, String fromMail,
                     HashMap<String,String> attMap) throws MessagingException {
        // TODO: 1.创建邮件
        MimeMessage mail = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mail, isHtml);

        // TODO: 2.正文
        helper.setSubject(subject);
        helper.setText(text, isHtml);

        // TODO: 3.附件
        Iterator<Map.Entry<String, String>> iterator = attMap.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String, String> entry = iterator.next();
            String fileName = entry.getKey();
            String path = entry.getValue();
            helper.addAttachment(fileName,new File(path));
        }

        // TODO: 4.邮件发出信息
        helper.setTo(toMail);
        helper.setFrom(fromMail);

        javaMailSender.send(mail);
    }
}
