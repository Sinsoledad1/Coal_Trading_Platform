package com.tom.entity.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author BeiChen
 * @Date 2021/8/8 14:44
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Company {
    /**
     * 企业id
     * 用户id
     * 企业名称
     * 企业类型
     * 法人代表
     * 法人身份证号码
     * 注册地区
     * 企业邮箱
     * 传真
     * 邮政编码
     * 注册资金（万元）
     * 营业执照号
     * 组织机构代码
     * 经营许可证编号
     * 税务登记证代码
     * 开户银行
     * 银行账号
     * 添加时间
     */

    private String Cid;
    private String Uid;
    private String Cname;
    private String Ctype;
    private String Crepresentative;
    private String CIDcard;
    private String Carea;
    private String Ce_mail;
    private String Cfax;
    private String PostalCode;
    private Double Regcapital;
    private String BusiNo;
    private String Orgcode;
    private String BusilicNo;
    private String Coderegcer;
    private String Bankofdeposit;
    private String Bankacount;
    private String Add_time;

}
