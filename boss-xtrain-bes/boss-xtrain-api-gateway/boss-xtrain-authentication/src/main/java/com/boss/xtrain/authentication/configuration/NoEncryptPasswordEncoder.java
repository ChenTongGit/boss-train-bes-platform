package com.boss.xtrain.authentication.configuration;

import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * 无加密密码验证
 *
 * @author lzx
 * @since 1.0.0
 */
public class NoEncryptPasswordEncoder implements PasswordEncoder {

    @Override
    public String encode(CharSequence charSequence) {
        return (String) charSequence;
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        return s.equals((String) charSequence);
    }
}
