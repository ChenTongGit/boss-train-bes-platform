package com.boss.xtrain.permission.controller;

import com.boss.xtrain.common.core.http.CommonRequest;
import com.boss.xtrain.common.core.http.CommonResponse;
import com.boss.xtrain.permission.pojo.dto.ResourceDTO;
import com.boss.xtrain.permission.pojo.query.ResourceQueryDTO;
import com.boss.xtrain.permission.pojo.vo.ResourceListVO;
import com.boss.xtrain.permission.service.ResourceService;
import com.boss.xtrain.permission.api.ResourceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/*
 * @Author  :yushiqian
 * @Date    :16:06 2020/07/09
 * @Description :resource api实现
 * @Version: 1.0
 */

@RestController
public class ResourceController implements ResourceApi {

    @Autowired
    private ResourceService resourceService;

    @Override
    public CommonResponse<Integer> insert(@Valid CommonRequest<ResourceDTO> request) {
        return null;
    }

    @Override
    public CommonResponse<Integer> delete(@Valid CommonRequest<ResourceDTO> request) {
        return null;
    }

    @Override
    public CommonResponse<List<ResourceListVO>> selectList(@Valid CommonRequest<ResourceQueryDTO> request) {
        return null;
    }

    @Override
    public CommonResponse<ResourceListVO> select(@Valid CommonRequest<ResourceQueryDTO> request) {
        return null;
    }

    @Override
    public CommonResponse<Integer> update(@Valid CommonRequest<ResourceDTO> request) {
        return null;
    }

    @Override
    public CommonResponse<Integer> deletePatch(@Valid CommonRequest<List<ResourceDTO>> request) {
        return null;
    }
}
