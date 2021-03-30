package com.yykj.springboot.service;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

/**
 * @Service: 包名springframework，注册@service
 */
@Service
public class UserService {

    // TODO: RPC远程调用方法
    // 1. 注解@Reference
    // 2. 引用方法：A.Pom坐标 B.定义路径相同的接口名
    // 3. 调用

    @Reference
    private ITicketService ticketService;

    public void buyTicket(){
        String ticket = ticketService.getTicket();
        System.out.println("远程调用getTicket方法,返回: " + ticket);
    }
}
