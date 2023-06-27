package com.example.cachetest.service.impl;

import com.example.cachetest.entity.User;
import com.example.cachetest.mapper.UserMapper;
import com.example.cachetest.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ilpvc
 * @since 2023-06-24 04:50:18
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
