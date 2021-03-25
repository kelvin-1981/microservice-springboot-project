package com.yykj.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    /**
     * controller跳转页面实现首页访问
     * templates下的页面只能通过controller跳转使用
     * @return
     */
    @RequestMapping("/index")
    public String index(){
        return "index";
    }
}
