package com.tom.controller;

import com.tom.entity.bean.CommonResult;
import com.tom.entity.dto.AdminDTO;
import com.tom.entity.dto.LoginDTO;
import com.tom.entity.dto.RegisterDTO;
import com.tom.exception.BasicException;
import com.tom.service.Impl.UserServiceImpl;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

import javax.validation.Valid;

/**
 * @Author BeiChen
 * @Date 2021/8/11 14:12
 * @Version 1.0
 */
@RestController
@CrossOrigin
@RequestMapping("/user")
public class userController {
    private final UserServiceImpl service;
    private final RedisTemplate redisTemplate;

    public userController(UserServiceImpl service, RedisTemplate redisTemplate) {
        this.service = service;
        this.redisTemplate = redisTemplate;
    }

    /**
     * 用户注册
     * @param registerDTO

     * @return
     */
    @PostMapping("/register")
    public CommonResult<String> Register(@Valid @RequestBody RegisterDTO registerDTO){
        if (null == redisTemplate.opsForValue().get("vc_" + registerDTO.getVerifyCode())) {
            throw new BasicException("验证码错误");
        }
        redisTemplate.delete("vc_" + registerDTO.getVerifyCode());
        Integer result = service.Register(registerDTO);

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
     * @return
     */
    @PostMapping("/login")
    public CommonResult<String> Login(@Valid @RequestBody LoginDTO loginDTO)  {
        if (null == redisTemplate.opsForValue().get("vc_" + loginDTO.getVerifyCode())) {
            throw new BasicException("验证码错误");
        }
        redisTemplate.delete("vc_" + loginDTO.getVerifyCode());
        String token = service.Login(loginDTO);
        System.out.println("Token=====>"+token);
        return new CommonResult<>(200, "OK", token);
    }

    /**
     * 普通用户提交管理员申请
     * @param adminDTO
     * @param request
     * @return
     */
    @PostMapping("/apply")
    public CommonResult<String> Apply(@Valid @RequestBody AdminDTO adminDTO, HttpServletRequest request){

        Integer result = service.Apply(adminDTO,request);

        if(result > 0){
            return new CommonResult<>(20000,"OK","申请成功，请等待审核！");
        }
        else{
            return new CommonResult<>(40000,"NO","申请失败！");
        }
    }

}
