package com.boss.xtrain.authentication.feign.factory;

import com.boss.xtrain.authentication.feign.PermissonServiceClient;
import com.boss.xtrain.authentication.feign.fallback.PermissonFallbackImpl;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * 用户断路器工厂
 *
 * @author lzx
 * @version 1.0.0
 */
@Component
public class PermissonFallbackFactory implements FallbackFactory<PermissonServiceClient> {

    @Override
    public PermissonServiceClient create(Throwable throwable) {
        PermissonFallbackImpl userServiceClientFallback = new PermissonFallbackImpl();
        userServiceClientFallback.setThrowable(throwable);
        return userServiceClientFallback;
    }

}
