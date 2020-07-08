package com.boss.xtrain.permission.service;

import com.boss.xtrain.common.core.web.service.CommonCurdService;
import com.boss.xtrain.permission.pojo.dto.UserOnlineInfoDTO;
import com.boss.xtrain.permission.pojo.query.UserOnlineInfoQuery;

import java.util.List;

public interface UserOnlineInfoService extends CommonCurdService<UserOnlineInfoDTO, UserOnlineInfoQuery> {

    /**
     * 查询所有
     * @return
     */
    List<UserOnlineInfoDTO> selectAll();

    /**
     * 搜索一个
     * @param query query
     * @return
     */
    UserOnlineInfoDTO selectOne(UserOnlineInfoQuery query);

}
