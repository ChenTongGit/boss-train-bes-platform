package com.boss.xtrain.common.util;

import com.boss.xtrain.common.util.constant.JwtContant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.security.jwt.crypto.sign.RsaVerifier;

/**
 * 解析jwt
 *
 * @author lzx
 * @date 2020.07.18
 */
@Slf4j
public class JwtUtils {

    /**
     * 解析token
     * @param token
     * @return
     */
    public static String getParseToken(String token) {
        return JwtHelper.decodeAndVerify(token, new RsaVerifier(JwtContant.JWT_PUBLIC_KEY)).getClaims();
    }
}
