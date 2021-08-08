package com.tom.entity.pojo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author BeiChen
 * @version 1.0
 * @date 2020/11/28 14:15
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    /**
     * 用户自身id
     * 手机号
     * 密码
     * 联系邮箱
     * 身份(0:普通用户,1：企业用户,2:管理员)
     * 添加时间
     */
    private String Uid;
    private String Username;
    private String Password;
    private String E_mail;
    private Integer Role;
    private Long Add_time;

}
