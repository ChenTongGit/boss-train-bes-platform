package com.boss.xtrain.permission;

import com.boss.xtrain.common.core.aspect.EntityFields;
import com.boss.xtrain.common.util.MyStringUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.jwt.Jwt;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

@Slf4j
public class UserInfoInterceptor  implements HandlerInterceptor {
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String authorization = request.getHeader("Authorization");
        authorization = MyStringUtils.removePrefix(authorization, "Bearer ");
        if (MyStringUtils.isNotBlank(authorization) && MyStringUtils.isJwtStr(authorization)) {
            Jwt decode = JwtHelper.decode(authorization);
            String claims = decode.getClaims();
            HashMap<String, Object> hashMap = objectMapper.readValue(claims, HashMap.class);
            log.info(authorization);
            Long companyId = (Long) hashMap.get("companyId");
            Long organizationId = (Long) hashMap.get("organizationId");
            Long departmentId = Long.valueOf((Integer)hashMap.get("departmentId"));
            Long id = Long.valueOf((Integer)hashMap.get("id"));

            EntityFields entityFields = new EntityFields();
            entityFields.setCompanyId(companyId);
            entityFields.setOrgId(organizationId);
            UserContext.setUserInfo(entityFields);
        }
        return true;
    }
}
