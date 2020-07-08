package com.boss.xtrain.common.core.web.dao;

import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * 公共Mapper,继承通用Mapper
 *
 * @author ChenTong
 * @version 1.0
 * @date 2020/7/4 8:01
 * @copyright
 * @modified
 * @see
 * @since
 **/
public interface CommonMapper<T> extends MySqlMapper<T>, Mapper<T> ,IdsMapper<T> {

}
