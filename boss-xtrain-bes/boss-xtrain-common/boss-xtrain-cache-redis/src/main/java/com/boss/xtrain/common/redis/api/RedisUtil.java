package com.boss.xtrain.common.redis.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @author 53534 秦昀清
 * @version 1.0
 * @date 2020.07.02
 * 封装RedisTemplate的各种方法,实现RedisUtil接口
 * opsForValue ：对应 String（字符串）
 * opsForHash：对应 Hash（哈希）
 * opsForList：对应 List（列表）
 * opsForSet：对应 Set（集合）
 */
@Slf4j
@Component
public class RedisUtil {

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    /**
     * 给指定的KEY附加缓存时间
     *
     * @param key  标识（键）
     * @param time 缓存时间(秒)
     * @return 成功与否
     */
    public boolean expire(String key, long time) {
        try{
            if(time>0){
                redisTemplate.expire(key,time,TimeUnit.SECONDS);
            }
            return true;
        }catch (Exception e){
            log.error(e.getMessage(),e);
            return false;
        }
    }

    /**
     * 根据KEY获取过期时间
     *
     * @param key key 键 不能为null
     * @return 时间(秒) 返回0代表为永久有效
     */
    public long getExpire(String key) {
        return redisTemplate.getExpire(key,TimeUnit.SECONDS);
    }

    //--------------------------------公共方法--------------------------------------//
    /**
     * 判断key是否存在
     *
     * @param key 键
     * @return true 存在 false不存在
     */
    public boolean hasKay(String key) {
        try{
            return redisTemplate.hasKey(key);
        }catch (Exception e){
            log.error(e.getMessage(),e);
            return false;
        }
    }

    /**
     * 删除缓存
     *
     * @param key 可以传一个值 或多个
     */
    public void delete(String... key) {
        if(key!=null&&key.length>0){
            if(key.length==1){
                redisTemplate.delete(key[0]);
            }else{
                redisTemplate.delete(CollectionUtils.arrayToList(key));
            }
        }
    }

    //--------------------------------String--------------------------------------//
    /**
     * 普通的String类型的缓存获取
     *
     * @param key 键
     * @return 值
     */
    public Object get(String key) {
        return key==null?null:redisTemplate.opsForValue().get(key);
    }

    /**
     * 普通缓存存入
     *
     * @param key   键
     * @param value 值
     * @return 成功与否
     */
    public boolean set(String key, Object value) {
        try{
            redisTemplate.opsForValue().set(key,value);
            log.info("redis set "+key+":"+value);
            return true;
        }catch (Exception e){
            log.error(e.getMessage(),e);
            return false;
        }
    }

    /**
     * 普通缓存存入并设置时间
     *
     * @param key   键
     * @param value 值
     * @param time  缓存时间(秒) time要大于0 如果time小于等于0 将设置无限期
     * @return 成功与否
     */
    public boolean set(String key, Object value, long time) {
        try{
            if(time>0){
                redisTemplate.opsForValue().set(key,value,time,TimeUnit.SECONDS);
            }else{
                set(key,value);
            }
            return true;
        }catch (Exception e){
            log.error(e.getMessage(),e);
            return false;
        }
    }

    /**
     * 获取原来key键对应的值并重新赋新值
     *
     * @param key   键
     * @param value 值
     * @return 原来key键对应的值
     */
    public Object update(String key, Object value) {
        return redisTemplate.opsForValue().getAndSet(key, value);
    }

    //--------------------------------hash/Map--------------------------------------//
    /**
     * hashGet
     *
     * @param key     键 不能为null
     * @param hashKey 项 不能为null
     * @return 获取值
     */
    public Object hashGet(String key, String hashKey) {
        return redisTemplate.opsForHash().get(key,hashKey);
    }

    /**
     * 获取hashKey对应的所有键值
     *
     * @param key 键
     * @return 键对应的多个值
     */
    public Map<Object, Object> hashGetAll(String key) {
        return redisTemplate.opsForHash().entries(key);
    }

    /**
     * HashSet加入缓存
     *
     * @param key 键
     * @param map 对应多个键值
     * @return 成功与否
     */
    public boolean hashSet(String key, Map<String, Object> map) {
        try{
            redisTemplate.opsForHash().putAll(key,map);
            return  true;
        }catch (Exception e){
            log.info(e.getMessage(),e);
            return false;
        }
    }

    /**
     * HashSet
     *
     * @param key  键
     * @param map  对应多个键值
     * @param time 缓存时间(秒)
     * @return 成功与否
     */
    public boolean hashSet(String key, Map<String, Object> map, long time) {
        try{
            redisTemplate.opsForHash().putAll(key,map);
            if(time>0){
                expire(key,time);
            }
            return true;
        }catch (Exception e){
            log.info(e.getMessage(),e);
            return false;
        }
    }

    /**
     * HashSet加入缓存
     *
     * @param key     键
     * @param hashKey hashKey
     * @param value   值
     * @return 成功与否
     */
    public boolean hashSet(String key, String hashKey, Object value) {
        try{
            redisTemplate.opsForHash().put(key,hashKey,value);
            return true;
        }catch (Exception e){
            log.info(e.getMessage(),e);
            return false;
        }
    }

    /**
     * HashSet加入缓存
     *
     * @param key     键
     * @param hashKey hashKey
     * @param value   值
     * @param time    缓存时间 s
     * @return 成功与否
     */
    public boolean hashSet(String key, String hashKey, Object value, long time) {
        try{
            redisTemplate.opsForHash().put(key,hashKey,value);
            if(time>0){
                expire(key,time);
            }
            return true;
        }catch (Exception e){
            log.info(e.getMessage(),e);
            return false;
        }
    }

    /**
     * 删除hash表中的值
     *
     * @param key     值
     * @param hashKey 项
     * @return 删除成功的数量
     */
    public Long hashDelete(String key, Object... hashKey) {
        return redisTemplate.opsForHash().delete(key, hashKey);
    }

    /**
     * 判断hash表中是否有该项的值
     *
     * @param key     值
     * @param hashKey 项
     * @return 是否存在
     */
    public boolean hasHashKey(String key, String hashKey) {
        return redisTemplate.opsForHash().hasKey(key,hashKey);
    }

    //--------------------------------Set--------------------------------------//
    /**
     * 根据key获取Set中的所有值
     *
     * @param key 键
     * @return 获取的set
     */
    public Set<Object> setGet(String key) {
        try{
            return redisTemplate.opsForSet().members(key);
        }catch (Exception e){
            log.error(e.getMessage(),e);
            return null;
        }
    }

    /**
     * 根据value从一个set中查询,是否存在
     *
     * @param key   键
     * @param value 值
     * @return 是否存在
     */
    public boolean setHasKey(String key, Object value) {
        try{
            return redisTemplate.opsForSet().isMember(key, value);
        }catch (Exception e){
            log.error(e.getMessage(),e);
            return false;
        }
    }

    /**
     * 将数据放入set缓存
     *
     * @param key    键
     * @param values 值
     * @return 成功个数
     */
    public long sSet(String key, Object... values) {
        try{
            return redisTemplate.opsForSet().add(key, values);
        }catch (Exception e){
            log.info(e.getMessage(),e);
            return 0;
        }
    }

    /**
     * 将数据放入set缓存并设置缓存时间
     *
     * @param key    键
     * @param time   缓存时间 s
     * @param values 值
     * @return 成功个数
     */
    public long sSet(String key, long time, Object... values) {
        try{
            Long count = redisTemplate.opsForSet().add(key,values);
            if(time>0){
                expire(key, time);
            }
            return count;
        }catch (Exception e){
            log.info(e.getMessage(),e);
            return 0;
        }
    }

    /**
     * 获取缓存的长度
     *
     * @param key 键
     * @return 长度
     */
    public long getSetSize(String key) {
        try{
            return redisTemplate.opsForSet().size(key);
        }catch (Exception e){
            log.info(e.getMessage(),e);
            return 0;
        }
    }

    /**
     * 批量移除set缓存中值为value的元素
     *
     * @param key    键
     * @param values 值
     * @return 删除的个数
     */
    public long setRemove(String key, Object... values) {
        try{
            return redisTemplate.opsForSet().remove(key, values);
        }catch (Exception e){
            log.info(e.getMessage(),e);
            return 0;
        }
    }

    /**
     * 弹出元素并删除
     *
     * @param key 值
     * @return 被删除的值
     */
    public Object popValue(String key) {
        return redisTemplate.opsForSet().pop(key);
    }

    /**
     * 检查给定的元素是否在变量中。
     *
     * @param key  键
     * @param item 元素对象
     * @return 是否存在
     */
    public boolean isSetMember(String key, Object item) {
        return redisTemplate.opsForSet().isMember(key,item);
    }

    /**
     * 随机获取变量中的元素
     *
     * @param key 键
     * @return Object值
     */
    public Object getSetRandomMember(String key) {
        return redisTemplate.opsForSet().randomMember(key);
    }

    /**
     * 随机获取变量中指定个数的元素
     *
     * @param key   键
     * @param count 要获取的个数
     * @return 获取的元素列表
     */
    public List<Object> getSetRandomMembers(String key, long count) {
        return redisTemplate.opsForSet().randomMembers(key, count);
    }

    /**
     * 通过给定的key求2个set变量的差值
     *
     * @param key     键
     * @param destKey 键
     * @return 差值
     */
    public Set<Object> difference(String key, String destKey) {
        return redisTemplate.opsForSet().difference(key, destKey);
    }

    //--------------------------------List--------------------------------------//
    /**
     * 获取list缓存的内容
     *
     * @param key   键
     * @param start 开始
     * @param end   结束 0 到 -1代表所有值
     * @return 获取到的内容列表
     */
    public List<Object> listGet(String key, long start, long end) {
        try{
            return redisTemplate.opsForList().range(key, start, end);
        }catch (Exception e){
            log.info(e.getMessage(),e);
            return null;
        }
    }

    /**
     * 通过索引获取list中的值
     *
     * @param key   键
     * @param index 索引
     * @return 值
     */
    public Object listGetByIndex(String key, long index) {
        try{
            return redisTemplate.opsForList().index(key, index);
        }catch (Exception e){
            log.info(e.getMessage(),e);
            return null;
        }
    }

    /**
     * 获取list缓存的长度
     *
     * @param key 键
     * @return 长度
     */
    public long listGetSize(String key) {
        try{
            return redisTemplate.opsForList().size(key);
        }catch (Exception e){
            log.info(e.getMessage(),e);
            return 0;
        }
    }

    /**
     * 加入缓存
     *
     * @param key   键
     * @param value 值
     * @return 是否成功
     */
    public boolean listSet(String key, Object value) {
        try {
            redisTemplate.opsForList().rightPush(key, value);
            return true;
        }catch (Exception e){
            log.info(e.getMessage(),e);
            return false;
        }
    }

    /**
     * 加入缓存并设置时间
     *
     * @param key   键
     * @param value 值
     * @param time  缓存时间
     * @return 是否成功
     */
    public boolean listSet(String key, Object value, long time) {
        try {
            redisTemplate.opsForList().rightPush(key, value);
            if(time>0){
                expire(key, time);
            }
            return true;
        }catch (Exception e){
            log.info(e.getMessage(),e);
            return false;
        }
    }

    /**
     * list加入缓存
     *
     * @param key   键
     * @param value 值
     * @return 是否成功
     */
    public boolean listSet(String key, List<Object> value) {
        try {
            redisTemplate.opsForList().rightPushAll(key,value);
            return true;
        }catch (Exception e){
            log.info(e.getMessage(),e);
            return false;
        }
    }

    /**
     * list加入缓存并设置时间
     *
     * @param key   键
     * @param value 值
     * @param time  缓存时间
     * @return 是否成功
     */
    public boolean listSet(String key, List<Object> value, long time) {
        try {
            redisTemplate.opsForList().rightPushAll(key,value);
            if(time>0){
                expire(key, time);
            }
            return true;
        }catch (Exception e){
            log.info(e.getMessage(),e);
            return false;
        }
    }

    /**
     * 根据索引修改list中的某条数据
     *
     * @param key   键
     * @param index 索引
     * @param value 值
     * @return 是否成功
     */
    public boolean listUpdate(String key, long index, Object value) {
        try{
            redisTemplate.opsForList().set(key, index, value);
            return true;
        }catch (Exception e){
            log.info(e.getMessage(),e);
            return false;
        }
    }

    /**
     * 移除N个键为key值为value
     *
     * @param key   键
     * @param count 移除个数
     * @param value 值
     * @return 成功移除的个数
     */
    public long listRemove(String key, long count, Object value) {
        try{
            return redisTemplate.opsForList().remove(key, count, value);
        }catch (Exception e){
            log.info(e.getMessage(),e);
            return 0;
        }
    }

    /**
     * 移除集合中的左边第一个元素。
     *
     * @param key 值
     * @return 是否成功
     */
    public Object leftPop(String key) {
        return redisTemplate.opsForList().leftPop(key);
    }

    /**
     * 移除集合中左边的元素在等待的时间里，如果超过等待的时间仍没有元素则退出。
     *
     * @param key     值
     * @param timeout 等待时间的值
     * @param unit    等待时间的单位
     * @return 是否成功
     */
    public Object leftPop(String key, long timeout, TimeUnit unit) {
        return redisTemplate.opsForList().leftPop(key, timeout, unit);
    }

    /**
     * 移除集合中右边的元素。
     *
     * @param key 值
     * @return 是否成功
     */
    public Object rightPop(String key) {
        return redisTemplate.opsForList().rightPop(key);
    }

    /**
     * 移除集合中右边的元素在等待的时间里，如果超过等待的时间仍没有元素则退出。
     *
     * @param key     值
     * @param timeout 等待时间的值
     * @param unit    等待时间的单位
     * @return 是否成功
     */
    public Object rightPop(String key, long timeout, TimeUnit unit) {
        return redisTemplate.opsForList().rightPop(key, timeout, unit);
    }
}
