package com.boss.xtrain.common.log.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
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
@Slf4j
public class GlobalExceptionAspect {
    
    @Pointcut(value = "@annotation(com.boss.xtrain.common.log.annotation.GlobalExceptionLog)")
    public void globalPointcut(){
        // DO NOTHING
    }

    @AfterThrowing(value = "globalPointcut()", throwing = "e")
    public void doAfterThrowing(JoinPoint joinPoint, RuntimeException e){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        /**
        log.error("dateTime:{}", dateFormat.format(new Date()));
        log.error("url:{}", request.getRequestURL());
        log.error("method:{}", request.getMethod());
        log.error("ip:{}", request.getRemoteAddr());
        log.error("class_method:{}", joinPoint.getSignature().getDeclaringTypeName() + "," + joinPoint.getSignature().getName());
        log.error("args:{}", joinPoint.getArgs());
        log.error("errMessage:{}", e.toString());
         **/
        log.error("GlobalException-MSG: dateTime:{} url:{} method:{} ip:{} class_method:[{}] args:{} errMessage:{}"
                , dateFormat.format(new Date())
                , request.getRequestURL()
                , request.getMethod()
                , request.getRemoteAddr()
                , joinPoint.getSignature().getDeclaringTypeName() + "," + joinPoint.getSignature().getName()
                , joinPoint.getArgs()
                , e.getMessage()
                , e
        );

    }
}
