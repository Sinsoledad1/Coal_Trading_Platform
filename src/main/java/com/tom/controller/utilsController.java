package com.tom.controller;


import com.tom.entity.bean.CommonResult;
import com.tom.entity.bean.Image;
import com.tom.entity.bean.VerifyCode;
import com.tom.entity.pojo.User;
import com.tom.utils.ImageUploadUtil;
import com.tom.utils.VerifyCodeUtil;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @author BeiChen
 * @version 1.0
 * @date 2020/11/30 10:27
 */
@RestController
@CrossOrigin
@RequestMapping("/utils")
public class utilsController {
    private final ImageUploadUtil imageUploadUtil;
    private final RedisTemplate redisTemplate;


    public utilsController(ImageUploadUtil imageUploadUtil, RedisTemplate redisTemplate) {
        this.imageUploadUtil = imageUploadUtil;
        this.redisTemplate = redisTemplate;
    }

    /**
     * 上传图片接口

     * @param image
     * @return
     */
    @PostMapping("/image")
    public CommonResult<Object> upload( @RequestParam("image") MultipartFile image) {

        Image finalImage = imageUploadUtil.uploadImage(image);
        return new CommonResult<>(20000, "图片上传成功", finalImage);
    }

    /**
     *
     * 生成验证码并存入session
     * @param request
     * @param response
     * @throws IOException
     */
    @GetMapping("/verifyCode")
    public void getVerifyCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        VerifyCodeUtil verifyCodeUtil = new VerifyCodeUtil();
        //设置长宽
        VerifyCode verifyCode = verifyCodeUtil.generate(80, 28);
        String code = verifyCode.getCode();
        //将验证码中的字符写入redis、过期时间为300秒钟
        redisTemplate.opsForValue().set("vc_" + code, "1", 300, TimeUnit.SECONDS);
        //设置响应头
        response.setHeader("Pragma", "no-cache");
        //设置响应头
        response.setHeader("Cache-Control", "no-cache");
        //在代理服务器端防止缓冲
        response.setDateHeader("Expires", 0);
        //设置响应内容类型
        response.setContentType("image/jpeg");
        response.getOutputStream().write(verifyCode.getImgBytes());
        response.getOutputStream().flush();

        System.out.println(code);
    }


}
