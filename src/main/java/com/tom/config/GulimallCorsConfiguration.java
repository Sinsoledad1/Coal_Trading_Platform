package com.tom.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

/**
 * @author BeiChen
 * @version 1.0
 * @date 2021/3/27 22:32
 */
@Configuration
public class GulimallCorsConfiguration {
    /**
     * 将其加入到容器中
     * @return
     */
    @Bean
    public CorsWebFilter corsWebFilter(){
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration corsConfiguration = new CorsConfiguration();

        //1、配置跨域
        //允许哪些头跨域，这里允许所有
        corsConfiguration.addAllowedHeader("*");
        //允许哪些请求方式进行跨域
        corsConfiguration.addAllowedMethod("*");
        //允许哪些请求来源进行跨域，这里选择任意来源
        corsConfiguration.addAllowedOrigin("*");
        //是否允许携带cookie进行跨域，这里我们也允许，不允许的话，跨域就会丢失cookie
        corsConfiguration.setAllowCredentials(true);
        //“/**”意思就是，任意路径我们都进行跨域
        source.registerCorsConfiguration("/**",corsConfiguration);
        return new CorsWebFilter(source);
    }
}
