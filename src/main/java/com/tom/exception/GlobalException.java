package com.tom.exception;

import com.tom.entity.bean.CommonResult;
import lombok.extern.log4j.Log4j;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.AuthorizationServiceException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

import java.util.List;

/**
 * @author Alfalfa99
 * @version 1.0
 * @date 2020/10/22 18:10
 * 全局异常处理类
 */
@RestControllerAdvice
@Log4j
public class GlobalException {

    /**
     * 捕获所有（Exception.class）中的异常并通过下面的方法返回
     *
     * @param e 错误类型
     * @return 给前端返回报错信息
     */
    @ExceptionHandler(value = Exception.class)
    public CommonResult<String> toHandleUnexpectException(Exception e) {
        e.printStackTrace();
        return new CommonResult<>(500,"Error","出现了预料外的错误请联系管理员！："+ e.getMessage());
    }

    @ExceptionHandler(value = BasicException.class)
    public CommonResult<String> toHandleException(Exception e) {
        e.printStackTrace();
        return new CommonResult<>(500,"Error",e.getMessage());
    }

    @ExceptionHandler(value = MaxUploadSizeExceededException.class)
    public CommonResult<String> uploadException(Exception e) {
        e.printStackTrace();
        return new CommonResult<>(500,"Error","文件体积过大");
    }
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public CommonResult<String> validException(MethodArgumentNotValidException e){
        BindingResult result = e.getBindingResult();
        if (result.hasErrors()) {
            List<ObjectError> errors = result.getAllErrors();
            if (!errors.isEmpty()) {
                // 这里列出了全部错误参数，按正常逻辑，只需要第一条错误即可
                FieldError fieldError = (FieldError) errors.get(0);
                return new CommonResult<>(500, "Error", fieldError.getDefaultMessage());
            }
        }
        return new CommonResult<>(500, "Error", "参数验证错误");
    }

    @ExceptionHandler(value = AccessDeniedException.class)
    public CommonResult<String> accessDeniedException(){
        return new CommonResult<>(401, "Error", "请先登录");
    }

    @ExceptionHandler(value = AuthorizationServiceException.class)
    public CommonResult<String> unAuthorization(){
        return new CommonResult<>(403, "Error", "权限不足");
    }
}
