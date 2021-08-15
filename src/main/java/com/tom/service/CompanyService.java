package com.tom.service;

import com.tom.entity.dto.CreateDTO;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Author BeiChen
 * @Date 2021/8/11 19:20
 * @Version 1.0
 */
@Service
public interface CompanyService {

    /**
     * 完善企业信息
     * @param createDTO

     * @return
     */
    Integer Create(CreateDTO createDTO, HttpServletRequest request);
}
