package com.yykj.springboot.config;

import ch.qos.logback.core.rolling.helper.TokenConverter;
import com.yykj.springboot.pojo.User;
import com.yykj.springboot.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 自定义realm对象
 */
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    /**
     * 授权方法
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        // TODO: 获取用户权限 添加至授权信息
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        Subject subject = SecurityUtils.getSubject();
        // 获取下面方法设置的User对象 new SimpleAuthenticationInfo(user,user.getPwd(),"");
        User user = (User) subject.getPrincipal();
        if(user == null){
            return  null;
        }

        info.addStringPermission(user.getPerms());
        return info;
    }

    /**
     * 认证方法: 登录页面登录操作时执行
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        User user = userService.queryUserByName(token.getUsername());
        if(user == null){
            return null;
        }

        return new SimpleAuthenticationInfo(user, user.getPwd(),"");
    }
}
