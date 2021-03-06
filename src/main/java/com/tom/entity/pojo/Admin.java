package com.tom.entity.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author BeiChen
 * @Date 2021/8/8 14:41
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Admin {
    /**
     * 管理员id
     * 用户id
     * 真实姓名
     * 部门
     * 身份(0:普通管理员,1:超级管理员)
     * 账号状态(0:待审核,1:拒绝,2:通过)
     * 添加时间
     */
    private String aid;
    private String uid;
    private String name;
    private String department;
    private Integer role;
    private Integer status;
    private Long addTime;
}
