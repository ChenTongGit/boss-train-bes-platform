package com.boss.train.bes.common.transaction.example.service.impl;

import com.boss.train.bes.common.transaction.example.dao.UserDao;
import com.boss.train.bes.common.transaction.example.entity.User;
import com.boss.train.bes.common.transaction.example.service.UserService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

/**
 * @description 这是用户增删改查服务的实现类
 * @author lzx
 */
@Slf4j
@Service
@Validated
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    @GlobalTransactional(rollbackFor = Exception.class)
    public List<User> selectByName(@NonNull String name) {
        log.info(name);
        return userDao.selectByName(name);
    }
}
