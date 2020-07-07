package com.boss.xtrain.common.core.web.controller;


import com.boss.xtrain.common.core.http.CommonRequest;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
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

    CommonResponseOld<Integer> create(@RequestBody @Valid CommonRequest<D> request);

    CommonResponseOld<List<V>> selectList(@RequestBody @Valid CommonRequest<Q> request);

    CommonRequest<V> select(@RequestBody @Valid CommonRequest<Q> request);

    CommonResponseOld<Integer> update(@RequestBody @Valid CommonRequest<D> request);

    CommonResponseOld<Integer> delete(@RequestBody @Valid CommonRequest<D> request);
}
