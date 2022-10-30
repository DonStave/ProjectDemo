package com.my.inter;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Author: Don
 * 自定义拦截器类
 */
public class LoginInter implements HandlerInterceptor {

    // 预处理
    // 在控制器的方法执行之前执行的
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requesturi = request.getRequestURI();
        if (requesturi.indexOf("/login") >= 0) {
            //说明在编辑页面
            HttpSession session = request.getSession();
            String username = String.valueOf(session.getAttribute("username"));
            if (username != null) {
                return true;
            } else {
                System.out.println("尚未登录");
                request.getRequestDispatcher("/home/login.html").forward(request, response);
                return false;
            }
        } else {
            return false;
        }

    }

    //   在控制器的方法执行之后并且是（视图渲染之前）在返回 ModelAndView之前执行
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("之后处理");
    }

    //控制器中所有的操作完成之后执行（资源的释放）
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("所有操作完成之后");
    }
}
