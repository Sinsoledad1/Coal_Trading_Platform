package com.tom.config;



import com.tom.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author Alfalfa99
 * @version 1.0
 * @date 2020/10/22 21:30
 * 拦截器配置类
 */
@Configuration
public class InterceptorConfig extends WebMvcConfigurationSupport {
    private final LoginInterceptor loginInterceptor;


    public InterceptorConfig(LoginInterceptor loginInterceptor) {
        this.loginInterceptor = loginInterceptor;

    }

    /**
     * 注册拦截器
     *
     * @param registry 拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //拦截所有目录，除了通向login的接口
        registry.addInterceptor(loginInterceptor)
                .excludePathPatterns("/**/login/**", "/**/verifyCode/**","/**/register/**")
                .excludePathPatterns("/**/*.html", "/**/*.js", "/**/*.css")
                .excludePathPatterns("/**/*.jpg","/**/*.png","/**/*,jpeg");

    }
}
