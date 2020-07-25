package com.boss.xtrain.paper.aspect;

import com.boss.xtrain.common.core.exception.BusinessException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TryCatchAspect {
    @Pointcut("@annotation(com.boss.xtrain.core.annotation.TryCatch)")
    private void pointCutService() {
        //
    }

    @Around(value = "pointCutService()")
    public Object serviceLogAround(ProceedingJoinPoint point) throws Throwable {
        try {
            return point.proceed();
        } catch (BusinessException e) {
            throw new BusinessException(e.getCode(), e.getMessage(),e);
        }
    }

}
