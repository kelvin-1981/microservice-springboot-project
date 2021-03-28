package com.yykj.springboot.config;

import com.sun.xml.internal.bind.v2.TODO;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
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
        // anon: 无需认证就可以访问
        // authc: 必须认证了才能访问
        // user: 必须拥有记住我功能才能用
        // perms: 拥有对某个资源的权限才能访问
        // role: 拥有某个角色权限
        Map<String, String> filterMap = new LinkedHashMap<>();
        filterMap.put("/user/add", "authc");
        filterMap.put("/user/update", "authc");
        factoryBean.setFilterChainDefinitionMap(filterMap);

        // TODO: 3.设置登录页面地址
        factoryBean.setLoginUrl("/toLogin");

        // TODO: 4.返回对象
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

}
