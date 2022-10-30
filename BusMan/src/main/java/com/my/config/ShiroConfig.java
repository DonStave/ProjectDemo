package com.my.config;

import com.my.util.MyShiroRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Shiro配置类
 */
@Configuration  //用jav代替过去的spring xml文件
public class ShiroConfig {

    /**
     * 拦截配置工厂
     * @return
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilter(){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager());
        //未登录（认证）跳转页面
        shiroFilterFactoryBean.setLoginUrl("/html/login.html");

        Map map  =new LinkedHashMap();
        //需要放开的请求
        //静态资源
        map.put("/static/**", "anon");
        map.put("/css/**","anon");
        map.put("/imgs/**","anon");
        map.put("/js/**","anon");
        map.put("/*.jar", "anon");
        //登录相关
        map.put("/html/login.html","anon");
        map.put("/user/login","anon");
        //注销
        map.put("/logout","logout");
        //实际做项目过程中，放开的更多
        //除了放开的全部拦截
        map.put("/**","authc");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
        return shiroFilterFactoryBean;
    }

    /**
     * 配置shiro的核心组件  securityManager
     * @return
     */
    @Bean
    public DefaultWebSecurityManager  securityManager(){
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        defaultWebSecurityManager.setRealm(myShiroRealm());
        return defaultWebSecurityManager;
    }

    /**
     * 配置安全数据桥梁
     * @return
     */
    @Bean
    public MyShiroRealm myShiroRealm(){
        MyShiroRealm myShiroRealm =new MyShiroRealm();
        myShiroRealm.setCredentialsMatcher(credentialsMatcher());
        return myShiroRealm;
    }

    /**
     * 加密
     * @return
     */
    @Bean
    public HashedCredentialsMatcher credentialsMatcher(){
        HashedCredentialsMatcher hashedCredentialsMatcher =new HashedCredentialsMatcher();
        //加密方式
        hashedCredentialsMatcher.setHashAlgorithmName("SHA-512");
       // hashedCredentialsMatcher.set
        //哈希次数
        hashedCredentialsMatcher.setHashIterations(1024);
        return hashedCredentialsMatcher;
    }

}
