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
     * 添加时间
     */
    private String Aid;
    private String Uid;
    private String Name;
    private String Department;
    private Integer Role;
    private Long Add_time;
}
