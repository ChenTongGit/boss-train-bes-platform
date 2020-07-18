package com.boss.xtrain.authentication.feign.factory;

import com.boss.xtrain.authentication.feign.PermissonServiceClient;
import com.boss.xtrain.authentication.feign.fallback.PermissonServiceClientFallbackImpl;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * 用户断路器工厂
 */
@Component
public class PermissonServiceClientFallbackFactory implements FallbackFactory<PermissonServiceClient> {

    @Override
    public PermissonServiceClient create(Throwable throwable) {
        PermissonServiceClientFallbackImpl userServiceClientFallback = new PermissonServiceClientFallbackImpl();
        userServiceClientFallback.setThrowable(throwable);
        return userServiceClientFallback;
    }

}
