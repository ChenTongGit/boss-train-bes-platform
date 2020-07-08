package com.boss.xtrain.exam.controller;

import com.boss.xtrain.common.core.http.CommonRequest;
import com.boss.xtrain.common.core.http.CommonResponse;
import com.boss.xtrain.common.core.web.controller.BaseController;
import com.boss.xtrain.common.core.web.controller.CommonCRUDApi;
import com.boss.xtrain.common.redis.api.RedisUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * test
 *
 * @author ChenTong
 * @date 2020/7/7 18:10
 * @copyright
 * @modified
 * @see
 * @since
 **/

@RestController
public class TestController extends BaseController{

    @Autowired
    private RedisUtil redisUtil;


}
