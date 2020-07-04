package com.boss.train.bes.common.log.aspect;

import com.boss.train.bes.common.log.aspect.MyApiLogAspect;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

@Aspect
@Component
@Configuration
public class GlobalExceptionAspect {

    private static final Logger logger = LoggerFactory.getLogger(MyApiLogAspect.class);

    @Pointcut(value = "@annotation(com.boss.train.bes.common.log.annotation.GlobalExceptionLog)")
    public void globalPointcut(){

    }

    @Before("globalPointcut()")
    public void deBefore(JoinPoint joinPoint){

    }

    @AfterThrowing(value = "globalPointcut()", throwing = "e")
    public void doAfterThrowing(JoinPoint joinPoint, RuntimeException e){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        logger.error("dateTime:", dateFormat.format(new Date()));
        logger.error("url:", request.getRequestURL());
        logger.error("method:", request.getMethod());
        logger.error("ip:", request.getRemoteAddr());
        logger.error("class_method:", joinPoint.getSignature().getDeclaringTypeName() + "," + joinPoint.getSignature().getName());
        logger.error("args:", joinPoint.getArgs());
        logger.error("errMessage:", e.toString());

    }
}
