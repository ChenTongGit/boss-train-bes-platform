package com.boss.train.bes.common.log.aspect;

import com.boss.train.bes.common.log.exception.BusinessException;
import com.boss.train.bes.common.log.exception.error.SystemError;
import org.aspectj.lang.JoinPoint;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

@Aspect
@Component
public class MyApiLogAspect {

    private static final Logger logger = LoggerFactory.getLogger(MyApiLogAspect.class);

    private ThreadLocal<Date> startTime = new ThreadLocal<>();

    @Pointcut("@annotation(com.boss.train.bes.common.log.annotation.ApiLog)")
    public void apiPointcut(){
        logger.info("进入日志切面");
    }

    @Before("apiPointcut()")
    public void doBefore(JoinPoint joinPoint){
        try{
            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            HttpServletRequest request = attributes.getRequest();

            startTime.set(new Date(System.currentTimeMillis()));

            logger.info("日志开始打印......");
            logger.info("IP : {}", request.getRemoteAddr());
            logger.info("TIME \uff1a{}", startTime.get());
            logger.info("URL:{}", request.getRequestURL());
            logger.info("HTTP_METHOD : {}", request.getMethod());
            logger.info("CLASS_METHOD : {}.{}", joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName());
            logger.info("ARGS : {}", joinPoint.getArgs());
            logger.info("日志结束打印......");
        } catch (Exception e){
            throw new BusinessException(SystemError.LOG_NOT_EXIST_ERROR,e.getCause());
        }
    }


    @AfterReturning(returning = "ret", pointcut = "apiPointcut()")
    public void doAfterReturning(Object ret){
        try{
            SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            Date endTime = new Date();
            String time = dateFormat.format(endTime);
            Float costTime = (endTime.getTime()-startTime.get().getTime())/1000f;
            logger.info("日志打印开始......");
            logger.info("TIME \uff1a{}", time);
            logger.info("COST_TIME \uff1a{}", costTime);
            logger.info("RESPONSE : {}", ret);
            logger.info("日志打印结束......");
            startTime.remove();
        } catch (Exception e){
            throw new BusinessException(SystemError.LOG_NOT_EXIST_ERROR,e.getCause());
        }
    }
}
