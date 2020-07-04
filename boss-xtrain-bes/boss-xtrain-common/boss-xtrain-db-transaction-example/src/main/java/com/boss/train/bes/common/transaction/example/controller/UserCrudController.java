package com.boss.train.bes.common.transaction.example.controller;

import com.boss.train.bes.common.transaction.example.entity.User;
import com.boss.train.bes.common.transaction.example.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @description 用户增删改查控制器
 * @author lzx
 */
@Slf4j
@CrossOrigin
@RestController
@RefreshScope
public class UserCrudController {
    @Autowired
    private UserService userService;

    /**
     * 分页功能尚未实现
     * @param user 用户信息
     * @return 查询结果
     */
    @PostMapping(value = "/user_list")
    public List<User> userQuery(@RequestBody User user) {
        log.info(user.toString());
        return userService.selectByName(user.getUserName());
    }
}
