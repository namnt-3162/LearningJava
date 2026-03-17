package com.example.demo;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    // Chạy trước khi phương thức addProduct được thực thi
    @Before("execution(* com.example.demo.ProductService.addProduct(..))")
    public void logBefore() {
        System.out.println("AOP Log: Before adding product");
    }
}
