package com.tom.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author BeiChen
 * @Date 2021/8/11 16:08
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginVO {
    /**
     * 用户自身id
     * 手机号
     * 联系邮箱
     * 身份(0:普通用户,1：企业用户,2:管理员)
     * sessionId
     * 添加时间
     */
    private String uid;
    private String username;
    private String eMail;
    private Integer role;
    private String sessionId;
    private Long addTime;
}
