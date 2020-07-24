package com.boss.xtrain.common.core.aspect;

import com.alibaba.fastjson.JSON;
import com.boss.xtrain.common.redis.api.RedisUtil;
import com.boss.xtrain.common.util.JwtUtils;
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
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;
import java.util.Map;


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
	 * 当前用户Id
	 */
	private static final String CURRENT_USER = "id";

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
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		EntityFields entityFields = getEntityFields(attributes);
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
		Object[] objects = pjp.getArgs();
		if (objects != null && objects.length > 0) {
			for (Object arg : objects) {
				EntityFields entityFields = getEntityFields(attributes);
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

	private EntityFields getEntityFields(ServletRequestAttributes attributes) {
		EntityFields entityFields = new EntityFields();

		if(attributes!=null){
			HttpServletRequest httpRequest = attributes.getRequest();
			String token = httpRequest.getHeader("Authorization");
			if (token == null){
				return null;
			}
			String parseToken = token.split(" ")[1];
			Map<String, Object> map = JSON.parseObject(JwtUtils.getParseToken(parseToken));
			entityFields.setCompanyId(((Number) map.get(COMPANY)).longValue());
			entityFields.setOrgId(((Number) map.get(ORG_ID)).longValue());
			entityFields.setCreatedBy(((Number) map.get(CURRENT_USER)).longValue());
			entityFields.setUpdatedBy(((Number) map.get(CURRENT_USER)).longValue());
			return entityFields;
		}

//		redisUtil.hashGetAll(key)
//		entityFields.setCompanyId(11L);
//		entityFields.setCreatedBy(1L);
//		entityFields.setUpdatedBy(2L);
//		entityFields.setOrgId(1L);
		return null;
	}
}
