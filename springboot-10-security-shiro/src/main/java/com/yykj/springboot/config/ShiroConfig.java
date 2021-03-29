package com.yykj.springboot.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    /**
     * 3.创建ShiroFilterFactoryBean
     * @return
     */
    @Bean(name = "shiroFilterFactoryBean")
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager securityManager){

        ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();
        // TODO: 1.设置安全管理器
        factoryBean.setSecurityManager(securityManager);

        // TODO: 2.添加shiro内置过滤器
        Map<String, String> filterMap = new LinkedHashMap<>();

        // TODO: 2.1 设置页面访问权限 未授权转向显示未授权信息
        filterMap.put("/user/add","perms[user:add]");
        filterMap.put("/user/update","perms[user:update]");

        // TODO: 2.2 设置页面认证级别(必须认证：UserRealm的认证方法进行认证)
        // anon: 无需认证就可以访问
        // authc: 必须认证了才能访问
        // user: 必须拥有记住我功能才能用
        // perms: 拥有对某个资源的权限才能访问
        // role: 拥有某个角色权限
        filterMap.put("/user/*", "authc");

        factoryBean.setFilterChainDefinitionMap(filterMap);

        // TODO: 3.设置登录页面地址
        factoryBean.setLoginUrl("/toLogin");

        // TODO: 4.设置未授权页面
        factoryBean.setUnauthorizedUrl("/unAuth");

        // TODO: 5.返回对象
        return factoryBean;
    }

    /**
     * 2.创建securityManager
     * 注意：@Qualifier("userRealm") 直接使用本类中注册的Bean:"userRealm"
     * @param userRealm
     * @return
     */
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(userRealm);
        return securityManager;
    }

    /**
     * 1.创建realm对象:需要自定义
     * @return
     */
    @Bean(name = "userRealm")
    public UserRealm userRealm(){
        return new UserRealm();
    }

    /**
     * 配置ShiroDialect：用于shiro与thymeleaf整合
     * @return
     */
    @Bean
    public ShiroDialect getShiroDialect() {
        return new ShiroDialect();
    }

}
