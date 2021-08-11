package com.tom.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

/**
 * @Author BeiChen
 * @Date 2021/8/12 0:34
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminDTO {
    /**
     * 真实姓名
     * 部门
     * 身份(0:普通管理员,1:超级管理员)
     * 账号状态(0:待审核,1:拒绝,2:通过)
     * 添加时间
     */
    @NotBlank(message = "真实姓名不能为空！")
    private String name;
    @NotBlank(message = "部门不能为空！")
    private String department;
}
