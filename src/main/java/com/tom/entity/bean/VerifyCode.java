package com.tom.entity.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Alfalfa99
 * @version 1.0
 * @date 2020/10/22 14:35
 * 验证码实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VerifyCode {
    private String code;
    private byte[] imgBytes;
    private long expireTime;
}
