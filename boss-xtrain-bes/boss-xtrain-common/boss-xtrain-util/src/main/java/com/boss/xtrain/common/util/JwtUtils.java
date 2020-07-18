package com.boss.xtrain.common.util;

import com.alibaba.fastjson.JSON;
import com.boss.xtrain.common.core.aspect.EntityFields;
import com.boss.xtrain.common.util.Constant.JwtContant;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.security.jwt.crypto.sign.RsaVerifier;

import java.util.Map;

/**
 * 解析jwt
 *
 * @author lzx
 * @date 2020.07.18
 */
public class JwtUtils {
    public static EntityFields getInfoFromToken(String token) {
        String result = JwtHelper.decodeAndVerify(token, new RsaVerifier(JwtContant.JWT_PUBLIC_KEY)).getClaims();
        Map<String, Object> map = JSON.parseObject(result);

        EntityFields entityFields = new EntityFields();
        entityFields.setOrgId(Long.valueOf(map.get(JwtContant.ORGANIZATION_ID).toString()));
        entityFields.setCompanyId(Long.valueOf(map.get(JwtContant.COMPANY_ID).toString()));
        return entityFields;
    }
}
