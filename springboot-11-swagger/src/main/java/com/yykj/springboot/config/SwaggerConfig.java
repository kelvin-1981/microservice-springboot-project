package com.yykj.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket docket(Environment environment){

        // 设置要显示swagger的环境
        //Profiles of = Profiles.of("dev", "test");
        // 判断当前是否处于该环境
        // 通过 enable() 接收此参数判断是否要显示
        //boolean flag = environment.acceptsProfiles(of);

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                //swagger是否启动
                .enable(true)
                //分组 多个Docket 人员使用文档区分
                .groupName("tester")
                .select()
                //配置扫描接口的方式
                .apis(RequestHandlerSelectors.basePackage("com.yykj.springboot.controller"))
                //过滤路径 ant 只扫描com下接口
                //.paths(PathSelectors.ant("/com/**"))
                .build();
    }

    @Bean
    public ApiInfo apiInfo(){

        // TODO: 作者信息
        Contact contact = new Contact("tony", "www.sohu.com", "12345@qq.com");

        ApiInfo info = new ApiInfo("SpringBoot-Swagger学习项目",
                "接口文档",
                "2.0",
                "urn:tos",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());

        return info;
    }
}
