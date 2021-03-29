package com.yykj.springboot.controller;

import com.yykj.springboot.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(String message){
        return message;
    }

    /**
     * //只要我们的接口中，返回值中存在实体类，他就会被扫描到Swagger中
     * @return
     */
    @PostMapping("/user")
    public User user(){
        return new User();
    }
}
