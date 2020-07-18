package com.boss.xtrain.permission.api;

import com.boss.xtrain.common.core.http.CommonPage;
import com.boss.xtrain.common.core.http.CommonPageRequest;
import com.boss.xtrain.common.core.http.CommonRequest;
import com.boss.xtrain.common.core.http.CommonResponse;
import com.boss.xtrain.common.core.web.controller.CommonCRUDApi;
import com.boss.xtrain.permission.pojo.dto.RoleDTO;
import com.boss.xtrain.permission.pojo.entity.ResourceTreeNode;
import com.boss.xtrain.permission.pojo.query.ResourceQueryDTO;
import com.boss.xtrain.permission.pojo.query.RoleQueryDTO;
import com.boss.xtrain.permission.pojo.vo.ResourceListVO;
import com.boss.xtrain.permission.pojo.vo.RoleListVO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

/*
 * @Author  :yushiqian
 * @Date    :15:51 2020/07/09
 * @Description :role api 接口设计
 * @Version: 1.0
 */
@RequestMapping("/education/bes/v1/role")
public interface RoleApi extends CommonCRUDApi<RoleDTO,RoleQueryDTO,RoleListVO> {
    /**
     *
     *
     * @param request
     * @return CommonResponse<CommonPage<PositionListVO>>
     *
     */
    @PostMapping("/selectByPage")
    CommonResponse<CommonPage<ResourceListVO>> selectByPage(@RequestBody @Valid CommonRequest<CommonPageRequest<RoleQueryDTO>> request);
    /**
     * 列出所有
     *
     * @param
     * @return CommonResponse<List<PositionListVO>>
     *
     */
    @RequestMapping("/selectAll")
    CommonResponse<List<RoleListVO>> selectAllRole();


}
