package com.ldf.demo.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import sun.net.www.protocol.http.HttpURLConnection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: 清峰
 * @date: 2020/9/23 21:13
 * @code: 愿世间永无Bug!
 * @description: 定义拦截类 拦截跳转地
 */
public class LoginInterceptor  extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (request.getSession().getAttribute("user")==null){
            response.sendRedirect("/admin");
            return false;
        }
        return true;
    }
}
