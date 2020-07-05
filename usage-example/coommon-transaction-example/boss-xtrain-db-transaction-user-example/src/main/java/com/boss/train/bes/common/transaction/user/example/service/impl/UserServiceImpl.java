package com.boss.train.bes.common.transaction.user.example.service.impl;

import com.boss.train.bes.common.transaction.user.example.dao.UserDao;
import com.boss.train.bes.common.transaction.user.example.entity.Order;
import com.boss.train.bes.common.transaction.user.example.entity.User;
import com.boss.train.bes.common.transaction.user.example.feign.OrderFeignClient;
import com.boss.train.bes.common.transaction.user.example.service.UserService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

/**
 * @description 这是用户增删改查服务的实现类
 * @author lzx
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    @Resource
    private OrderFeignClient orderFeignClient;

    @Override
    public List<User> selectByName(String name) {
        log.info(name);
        return userDao.selectByName(name);
    }

    @GlobalTransactional(rollbackFor = Exception.class)
    @Override
    public List<User> addUser(User user) {
        userDao.add(user);
        orderFeignClient.orderAdd(new Order("Li", 5.1, 0));
        return userDao.selectByName(user.getUserName());
    }

    @GlobalTransactional(rollbackFor = Exception.class)
    @Override
    public List<User> addUserFail(User user) {
        userDao.add(user);
        orderFeignClient.orderAddFail(new Order("Li", 5.1, 0));
        return userDao.selectByName(user.getUserName());
    }
}
