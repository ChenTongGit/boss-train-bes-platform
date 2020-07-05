package com.boss.train.bes.common.transaction.user.example.controller;

import com.boss.train.bes.common.transaction.user.example.entity.User;
import com.boss.train.bes.common.transaction.user.example.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * @description 用户增删改查控制器
 * @author lzx
 */
@Slf4j
@RestController
public class UserCrudController {
    @Autowired
    private UserService userService;
    /**
     * @param user 用户信息
     * @return 查询结果
     */
    @PostMapping(value = "/user_list")
    public List<User> userQuery(@RequestBody User user) {
        log.info(user.toString());
        return userService.selectByName(user.getUserName());
    }

    /**
     * @param user 用户信息，每个userName都应该是唯一的，前端进行了简单的密码、用户名长度校验
     * @return 添加结果
     */
    @PostMapping(value = "/user_add")
    public List<User> userAdd(@RequestBody User user) {
        log.info(user.toString());
        return userService.addUser(user);
    }
    /**
     * @param user 用户信息，每个userName都应该是唯一的，前端进行了简单的密码、用户名长度校验
     * @return 添加结果
     */
    @PostMapping(value = "/user_add_fail")
    public List<User> userAddFail(@RequestBody User user) {
        log.info(user.toString());
        return userService.addUserFail(user);
    }
}
