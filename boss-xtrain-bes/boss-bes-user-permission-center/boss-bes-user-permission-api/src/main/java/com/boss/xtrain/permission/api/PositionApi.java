package com.boss.xtrain.permission.api;

import com.boss.xtrain.common.core.http.CommonPage;
import com.boss.xtrain.common.core.http.CommonPageRequest;
import com.boss.xtrain.common.core.http.CommonRequest;
import com.boss.xtrain.common.core.http.CommonResponse;
import com.boss.xtrain.common.core.web.controller.CommonCRUDApi;
import com.boss.xtrain.permission.pojo.dto.PositionDTO;
import com.boss.xtrain.permission.pojo.entity.Position;
import com.boss.xtrain.permission.pojo.query.PositionQueryDTO;
import com.boss.xtrain.permission.pojo.vo.PositionListVO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.validation.Valid;
import java.util.List;

/*
 * @Author  :yushiqian
 * @Date    :10:26 2020/07/09
 * @Description :position表的接口设计
 * @Version: 1.0
 */
@RequestMapping("/education/bes/v1/position")
public interface PositionApi extends CommonCRUDApi<PositionDTO,PositionQueryDTO,PositionListVO> {

    /**
     * 列出所有
     *
     * @return 返回类型：body为所有职位
     *
    */
    @RequestMapping("/selectAll")
    CommonResponse<List<PositionListVO>> selectAllPosition();

    /**
     *分页条件搜索
     *
     * @param request 请求报文对象，传递query（本质也为dto）
     * @return 返回类型：body为带有page的positionVO对象
     *
    */
    @PostMapping("/selectByPage")
    CommonResponse<CommonPage<PositionListVO>> selectByPage(@RequestBody @Valid CommonRequest<CommonPageRequest<PositionQueryDTO>> request);


    /**
     * 分页全搜索
     *
     * @param request 请求报文对象，传递query（本质也为dto）
     * @return 返回类型：body为带有page的positionVO对象
     */
    @PostMapping("/selectAllByPage")
    CommonResponse<CommonPage<PositionListVO>> selectAllByPage(@RequestBody @Valid CommonRequest<CommonPageRequest> request);

    }
