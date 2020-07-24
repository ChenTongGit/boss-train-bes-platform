package com.boss.xtrain.exam.configuration;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.boss.xtrain.common.util.JwtUtils;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author ChenTong
 * @date 2020/7/23 16:34
 * @copyright
 * @modified
 * @see
 * @since
 **/
public class TokenUtil {
    private TokenUtil(){}

    /**
     * 获取当前用户id
     * @author ChenTong
     * @param attributes ServletRequestAttributes
     * @return java.lang.Long
     * @date 2020/7/23 17:33
     */
    public static Long getCurrentUser(ServletRequestAttributes attributes){
        if(attributes!=null){
            HttpServletRequest httpRequest = attributes.getRequest();
            String token = httpRequest.getHeader("Authorization");
            String parseToken = token.split(" ")[1];
            Map<String, Object> map = JSON.parseObject(JwtUtils.getParseToken(parseToken));
            return ((Number) map.get("id")).longValue();
        }else{
            return -1L;
        }
    }

    /**
     * 获取当前用户公司id
     * @param attributes ServletRequestAttributes
     * @return
     */
    public static Long getCompanyId(ServletRequestAttributes attributes){
        if(attributes!=null){
            HttpServletRequest httpRequest = attributes.getRequest();
            String token = httpRequest.getHeader("Authorization");
            String parseToken = token.split(" ")[1];
            Map<String, Object> map = JSON.parseObject(JwtUtils.getParseToken(parseToken));
            return ((Number) map.get("companyId")).longValue();
        }else{
            return -1L;
        }
    }
}
