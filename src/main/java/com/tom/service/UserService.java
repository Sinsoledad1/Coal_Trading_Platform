package com.tom.service;

import com.tom.entity.dto.AdminDTO;
import com.tom.entity.dto.LoginDTO;
import com.tom.entity.dto.RegisterDTO;
import com.tom.entity.vo.LoginVO;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

/**
 * @Author BeiChen
 * @Date 2021/8/11 11:49
 * @Version 1.0
 */
@Service
public interface UserService {

    /**
     * 用户注册
     * @param registerDTO
     * @return
     */
    Integer Register(RegisterDTO registerDTO, HttpSession session);

    /**
     * 用户登录
     * @param loginDTO
     * @param session
     * @return
     */
    LoginVO Login(LoginDTO loginDTO,HttpSession session);

    /**
     * 普通用户提交管理员申请
     * @param adminDTO
     * @param session
     * @return
     */
    Integer Apply(AdminDTO adminDTO,HttpSession session);

}
