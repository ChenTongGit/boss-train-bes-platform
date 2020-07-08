package com.boss.xtrain.common.core.aspect;

import com.boss.xtrain.common.redis.api.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.BeanUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import java.util.Date;


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
@Slf4j
public class EntityFieldStufferAspect {

	@Resource
	private RedisUtil redisUtil;

	/**
	 * 创建人属性
	 */
	private static final String CREATE_BY = "createdBy";
	/**
	 * 更新人属性
	 */
	private static final String UPDATE_BY = "updatedBy";
	/**
	 * 组织ID属性
	 */
	private static final String ORG_ID = "orgId";
	/**
	 * 公司ID属性
	 */
	private static final String COMPANY = "companyId";

	/**
	 * 创建时间
	 */
	private static final String CREATE_TIME = "createdTime";

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
		log.info("update");
		EntityFields entityFields = getEntityFields();
		if (entityFields == null) return pjp.proceed();

		Object[] objects = pjp.getArgs();
		if (objects != null && objects.length > 0) {
			for (Object arg : objects) {
				BeanUtils.setProperty(arg, UPDATE_BY , entityFields.getUpdatedBy());
				BeanUtils.setProperty(arg, COMPANY, entityFields.getCompanyId());
				BeanUtils.setProperty(arg, ORG_ID, entityFields.getOrgId());
			}
		}

		return pjp.proceed();

	}

	@Around("daoCreate()")
	public Object doAroundCreate(ProceedingJoinPoint pjp) throws Throwable {
		log.info("create");
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		if (attributes == null) {
			return pjp.proceed();
		}
		Object[] objects = pjp.getArgs();
		if (objects != null && objects.length > 0) {
			for (Object arg : objects) {
				EntityFields entityFields = getEntityFields();
				if (entityFields == null) {
					continue;
				}
				BeanUtils.setProperty(arg, COMPANY, entityFields.getCompanyId());
				BeanUtils.setProperty(arg, ORG_ID, entityFields.getOrgId());
				BeanUtils.setProperty(arg, CREATE_BY, entityFields.getCreatedBy());
				BeanUtils.setProperty(arg, CREATE_TIME, new Date());
			}
		}
		log.info(getEntityFields().toString());
		return pjp.proceed();
	}

	private EntityFields getEntityFields() {
		//TODO		return SecurityUtils.getUserID();从自定义token中获取数据 || 从缓存中获取EntityFields entityFields =(EntityFields) redisUtil.get("current:"+"id");
		EntityFields entityFields = new EntityFields();
//		redisUtil.hashGetAll(key)
		entityFields.setCompanyId(11L);
		entityFields.setCreatedBy(1L);
		entityFields.setUpdatedBy(2L);
		entityFields.setOrgId(1L);
		return entityFields;
	}
}
