package com.yykj.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Locale;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    /**
     * 添加视图控制
     * URL：http://localhost:8080/view 显示test.html页面
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/view").setViewName("test");
    }

    /**
     * 注册自定义视图解析器
     * @return
     */
    @Bean
    public MyViewResolvers myViewResolvers(){
        return new MyViewResolvers();
    }

    /**
     * 自定义视图解析器类
     */
    public static class MyViewResolvers implements ViewResolver{
        @Override
        public View resolveViewName(String s, Locale locale) throws Exception {
            return null;
        }
    }
}
