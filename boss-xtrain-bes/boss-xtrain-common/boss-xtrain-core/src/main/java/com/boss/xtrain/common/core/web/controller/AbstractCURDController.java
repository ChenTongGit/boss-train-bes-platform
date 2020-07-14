package com.boss.xtrain.common.core.web.controller;

import com.boss.xtrain.common.core.http.CommonResponse;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * 基础curd逻辑控制器controller，公共curd方法
 * D, M, V, Q, T
 * DTO, Mapper, VO, Query, DO
 * @author ChenTong
 * @version 1.0
 * @date 2020/7/4 7:58
 * @copyright
 * @modified
 * @see
 * @since
 **/
public abstract class AbstractCURDController<D, T, V, Q, M> extends BaseController {
    // TODO 需要修改

    CommonResponse<Integer> create(@RequestBody @Valid D dtoParam){return null;}

    CommonResponse<List<V>> query(@Valid Q queryParam){return null;}

    CommonResponse<Integer> update(@RequestBody @Valid D dtoParam){return null;}

    CommonResponse<Integer> delete(@NotNull Long id){return null;}
}
