package com.boss.xtrain.permission.service;

import com.boss.xtrain.permission.pojo.dto.SystemParamDTO;
import com.boss.xtrain.permission.pojo.query.SystemParamQuery;
import com.boss.xtrain.common.core.web.service.CommonCurdService;

import java.util.List;


/**
 * @author 53534秦昀清
 * @date 2020.07.07
 */
public interface SystemParamService extends CommonCurdService<SystemParamDTO, SystemParamQuery> {

    /**
     * 搜索一个
     * @param query query
     * @return
     */
    SystemParamDTO selectOne(SystemParamQuery query);

    /**
     * 搜索树节点
     * @param query query
     * @return
     */
    List<SystemParamQuery> selectTree(SystemParamQuery query);

    /**
     * 查询组织机构所有
     *
     * @return LIST
     */
    List<SystemParamDTO> selectAllUnderOrg(Long orgId);

    /**
     * 通过 paramType 删除符合条件的值。
     * @param dto
     * @return
     */
    int deleteByParamType(SystemParamDTO dto);

}
