package com.tom.interceptor;

import com.tom.entity.pojo.User;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author Alfalfa99
 * @version 1.0
 * @date 2020/10/22 21:16
 * 检查是否登录
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("User");
        if (user == null||user.getUid() == null){
            throw new AccessDeniedException("请先登录！");
        }
        return true;
    }
}
