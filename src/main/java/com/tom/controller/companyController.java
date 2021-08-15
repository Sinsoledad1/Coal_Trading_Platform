package com.tom.controller;

import com.tom.entity.bean.CommonResult;
import com.tom.entity.dto.CreateDTO;
import com.tom.service.Impl.CompanyServiceImpl;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * @Author BeiChen
 * @Date 2021/8/11 17:21
 * @Version 1.0
 */
@RestController
@CrossOrigin
@RequestMapping("/company")
public class companyController {
    private final CompanyServiceImpl service;

    public companyController(CompanyServiceImpl service) {
        this.service = service;
    }

    /**
     * 完善公司信息
     * @param createDTO
     * @param request
     * @return
     */
    @PostMapping("/create")
    public CommonResult<String> Create(@Valid @RequestBody CreateDTO createDTO, HttpServletRequest request){


        int result = service.Create(createDTO,request);

        if(result > 0){
            return new CommonResult<>(20000,"OK","企业信息完善成功！");
        }
        else{
            return new CommonResult<>(40000,"NO","创建失败！");
        }
    }
}
