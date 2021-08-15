package com.tom.interceptor;


import com.tom.utils.JwtUtil;
import io.jsonwebtoken.Claims;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class TokenInterceptor implements HandlerInterceptor {

    private final JwtUtil jwtUtil;

    public TokenInterceptor(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    /**
     * 通过拦截器对请求头进行校验
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        //获取token
        String token = request.getHeader("Authorization");
        System.out.println("request.getHeader===========>"+token);

        if (token != null && !"".equals(token)) {
                //验证token
                try {
                    Claims claims = jwtUtil.parseJWT(token);
                    Integer role = (Integer) claims.get("role");
                    if (role != null) {
                        request.setAttribute("uid",claims.getId());
                        request.setAttribute("role",role);
                        return true;
                    } else {
                        throw new BadCredentialsException("令牌已失效");
                    }
                } catch (Exception e) {
                    throw new BadCredentialsException("令牌已失效");
                }
            }
        throw new AuthenticationCredentialsNotFoundException("请先登录");
    }
}
