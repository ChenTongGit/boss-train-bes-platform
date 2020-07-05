package com.boss.train.bes.common.transaction.order.example.controller;

import com.boss.train.bes.common.transaction.order.example.entity.Order;
import com.boss.train.bes.common.transaction.order.example.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @description 订单增删改查控制器
 * @author lzx
 */
@Slf4j
@RestController
public class OrderCrudController {
    @Autowired
    private OrderService orderService;

    /**
     * @param order 订单信息
     * @return 添加结果
     */
    @PostMapping(value = "/order_add")
    public void orderAdd(@RequestBody Order order) {
        log.info(order.toString());
        orderService.addOrder(order);
    }
    @PostMapping(value = "/order_add_fail")
    public void orderAddFail(@RequestBody Order order) {
        log.info(order.toString());
        orderService.addOrderFail(order);
    }
}
