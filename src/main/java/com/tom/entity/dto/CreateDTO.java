package com.tom.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @Author BeiChen
 * @Date 2021/8/11 17:53
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateDTO {
    /**
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
    @NotBlank(message = "企业名称不能为空！")
    private String cname;
    @NotBlank(message = "企业类型不能为空！")
    private String cType;
    @NotBlank(message = "法人代表不能为空！")
    private String cRepresentative;
    @NotBlank(message = "法人身份证号码不能为空！")
    private String cIdCardNum;
    @NotBlank(message = "注册地区不能为空！")
    private String cArea;
    @NotBlank(message = "邮政编码不能为空！")
    private String postalCode;
    @NotBlank(message = "企业邮箱不能为空！")
    private String ceMail;
    @NotBlank(message = "传真不能为空！")
    private String cFax;
    @NotBlank(message = "联系电话不能为空！")
    private String telephone;
    @NotBlank(message = "组织机构代码不能为空！")
    private String organizationCode;
    @NotBlank(message = "税务登记证代码不能为空！")
    private String taxCode;
    @NotBlank(message = "经营许可证编号不能为空！")
    private String operatingNumber;
    @NotBlank(message = "营业执照号不能为空！")
    private String bNumber;
    @NotNull(message = "注册资金不能为空！")
    private Double regCapital;
    @NotBlank(message = "开户银行不能为空！")
    private String openBank;
    @NotBlank(message = "开户银行账号不能为空！")
    private String bankAccount;
    @NotBlank(message = "企业财务人员电话不能为空！")
    private String financePhone;
    @NotBlank(message = "企业财务人员邮箱不能为空！")
    private String financeMail;
    @NotBlank(message = "企业财务人员姓名不能为空！")
    private String financeName;
    @NotBlank(message = "运输方式不能为空！")
    private String transport;
    @NotBlank(message = "燃煤存放地点、数量、质量不能为空！")
    private String locationCoal;
    @NotBlank(message = "企业介绍不能为空！")
    private String companyProfile;
    @NotBlank(message = "法人身份证(图片)不能为空！")
    private String cIdCard;
    @NotBlank(message = "营业执照(图片)不能为空！")
    private String businessLicence;
    @NotBlank(message = "组织机构代码证(图片)不能为空！")
    private String orgCertificate;
    @NotBlank(message = "经营许可证(图片)不能为空！")
    private String operatingLicense;
    @NotBlank(message = "税务登记证(图片)不能为空！")
    private String taxRegistration;
    @NotBlank(message = "开户许可证(图片)不能为空！")
    private String openAccount;

}
