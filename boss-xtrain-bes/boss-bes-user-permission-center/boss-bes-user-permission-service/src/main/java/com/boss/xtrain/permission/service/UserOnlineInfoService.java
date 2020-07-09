package com.boss.xtrain.permission.service;

import com.boss.xtrain.common.core.web.service.CommonCurdService;
import com.boss.xtrain.permission.pojo.dto.UserOnlineInfoDTO;
import com.boss.xtrain.permission.pojo.query.UserOnlineInfoQuery;

import java.util.List;

/**
 * @author 53534秦昀清
 * @date 2020.07.08
 */
public interface UserOnlineInfoService extends CommonCurdService<UserOnlineInfoDTO, UserOnlineInfoQuery> {

    /**
     * 查询所有
     * @return
     */
    List<UserOnlineInfoDTO> selectAll(UserOnlineInfoQuery query);

    /**
     * 搜索一个
     * @param query query
     * @return
     */
    UserOnlineInfoDTO selectOne(UserOnlineInfoQuery query);

    /**
     * 批量更新
     * --》批量 强制下线
     * @param dtoList
     * @return
     */
    int updateList(List<UserOnlineInfoDTO> dtoList);
}
