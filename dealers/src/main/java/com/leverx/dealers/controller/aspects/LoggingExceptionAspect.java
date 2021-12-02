package com.leverx.dealers.controller.aspects;


import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingExceptionAspect {

//
//    @AfterThrowing("execution(* *())")
//    public void afterThrowingControllerAdvice(){
//
//        System.out.println("afterThrowingControllerAdvice: логируем выброс исключения");
//    }

}
