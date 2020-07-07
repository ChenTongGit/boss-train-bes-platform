package com.boss.xtrain.common.core.web.controller;

//<<<<<<< HEAD
//import com.boss.xtrain.common.core.http.CommonRequest;
//<<<<<<< HEAD
//=======
//>>>>>>> ec196c19161b6052da7b188091925d8c86834f85
//import com.boss.xtrain.common.core.http.CommonResponse;
//=======
//>>>>>>> dev-ct
//import org.springframework.web.bind.annotation.RequestBody;
//
//import javax.validation.Valid;
//<<<<<<< HEAD
//=======
//import javax.validation.constraints.NotNull;
//>>>>>>> ec196c19161b6052da7b188091925d8c86834f85
//import java.util.List;

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
//
//<<<<<<< HEAD
//<<<<<<< HEAD
//    CommonResponse<Integer> create(@RequestBody @Valid CommonRequest<D> request);
//=======
//    CommonResponseOld<Integer> create(@RequestBody @Valid CommonRequest<D> request);
//>>>>>>> dev-ct
//    CommonResponseOld<List<V>> selectList(@RequestBody @Valid CommonRequest<Q> request);
//
//    CommonRequest<V> select(@RequestBody @Valid CommonRequest<Q> request);
//
//    CommonResponseOld<Integer> update(@RequestBody @Valid CommonRequest<D> request);
//
//<<<<<<< HEAD
//    CommonResponse<Integer> delete(@RequestBody @Valid CommonRequest<D> request);
//=======
//    CommonResponse<Integer> create(@RequestBody @Valid D dtoParam);
//
//    CommonResponse<List<V>> query(@Valid Q queryParam);
//
//    CommonResponse<Integer> update(@RequestBody @Valid D dtoParam);
//
//    CommonResponse<Integer> delete(@NotNull Long id);
//>>>>>>> ec196c19161b6052da7b188091925d8c86834f85
//=======
//    CommonResponseOld<Integer> delete(@RequestBody @Valid CommonRequest<D> request);
//>>>>>>> dev-ct
}
