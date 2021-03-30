package com.yykj.springboot.service;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

/**
 * TicketService
 * @Service:可以被扫描到，在项目一启动就自动注册到注册中心,使用Dubbo后尽量不要用Service注解,现在的@service是dubbo的注解
 */
@Service
@Component
public class TicketService implements ITicketService{

    @Override
    public String getTicket() {
        return "<<人月神话>>";
    }
}
