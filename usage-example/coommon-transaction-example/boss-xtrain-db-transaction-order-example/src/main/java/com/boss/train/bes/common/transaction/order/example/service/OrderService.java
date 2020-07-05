package com.boss.train.bes.common.transaction.order.example.service;

import com.boss.train.bes.common.transaction.order.example.entity.Order;

/**
 * @description 用户增删改查服务的接口
 * @author lzx
 */
public interface OrderService {
    /**
     *  添加用户信息
     * @param order 包含将添加的用户信息
     */
    void addOrder(Order order);
    /**
     *  添加用户信息,会抛出异常，以测试自动回滚
     * @param order 包含将添加的用户信息
     */
    void addOrderFail(Order order);
}
