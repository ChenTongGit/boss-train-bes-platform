package com.boss.xtrain.authentication.configuration;

import com.boss.xtrain.authentication.jwt.UserJwt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.DefaultUserAuthenticationConverter;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * <p> 自定义token翻译器
 * </p>
 *
 * @author lzx
 * @version 1.0.0
 * @data 2020.07
 */
@Component
public class BesAccessTokenConverter extends DefaultAccessTokenConverter {

    @Qualifier("userDetailService")
    @Autowired
    UserDetailsService userDetailsService;

    public BesAccessTokenConverter() {
        super.setUserTokenConverter(new BesUserAuthenticationConverter());
    }

    /**
     * 配置用户认证的翻译器
     *
     * @author lzx
     * @version 1.0.0
     * @date 2020.07.15
     */
    private class BesUserAuthenticationConverter extends DefaultUserAuthenticationConverter {
        @Override
        public Map<String, ?> convertUserAuthentication(Authentication authentication) {
            LinkedHashMap response = new LinkedHashMap();
            String name = authentication.getName();
            response.put("user_name", name);

            Object principal = authentication.getPrincipal();
            UserJwt userJwt = null;
            if(principal instanceof  UserJwt){
                userJwt = (UserJwt) principal;
            } else {
                // refresh_token默认不调用userdetailService获取用户信息，这里手动调用，得到 UserJwt
                UserDetails userDetails = userDetailsService.loadUserByUsername(name);
                userJwt = (UserJwt) userDetails;
            }
            response.put("id", userJwt.getId());
            response.put("companyName", userJwt.getCompanyName());
            response.put("departmentName", userJwt.getDepartmentName());
            response.put("organizationId", userJwt.getOrganizationId());
            response.put("companyId", userJwt.getCompanyId());
            response.put("departmentId", userJwt.getDepartmentId());
            if (authentication.getAuthorities() != null && !authentication.getAuthorities().isEmpty()) {
                response.put("authorities", AuthorityUtils.authorityListToSet(authentication.getAuthorities()));
            }
            return response;
        }
    }

}