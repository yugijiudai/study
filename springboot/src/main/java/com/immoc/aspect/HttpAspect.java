package com.immoc.aspect;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author yugi
 * @apiNote
 * @since 2017-06-28
 */
@Aspect
@Component
@Log4j2
public class HttpAspect {


    /**
     * before和after都使用这个切点
     */
    @Pointcut("execution(public * com.immoc.controller.GirlController.*(..))")
    public void doLog() {
    }

    @Before(value = "doLog()")
    public void doBefore(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        // 记录url
        log.info("url={}", request.getRequestURL());
        // 记录请求方法
        log.info("method={}", request.getMethod());
        // 记录ip
        log.info("ip={}", request.getRemoteAddr());
        // 记录类方法
        log.info("class_method={}.{}", joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName());
        // 记录参数
        log.info("args={}", joinPoint.getArgs());
    }


    @After(value = "doLog()")
    public void doAfter() {
        log.info("2222");
    }

    @AfterReturning(pointcut = "doLog()", returning = "object")
    public void doAfterReturn(Object object) {
        log.info("response:{}", object.toString());
    }

}
