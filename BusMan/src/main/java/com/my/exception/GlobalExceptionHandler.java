package com.my.exception;

import com.my.core.ResultData;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局公共异常类
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    //捕获指定类型的异常
    @ExceptionHandler(RuntimeException.class)
    public static ResultData handler(RuntimeException ex) {
        return ResultData.error(ex.getMessage());
    }

    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
    public Object handler(ArrayIndexOutOfBoundsException ex) {
        return ResultData.error(ex.getMessage());
    }
}
