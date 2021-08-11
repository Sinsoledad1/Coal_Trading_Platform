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
     *企业id
     *用户id
     * 企业名称
     * 企业类型
     * 法人代表
     * 法人身份证号码
     * 注册地区
     * 邮政编码
     * 企业邮箱
     * 传真
     * 联系电话
     * 组织机构代码
     * 税务登记证代码
     * 经营许可证编号
     * 营业执照号
     * 注册资金（万元）
     * 开户银行
     * 开户银行账号
     * 企业财务人员电话
     * 企业财务人员邮箱
     * 企业财务人员姓名
     * 运输方式
     * 燃煤存放地点、数量、质量
     * 企业介绍
     * 法人身份证(图片)
     * 营业执照(图片)
     * 组织机构代码证(图片)
     * 经营许可证(图片)
     * 税务登记证(图片)
     * 开户许可证(图片)
     * 添加时间
     */

    private String cid;
    private String uid;
    private String cname;
    private String cType;
    private String cRepresentative;
    private String cIdCardNum;
    private String cArea;
    private String postalCode;
    private String ceMail;
    private String cFax;
    private String telephone;
    private String organizationCode;
    private String taxCode;
    private String operatingNumber;
    private String bNumber;
    private Double regCapital;
    private String openBank;
    private String bankAccount;
    private String financePhone;
    private String financeMail;
    private String financeName;
    private String transport;
    private String locationCoal;
    private String companyProfile;
    private String cIdCard;
    private String businessLicence;
    private String orgCertificate;
    private String operatingLicense;
    private String taxRegistration;
    private String openAccount;
    private Long addTime;

}
