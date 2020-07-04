package com.boss.xtrain.db.redis.lock;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.concurrent.TimeUnit;

/**
 * @author 53534秦昀清
 * @version 1.0
 * @date 2020.07.01
 */
@Slf4j
@Component(value = "lock")
public class RedisDistributionLock {

    private static final Long SUCCESS = 1L;

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    /**
     *  加锁
     * @param key key
     * @param id value
     * @param expire 缓存时间
     * @return 成功与否
     */
    public boolean getLock(String key, String id, int expire) {
        //保证获取锁和设置过期时间为原子操作
        return redisTemplate.opsForValue().setIfAbsent(key,id,expire, TimeUnit.SECONDS);
    }

    /**
     * A 进程业务还没有处理完锁过期，B进程将成功获得锁，A进程继续执行业务最后释放锁前要判断是否
     * A 进程的锁，如果不是A则不可以释放该锁，因此释放动作需要保证原子操作
     * @param key lockName
     * @param id value
     * @return 成功与否
     */
    public boolean releaseLock(String key, String id) {
        //使用lua
        String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
        RedisScript<String> redisScript = new DefaultRedisScript<>(script,String.class);
        log.info("准备释放锁",id);
        Object res = redisTemplate.execute(redisScript, Collections.singletonList(key),id);
        return res.equals(SUCCESS);
    }
}
