package com.boss.xtrain.common.core.aspect;

import com.boss.xtrain.common.redis.api.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.BeanUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;


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
	private static final String ORG_ID = "organizationId";
	/**
	 * 公司ID属性
	 */
	private static final String COMPANY = "companyId";

	/**
	 * 数据版本号version
	 */
	private static final String VERSION = "version";

	/**
	 * 创建时间
	 */
	private static final String CREATE_TIME = "createdTime";

	/**
	 * 状态创建时默认为0
	 */
	private static final String STATUS = "status";

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
				if (arg instanceof List){
					for ( Object item:(List)arg) {
						BeanUtils.setProperty(item, UPDATE_BY , entityFields.getUpdatedBy());
						BeanUtils.setProperty(item, COMPANY, entityFields.getCompanyId());
						BeanUtils.setProperty(item, ORG_ID, entityFields.getOrgId());
					}
				}else {
					BeanUtils.setProperty(arg, UPDATE_BY , entityFields.getUpdatedBy());
					BeanUtils.setProperty(arg, COMPANY, entityFields.getCompanyId());
					BeanUtils.setProperty(arg, ORG_ID, entityFields.getOrgId());
				}

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
				if (arg instanceof List){
					for ( Object item:(List)arg) {
						setCommonProperty(item,entityFields);
					}
				}else {
					setCommonProperty(arg, entityFields);
				}


			}
		}
		log.info(getEntityFields().toString());
		return pjp.proceed();
	}

	private void setCommonProperty(Object item, EntityFields fields) throws InvocationTargetException, IllegalAccessException {
		BeanUtils.setProperty(item, COMPANY, fields.getCompanyId());
		BeanUtils.setProperty(item, ORG_ID, fields.getOrgId());
		BeanUtils.setProperty(item, CREATE_BY, fields.getCreatedBy());
		BeanUtils.setProperty(item, CREATE_TIME, new Date());
		BeanUtils.setProperty(item, VERSION, 0);
		BeanUtils.setProperty(item, STATUS, 0);
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
