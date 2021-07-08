package com.tsn.common;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.ShiroException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Author tsn77
 * @Date 2021/7/8 17:54
 * @Version 1.0
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = RuntimeException.class)
    public  Result handler(RuntimeException e){
        log.error("运行时异常：---------{}",e);
        return Result.failure(e.getMessage()) ;
    }
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(value = ShiroException.class)
    public  Result handler(ShiroException e){
        log.error("运行时异常：---------{}",e);
        return  Result.failure("401",e.getMessage(),null);
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public  Result handler(MethodArgumentNotValidException e){
        log.error("实体校验异常：---------{}",e);
        return  Result.failure("401",e.getMessage(),null);
    }
}
