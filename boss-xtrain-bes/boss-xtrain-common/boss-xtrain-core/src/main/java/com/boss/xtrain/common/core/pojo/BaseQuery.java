/**
 * @file:  BaseQuery.java
 * @author: Administrator    
 * @date:   2020-6-19 11:47
 * @copyright: 2020-2023 www.bosssoft.com.cn Inc. All rights reserved. 
 */  
package com.boss.xtrain.common.core.pojo;

import java.io.Serializable;
import lombok.Data;
import lombok.ToString;
/**
 * @class BaseQuery 本质上也是dto
 * @classdesc 查询的DTO对象考虑从这里继承也建议从这里继承，服务端存在基于该类型的实现 组合查询条件
 * @author Administrator
 * @date 2020-6-19  11:04
 * @version 1.0.0
 * @see
 * @since
 */
public abstract class BaseQuery implements Serializable {
    private static final long serialVersionUID = 42432423432432L;



}
