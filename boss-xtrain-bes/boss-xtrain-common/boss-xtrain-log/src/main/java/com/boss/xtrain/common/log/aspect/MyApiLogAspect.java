package com.boss.xtrain.common.log.aspect;

import com.boss.xtrain.common.log.annotation.ApiLog;
import com.boss.xtrain.common.core.exception.BusinessException;
import com.boss.xtrain.common.core.exception.error.SystemError;
import lombok.extern.slf4j.Slf4j;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;

@Aspect
@Component
@Slf4j
public class MyApiLogAspect {

    @Pointcut("@annotation(com.boss.xtrain.common.log.annotation.ApiLog)")
    public void apiPointcut(){
        log.info("进入日志切面");
    }

    @Around("apiPointcut()")
    public Object doAround(ProceedingJoinPoint joinPoint){

        long startTime = System.currentTimeMillis();
        //获取请求信息
        HttpServletRequest request = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
        String reqMsg = this.getRequestMsg(request);
        //请求参数
        Object[] args = joinPoint.getArgs();
        //获取方法名
        String methodName = joinPoint.getSignature().getName();
        //获取joinPoint所有的methods->为了获取具有注解的方法的注解内容
        Method[] methods = joinPoint.getTarget().getClass().getMethods();
        //注解中内容
        String logMsg = this.getAnnotationMsg(methods,methodName);
        //method调用并产生结果
        Object result = null;

        try {
            result = joinPoint.proceed();
        } catch (Throwable throwable) {
            log.error(throwable.getMessage(),throwable);
            //抛出异常
//            throw new BusinessException(SystemError.LOG_NOT_EXIST_ERROR,throwable);
        }
        //计算运行时间
        long execTime = System.currentTimeMillis()-startTime;
        //保存日志
        log.info("regMsg:{}, logMsg:{}, args:{}, execTime:{}ms",reqMsg,logMsg, Arrays.toString(args),execTime);
        return result;

    }

    /**
     * 获取请求方法的详细信息
     * @param res HttpServletRequest 请求
     * @return String Request信息
     */
    private String getRequestMsg(HttpServletRequest res){
        //获取请求
        if(res==null) return "requestMsg=[]";
        //获取请求ip
        String ip = res.getRemoteAddr();
        //请求者
        String reqUser = res.getRemoteUser();
        //请求时间
        String reqTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

        return String.format("[IP-%s,reqUser-%s,reqTim-%s]", ip,reqUser,reqTime);

    }

    /**
     * 获取注解中日志信息
     * @param methods joinPoint对应方法列表
     * @param targetMethod 目标函数方法名
     * @return
     */
    private String getAnnotationMsg(Method[] methods,String targetMethod){
        if (methods==null) return "logMsg:";
        String logMsg = "";
        for (Method method: methods){
            if (method.getName().equals(targetMethod)){
                ApiLog logApi = method.getAnnotation(ApiLog.class);
                logMsg = logApi.msg();
                break;
            }
        }
        return logMsg;
    }
}
