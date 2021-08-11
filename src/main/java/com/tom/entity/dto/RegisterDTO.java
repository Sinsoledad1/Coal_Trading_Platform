package com.tom.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

/**
 * @Author BeiChen
 * @Date 2021/8/11 11:54
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterDTO {
    @NotBlank(message = "手机号码不能为空！")
    private String username;
    @NotBlank(message = "密码不能为空！")
    private String password;
    @NotBlank(message = "确认密码不能为空！")
    private String confirmPassword;
    @NotBlank(message = "邮箱不能为空！")
    private String eMail;
    @NotBlank(message = "验证码不许为空")
    private String verifyCode;
}
