package com.boss.xtrain.common.core.web.controller;


import com.boss.xtrain.common.core.http.CommonResponse;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @class CommonCRUDApi
 * @classdesc
 * @author Administrator
 * @date 2020-6-26  22:09
 * @version 1.0.0
 * @see
 * @since
 */
public interface CommonCRUDApi<D,Q,V>  {

    CommonResponse<Integer> create(@RequestBody @Valid D dtoParam);

    CommonResponse<List<V>> query(@Valid Q queryParam);

    CommonResponse<Integer> update(@RequestBody @Valid D dtoParam);

    CommonResponse<Integer> delete(@NotNull Long id);
}
