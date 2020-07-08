package com.boss.xtrain.common.redis.config;

import com.boss.xtrain.common.redis.api.RedisUtil;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yushiqian
 *
 * @date 2020/07/03
 *
 * @desciption Redis配置
 */
@Configuration
@EnableCaching
@EnableTransactionManagement
public class RedisConfig {

    /**
     * redisTemplate 相关配置
     * SuppressWarnings("all") 抑制所有类型的警告
     * 在这里抑制了redisConnectionFactory无法自动注入的警告
     * @param redisConnectionFactory 连接工厂
     * @return redisTemplate
     */
    @Bean
    @SuppressWarnings("all")
    public RedisTemplate<String,Object> redisTemplate(RedisConnectionFactory redisConnectionFactory){

        //创建redisTemplate
        RedisTemplate<String,Object> template = new RedisTemplate<>();

        //配置连接工厂
        template.setConnectionFactory(redisConnectionFactory);

        //JDK序列化方式：new JdkSerializationRedisSerializer()
        //使用Jackson2JsonRedisSerializer来序列化和反序列化redis的value值(默认是JDK的序列化方式)
        Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<>(Object.class);
        ObjectMapper om = new ObjectMapper();

        //指定要序列化的域，field,get和set,以及修饰符范围，ANY是都有包括private和public
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);

        //指定序列化输入的类型，类必须是非final修饰的，final修饰的类，比如String,Integer等会跑出异常
        //om.enableDefaultTyping已经过期,参数(ObjectMapper.DefaultTyping.NON_FINAL)
        jackson2JsonRedisSerializer.setObjectMapper(om);

        //设置key的序列化方式
        template.setKeySerializer(new StringRedisSerializer());

        //设置hashKey的序列化方式
        template.setHashKeySerializer(new StringRedisSerializer());

        //设置value的序列化方式
        template.setValueSerializer(jackson2JsonRedisSerializer);

        //设置hashValue的序列化方式
        template.setHashValueSerializer(jackson2JsonRedisSerializer);
        template.afterPropertiesSet();

        //开启事务 template.setEnableTransactionSupport(true)
        return template;
    }

    /**
     * 自定义RedisCacheManager
     * @param factory RedisConnectionFactory
     * @return RedisCacheManager
     */
    @Bean
    @SuppressWarnings("all")
    public RedisCacheManager redisCacheManager(RedisConnectionFactory factory){
        return new RedisCacheManager(
                RedisCacheWriter.nonLockingRedisCacheWriter(factory),
                //默认策略，未配置的 key 会使用这个
                this.getRedisConfigurationWithTtl(10*60),
                // 指定 key 策略
                this.getRedisCacheConfigurationMap()
        );
    }

    @Bean
    public RedisUtil getRedisUtil(){
        return new RedisUtil();
    }

    private Map<String, RedisCacheConfiguration> getRedisCacheConfigurationMap(){
        Map<String,RedisCacheConfiguration> configurationMap = new HashMap<>();
        //过期时间配置
        configurationMap.put("yourKey",this.getRedisConfigurationWithTtl(30*60));
        return configurationMap;
    }

    private RedisCacheConfiguration getRedisConfigurationWithTtl(Integer sec){
        Jackson2JsonRedisSerializer<Object> jsonRedisSerializer = new Jackson2JsonRedisSerializer<>(Object.class);
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL,JsonAutoDetect.Visibility.ANY);
        jsonRedisSerializer.setObjectMapper(om);
        RedisCacheConfiguration configuration = RedisCacheConfiguration.defaultCacheConfig();
        configuration = configuration.serializeValuesWith(
                RedisSerializationContext.SerializationPair.fromSerializer(jsonRedisSerializer)
        ).entryTtl(Duration.ofSeconds(sec));
        return configuration;
    }
}
