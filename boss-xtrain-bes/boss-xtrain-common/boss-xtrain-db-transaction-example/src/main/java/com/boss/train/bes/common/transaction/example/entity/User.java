package com.boss.train.bes.common.transaction.example.entity;

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
public class User implements Serializable {
    int userId;
    String userName;
    String userCode;
    String userPwd;
}
