package com.boss.xtrain.common.core.web.service;

import com.boss.xtrain.common.core.web.dao.CommonMapper;
import com.boss.xtrain.common.core.pojo.BaseDTO;
import com.boss.xtrain.common.core.pojo.BaseQuery;
import com.boss.xtrain.common.core.pojo.BaseVO;


import javax.annotation.Resource;

/**
 * @author tangyi
 * @date 2018-08-25 17:22
 */
public abstract class CurdService<M extends CommonMapper<T>, T extends BaseDTO,V extends BaseVO, Q extends BaseQuery> extends BaseService {

    @Resource
    protected M dao;


}

