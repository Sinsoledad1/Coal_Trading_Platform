package com.tom.service.Impl;

import com.tom.dao.CompanyDao;
import com.tom.dao.UserDao;
import com.tom.entity.dto.CreateDTO;
import com.tom.entity.pojo.Company;
import com.tom.entity.pojo.User;
import com.tom.exception.BasicException;
import com.tom.service.CompanyService;
import com.tom.utils.DateTimeTransferUtil;
import com.tom.utils.IdWorker;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author BeiChen
 * @Date 2021/8/11 19:20
 * @Version 1.0
 */
@Component
@Transactional(rollbackForClassName = "Exception.class")
public class CompanyServiceImpl implements CompanyService {

    private final Pattern p = Pattern.compile("^1(3|5|7|8|4|9)\\d{9}");
    private final IdWorker idWorker;
    private final UserDao userDao;
    private final CompanyDao companyDao;
    public CompanyServiceImpl(IdWorker idWorker, UserDao userDao, CompanyDao companyDao) {
        this.idWorker = idWorker;
        this.userDao = userDao;
        this.companyDao = companyDao;
    }

    /**
     * 完善企业信息
     * @param createDTO

     * @return
     */
    @Override
    public Integer Create(CreateDTO createDTO, HttpServletRequest request) {


        Matcher m = p.matcher(createDTO.getFinancePhone());
        if (!m.matches()){
            throw new BasicException("请输入正确的手机号!");
        }

        Company company=new Company();
        BeanUtils.copyProperties(createDTO,company);
        //设置企业id
       company.setCid(idWorker.nextId()+"");
        //设置用户id
        User user = userDao.selectById((String) request.getAttribute("uid"));
        company.setUid(user.getUid());

        //设置用户的角色
        user.setRole(1);
        userDao.updateRole(user);

        //将原来session中的user去掉，存入新的user

        //设置添加时间
        company.setAddTime(DateTimeTransferUtil.getNowTimeStamp());

        System.out.println(company.toString());
        return companyDao.insert(company);
    }
}
