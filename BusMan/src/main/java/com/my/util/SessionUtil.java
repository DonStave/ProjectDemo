package com.my.util;

import org.apache.shiro.session.Session;

import java.util.Map;

/**
 * Author: Don
 * Session配置类
 */
public class SessionUtil {

    private static Session sessionInstance;

    /**
     * 设置session
     *
     * @param session
     */
    public static void setSession(Session session) {
        sessionInstance = session;
    }


    /**
     * 获取用户信息
     *
     * @return
     */
    public static Map getUserInfo() {
        if (sessionInstance != null) {
            return (Map) sessionInstance.getAttribute("userInfo");
        }
        return null;
    }

    /**
     * 获取用户ID
     *
     * @return
     */
    public static int getUserId() {
        if (sessionInstance != null) {
            return Integer.valueOf(((Map) sessionInstance.getAttribute("userInfo")).get("user_id") + "");
        }
        return 0;
    }

    /**
     * 获取用户名称
     *
     * @return
     */
    public static String getUserName() {
        if (sessionInstance != null) {
            return ((Map) sessionInstance.getAttribute("userInfo")).get("user_name") + "";
        }
        return "";
    }
}

