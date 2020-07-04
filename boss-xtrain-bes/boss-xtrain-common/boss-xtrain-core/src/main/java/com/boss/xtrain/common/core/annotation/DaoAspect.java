package com.boss.xtrain.common.core.annotation;

import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;



/**
 * 共有表属性添加到dao操作中
 * @author ChenTong
 * @version 1.0
 * @date 2020/7/4 6:57
 * @copyright
 * @modified
 * @see
 * @since
 **/
@Aspect
@Component
@Configuration
public class DaoAspect {
	private static final String CREATE_BY = "createBy";
	private static final String UPDATE_BY = "updateBy";

	@Pointcut("execution(* com.boss.xtrain.*.dao.*.update*(..))")
	public void daoUpdate() {
		// DO NOTHING
	}

	@Pointcut("execution(* com.boss.xtrain.*.dao.*.insert*(..))")
	public void daoCreate() {
		// DO NOTHING
	}

	@Around("daoUpdate()")
	public Object doAroundUpdate(ProceedingJoinPoint pjp) throws Throwable {
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		if (attributes == null) {
			return pjp.proceed();
		}
		HttpServletRequest request = attributes.getRequest();
		String token = request.getHeader("token");
		String username = getUserName();
		if (token != null && username != null) {
			Object[] objects = pjp.getArgs();
			if (objects != null && objects.length > 0) {
				for (Object arg : objects) {
					BeanUtils.setProperty(arg, UPDATE_BY , username);
				}
			}
		}
		return pjp.proceed();

	}

	@Around("daoCreate()")
	public Object doAroundCreate(ProceedingJoinPoint pjp) throws Throwable {
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		if (attributes == null) {
			return pjp.proceed();
		}
		Object[] objects = pjp.getArgs();
		if (objects != null && objects.length > 0) {
			for (Object arg : objects) {
				String username = getUserName();
				if (username == null) {
					continue;
				}
				if (StringUtils.isBlank(BeanUtils.getProperty(arg, CREATE_BY))) {
					BeanUtils.setProperty(arg, CREATE_BY, username);
				}
			}
		}
		return pjp.proceed();
	}

	private String getUserName() {
		//TODO		return SecurityUtils.getUsername();
		if (new Random(20).nextInt()<10){
			return null;
		}
		return "test user";
	}
}
