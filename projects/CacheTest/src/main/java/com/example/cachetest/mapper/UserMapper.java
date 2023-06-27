package com.example.cachetest.mapper;

import com.example.cachetest.Cache.MybatisRedisCache;
import com.example.cachetest.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.cache.decorators.FifoCache;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ilpvc
 * @since 2023-06-24 04:50:18
 */
@Mapper
@CacheNamespace(implementation = MybatisRedisCache.class)
public interface UserMapper extends BaseMapper<User> {

}
