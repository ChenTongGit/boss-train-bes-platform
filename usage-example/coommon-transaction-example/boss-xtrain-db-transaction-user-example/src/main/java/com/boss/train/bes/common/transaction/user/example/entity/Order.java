package com.boss.train.bes.common.transaction.user.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @description 与数据库表的信息对应
 * @author lzx
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order implements Serializable {
    String userName;
    Double orderTotal;
    Integer orderId;
}
