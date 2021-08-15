package com.tom.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Author Alfalfa99
 * @Date 2020/9/13 15:54
 * @Version 1.0
 * JWT生成以及校验工具类
 */

@ConfigurationProperties("jwt.config")
@Component
public class JwtUtil {
    private String key;
    private long ttl;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public long getTtl() {
        return ttl;
    }

    public void setTtl(long ttl) {
        this.ttl = ttl;
    }

    /**
     * 生成JWT
     * (0:普通用户,1：企业用户,2:管理员)
     * @param uid
     * @return
     */
    public String createJWT(String uid, Integer role) {
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        JwtBuilder builder = Jwts.builder().setId(uid)	//在这里我们将用户的id存入Jwt中，方便后续使用
                .setIssuedAt(now)
                .signWith(SignatureAlgorithm.HS256, key).claim("role", role); //在这里我们将用户的角色存入Jwt中，方便后续鉴权,如果想存别的内容也可以往里写
        if (ttl > 0) {
            builder.setExpiration(new Date(nowMillis + ttl));
        }
        return builder.compact();
    }

    /**
     * 解析JWT
     *
     * @param jwtStr
     * @return
     */
    public Claims parseJWT(String jwtStr) {
        return Jwts.parser()
                .setSigningKey(key)
                .parseClaimsJws(jwtStr)
                .getBody();
    }
}