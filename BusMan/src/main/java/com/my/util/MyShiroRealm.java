package com.my.util;

import com.my.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;
import java.util.UUID;

/**
 * Author: Don
 * ShiroRealm配置类
 */
public class MyShiroRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        Object userName = authenticationToken.getPrincipal();
        //获取用户  realm  DAO 专门用来作为桥梁，取安全数据
        Map userMap = userService.getUserByUserName(userName + "");
        //用户的map为null  说明当前用户名查询不到结果
        if (userMap == null) {
            throw new AccountException();
        }
        // 用户名正确时，把加密加盐后的密码和盐值都交给SecutiryManager 进行认证
        return new SimpleAuthenticationInfo(userMap, userMap.get("password") + "",
                ByteSource.Util.bytes(userMap.get("salt") + ""), getName());
    }

    public static void main(String[] args) {
        System.out.println((UUID.randomUUID() + "").length());
    }
}
