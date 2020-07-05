package com.boss.train.bes.common.transaction.order.example.dao;

import com.boss.train.bes.common.transaction.order.example.entity.Order;
import org.apache.ibatis.annotations.*;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @description 配置DAO层
 * @author lzx
 */
@Repository
@Mapper
public interface OrderDao {
    /**
     * 添加订单
     * @param order 要插入的订单信息
     */
    @Insert(value="insert into t_seata_test(name, total) values (#{userName}, #{orderTotal})")
    @Options(useGeneratedKeys=true, keyProperty="orderId")
    @Results(id = "orderMap", value = {
        @Result(property = "userName", column = "name"),
        @Result(property = "orderTotal", column = "total"),
        @Result(property = "orderId", column = "id"),
    })
    void add(Order order);
}