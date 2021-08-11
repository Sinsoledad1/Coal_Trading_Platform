package com.tom.controller;

import com.tom.entity.bean.CommonResult;
import com.tom.entity.dto.AdminDTO;
import com.tom.entity.dto.LoginDTO;
import com.tom.entity.dto.RegisterDTO;
import com.tom.entity.vo.LoginVO;
import com.tom.service.Impl.UserServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * @Author BeiChen
 * @Date 2021/8/11 14:12
 * @Version 1.0
 */
@RestController
@RequestMapping("/user")
public class UserController {
    private final UserServiceImpl service;

    public UserController(UserServiceImpl service) {
        this.service = service;
    }

    /**
     * 用户注册
     * @param registerDTO
     * @param request
     * @return
     */
    @PostMapping("/register")
    public CommonResult<String> Register(@Valid @RequestBody RegisterDTO registerDTO, HttpServletRequest request){
        HttpSession session = request.getSession();
        int result = service.Register(registerDTO,session);

        if(result > 0){
            return new CommonResult<>(200,"OK","注册成功！");
        }
        else{
            return new CommonResult<>(400,"NO","注册失败！");
        }
    }

    /**
     * 用户登录
     * @param loginDTO
     * @param request
     * @return
     */
    @PostMapping("/login")
    public CommonResult<LoginVO> Login(@Valid @RequestBody LoginDTO loginDTO, HttpServletRequest request)  {
        HttpSession session=request.getSession();
        LoginVO userShowVO = service.Login(loginDTO, session);
        return new CommonResult<>(200, "OK", userShowVO);
    }

    /**
     * 普通用户提交管理员申请
     * @param adminDTO
     * @param request
     * @return
     */
    @PostMapping("/apply")
    public CommonResult<String> Apply(@Valid @RequestBody AdminDTO adminDTO, HttpServletRequest request){
        HttpSession session = request.getSession();
        int result = service.Apply(adminDTO,session);

        if(result > 0){
            return new CommonResult<>(20000,"OK","申请成功，请等待审核！");
        }
        else{
            return new CommonResult<>(40000,"NO","申请失败！");
        }
    }

}
