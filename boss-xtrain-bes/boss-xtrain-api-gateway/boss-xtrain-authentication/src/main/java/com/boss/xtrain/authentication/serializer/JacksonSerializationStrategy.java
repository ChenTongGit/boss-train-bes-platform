package com.boss.xtrain.authentication.serializer;

import com.alibaba.fastjson.util.IOUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.google.common.base.Preconditions;
import org.springframework.security.oauth2.common.exceptions.SerializationException;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStoreSerializationStrategy;

import java.nio.charset.Charset;

/**
 * 继承自RedisTokenStoreSerializationStrategy
 * 使用默认的jdk的序列化方式会产生问题，所以自定义序列化策略
 *
 * @author lzx
 * @version 1.0.0
 */
public class JacksonSerializationStrategy implements RedisTokenStoreSerializationStrategy {
    protected static ObjectMapper mapper = new ObjectMapper();

    {
        SimpleModule module = new SimpleModule();
        module.addDeserializer(OAuth2Authentication.class,
            new Jackson2Deserializer(OAuth2Authentication.class));
        mapper.registerModule(module);
    }

    /**
     * 进行反序列化
     * @param bytes bytes
     * @param clazz clazz
     * @param <T> 泛型
     * @return 返回结果
     */
    @Override
    public <T> T deserialize(byte[] bytes, Class<T> clazz) {
        Preconditions.checkArgument(clazz != null,
            "clazz can't be null");
        if (bytes == null || bytes.length == 0) {
            return null;
        }
        try {
            return mapper.readValue(new String(bytes, IOUtils.UTF8), clazz);
        } catch (Exception ex) {
            throw new SerializationException("Could not serialize: " + ex.getMessage(), ex);
        }
    }

    @Override
    public String deserializeString(byte[] bytes) {
        if (bytes == null || bytes.length == 0) {
            return null;
        }
        return new String(bytes, IOUtils.UTF8);
    }

    @Override
    public byte[] serialize(Object object) {
        if (object == null) {
            return new byte[0];
        }

        try {
            return mapper.writeValueAsBytes(object);
        } catch (Exception ex) {
            throw new SerializationException("Could not serialize: " + ex.getMessage(), ex);
        }
    }

    @Override
    public byte[] serialize(String data) {
        if (data == null || data.length() == 0) {
            return new byte[0];
        }

        return data.getBytes(Charset.forName("utf-8"));
    }
}
