package com.yykj.springboot.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduledService {
    /**
     * 在一个特定的时间执行这个方法——Timer
     * cron表达式: 秒 分 时 日 月 周几
     */
    @Scheduled(cron = "00 04 21 * * ?")
    public void task(){
        System.out.println("Task方法执行...");
    }
}
