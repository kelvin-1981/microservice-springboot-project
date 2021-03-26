package com.yykj.springboot.controller;

import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @RequestMapping("/user/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        HttpSession session,
                        Model model){
       if(!StringUtils.isEmpty(username) && "123".equals(password)){
           session.setAttribute("user", username);
           return "redirect:/main.html";
       }
       else{
           model.addAttribute("msg","登录用户名或密码错误!");
           return "index";
       }
    }
}
