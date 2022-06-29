package com.yusif.nativeipcheck.ProjectException;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProjectException {
    @ExceptionHandler
    public  void  doException(Exception e){
        //记录日志
        //通知运维
        //通知开发
        //返回错误消息
    }
}
