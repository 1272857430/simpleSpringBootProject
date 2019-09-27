package com.modal.redis.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Created by 170099 on 2017/7/27.
 */
@Component
public class RedisUtils {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    private static final Logger logger = LoggerFactory.getLogger(RedisUtils.class);

    /**
     * 批量删除对应的value
     *
     * @param keys
     */
    public void remove(final String... keys) {
        for (String key : keys) {
            remove(key);
        }
    }

    /**
     * 批量删除key
     *
     * @param pattern
     */
    public void removePattern(final String pattern) {
        Set<Serializable> keys = redisTemplate.keys(pattern);
        if (!keys.isEmpty())
            redisTemplate.delete(keys);
    }

    /**
     * 删除对应的value
     *
     * @param key
     */
    public void remove(final String key) {
        if (exists(key)) {
            redisTemplate.delete(key);
        }
    }

    /**
     * 判断缓存中是否有对应的value
     *
     * @param key
     * @return
     */
    public boolean exists(final String key) {
        return redisTemplate.hasKey(key);
    }

    /**
     * 读取缓存
     *
     * @param key
     * @return
     */
    public Serializable get(final String key) {
        Serializable result = null;
        ValueOperations<Object,Serializable> operations = redisTemplate.opsForValue();
        result = operations.get(key);

        return result;
    }

    /**
     * 读取缓存
     *
     * @param key
     * @return
     */
    public String getJson(final String key) {
        String result = null;
        ValueOperations<Object,String> operations = redisTemplate.opsForValue();
        result = operations.get(key);

        return result;
    }

    /**
     * 根据匹配获取缓存
     * @param pattern
     * @return
     */
    public Set<Serializable> getJsonByPattern(final String pattern){

        return redisTemplate.keys(pattern);
    }


    /**
     * 读取缓存
     *
     * @param key
     * @return
     */
    public String getStringJson(final String key) {
        String result = null;
        ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
        result = operations.get(key);

        return result;
    }

    /**
     * 写入缓存
     *
     * @param key
     * @param value
     * @return
     */
    public boolean set(final String key, Serializable value) {
        boolean result = false;
        try {
            ValueOperations<Object,Serializable> operations = redisTemplate.opsForValue();
            operations.set(key, value);
            result = true;
        } catch (Exception e) {
            logger.error("context", e);
        }
        return result;
    }

    /**
     * 写入缓存
     *
     * @param key
     * @param value
     * @return
     */
    public boolean setJson(final String key, String value) {
        boolean result = false;
        try {
            ValueOperations<Object,String> operations = redisTemplate.opsForValue();
            operations.set(key, value);
            result = true;
        } catch (Exception e) {
            logger.error("context", e);
        }
        return result;
    }

    /**
     * 写入缓存
     *
     * @param key
     * @param value
     * @return
     */
    public boolean set(final String key, Set<? extends Serializable> value) {
        boolean result = false;
        try {
            ValueOperations<Object,Serializable> operations = redisTemplate.opsForValue();
            Serializable[] obj = new Serializable[value.size()];
            value.toArray(obj);
            operations.set(key, obj);
            result = true;
        } catch (Exception e) {
            logger.error("context", e);
        }
        return result;
    }

    /**
     * 写入缓存
     *
     * @param key
     * @param value
     * @return
     */
    public boolean set(final String key, Serializable value, Long expireTime) {
        boolean result = false;
        try {
            ValueOperations<Object,Serializable> operations = redisTemplate.opsForValue();
            operations.set(key, value);
            redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
            result = true;
        } catch (Exception e) {
            logger.error("context", e);
        }
        return result;
    }

    /**
     * 根据key获取自增后的值，Redis incr 可以实现原子性的递增，可应用于分布式序列号生成等场景
     * @return
     */
    public long getincrementValue(String redisKey){
       return redisTemplate.opsForValue().increment(redisKey, 1);
    }


    /**
     * 根据正则表达式获取对应的KEY值
     * @param keyPattern
     * @return
     */
    public Set<String> keys(String keyPattern){
        return redisTemplate.keys(keyPattern);
    }


}
