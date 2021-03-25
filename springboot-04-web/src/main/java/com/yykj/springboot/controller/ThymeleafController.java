package com.yykj.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;

@Controller
public class ThymeleafController {

    @RequestMapping("/test")
    public String thymeleafTest(Model model){
        model.addAttribute("msg", "Thymeleaf Testing !!!");
        model.addAttribute("users", Arrays.asList("tony","sum","ken"));
        return "test";
    }
}
