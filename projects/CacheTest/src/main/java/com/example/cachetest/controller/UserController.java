package com.example.cachetest.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.cachetest.entity.User;
import com.example.cachetest.mapper.UserMapper;
import com.example.cachetest.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author ilpvc
 * @since 2023-06-24 04:50:18
 */
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@CrossOrigin
public class UserController {

    final UserService userService;
    @GetMapping("/")
    @Transactional
    public List<User> getUser() {
        List<User> users1 = userService.list(new QueryWrapper<User>().last("limit 100"));
        List<User> users2 = userService.list(new QueryWrapper<User>().last("limit 100"));
        return users1;
    }

    @GetMapping("/{id}")
    @Transactional //开启事务
    public User getUserOne(@PathVariable int id) {
        User id1 = userService.getById(id);
        User user = new User(id,"修改后的名字");
//        userService.updateById(user);
        User user1 = userService.getById(id);
        return user1;
    }

    @GetMapping("/ceshi")
    private void getUserById(){

    }
}

