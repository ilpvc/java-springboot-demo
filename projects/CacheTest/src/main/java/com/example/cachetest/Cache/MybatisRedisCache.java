package com.example.cachetest.Cache;

import com.example.cachetest.SpringUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.cache.Cache;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Description:
 *
 * @date:2023/6/26 14:24
 * @author: ilpvc
 */

@Slf4j
public class MybatisRedisCache implements Cache {

    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private RedisTemplate<String,Object> redisTemplate;

    private final String nameSpace;

    private RedisTemplate<String,Object> getRedisTemplate(){
        this.redisTemplate = SpringUtils.getBean("redisTemplate",RedisTemplate.class);
        return redisTemplate;
    }

    public MybatisRedisCache(String nameSpace){
        if (nameSpace==null) {
            throw new IllegalArgumentException("Cache instances require an ID");
        }
        this.nameSpace = nameSpace;

    }

    @Override
    public String getId() {
        return this.nameSpace;
    }

    @Override
    public void putObject(Object key, Object value) {
        getRedisTemplate().opsForValue().set(String.valueOf(key),value,10, TimeUnit.MINUTES);
    }

    @Override
    public Object getObject(Object o) {
        return getRedisTemplate().opsForValue().get(String.valueOf(o));
    }

    @Override
    public Object removeObject(Object o) {
        return getRedisTemplate().opsForValue().getAndDelete(String.valueOf(o));
    }

    @Override
    public void clear() {
        Set<String> keys = getRedisTemplate().keys("*");
        if (keys!=null){
            getRedisTemplate().delete(keys);
        }
    }

    @Override
    public int getSize() {
        Set<String> keys = getRedisTemplate().keys("*");
        if (keys==null){
            throw new NullPointerException();
        }
        return keys.size();
    }

    @Override
    public ReadWriteLock getReadWriteLock() {
        return this.readWriteLock;
    }
}
