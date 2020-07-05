package com.boss.train.bes.common.transaction.order.example.service.impl;

import com.boss.train.bes.common.transaction.order.example.dao.OrderDao;
import com.boss.train.bes.common.transaction.order.example.entity.Order;
import com.boss.train.bes.common.transaction.order.example.service.OrderService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * @description 这是订单增删改查服务的实现类
 * @author lzx
 */
@Slf4j
@Service
@Validated
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Override
    public void addOrder(Order order) {
        orderDao.add(order);
    }
    @Override
    public void addOrderFail(Order order) {
        orderDao.add(order);
        throw new IllegalArgumentException();

    }
}
