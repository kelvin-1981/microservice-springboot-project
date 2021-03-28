package com.yykj.springboot.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @EnableWebSecurity：开启WebSecurity模式
 * 作用：托管登录及认证功能
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * 安全配置：定制授权规则
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // TODO: 首页所有人可访问 功能须有对应权限
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/level1/**").hasRole("vip1")
                .antMatchers("/level2/**").hasRole("vip2")
                .antMatchers("/level3/**").hasRole("vip3");

        // TODO: 开启登录页面，无权限显示login页面
        http.formLogin();

        // TODO: 开启注销功能 & 注销成功转向首页
        http.logout().logoutSuccessUrl("/");
        //注销 & 删除cookie & 清空session
        //http.logout().deleteCookies("remove").invalidateHttpSession(true);

        // TODO: 开启记住我功能 cookie 默认2周
        http.rememberMe();
    }

    /**
     * 安全配置：定制认证规则
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // TODO: 源自内存读取授权信息 也可以使用数据库读取授权信息
        // TODO: 密码需要加密
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .withUser("admin").password(new BCryptPasswordEncoder().encode("123")).roles("vip1","vip2","vip3")
                .and()
                .withUser("sum").password(new BCryptPasswordEncoder().encode("123")).roles("vip1","vip2")
                .and()
                .withUser("guest").password(new BCryptPasswordEncoder().encode("123")).roles("vip2");
    }
}
