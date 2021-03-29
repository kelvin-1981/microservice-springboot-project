package com.yykj.springboot.controller;

import com.yykj.springboot.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * SpringBoot异步任务的测试案例类
 */
@RestController
public class ServiceController {

    @Autowired
    private AsyncService asyncService;

    @GetMapping("/service")
    public String service(){
        asyncService.service();
        return "sucess";
    }
}
