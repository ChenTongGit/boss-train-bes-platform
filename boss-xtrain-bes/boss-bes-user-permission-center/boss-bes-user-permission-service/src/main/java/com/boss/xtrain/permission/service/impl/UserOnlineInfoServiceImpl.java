package com.boss.xtrain.permission.service.impl;

import com.boss.xtrain.permission.pojo.dto.UserOnlineInfoDTO;
import com.boss.xtrain.permission.pojo.query.UserOnlineInfoQuery;
import com.boss.xtrain.permission.service.UserOnlineInfoService;

import java.util.List;

public class UserOnlineInfoServiceImpl implements UserOnlineInfoService {
    /**
     * 查询所有
     *
     * @return
     */
    @Override
    public List<UserOnlineInfoDTO> selectAll() {
        return null;
    }

    /**
     * 搜索一个
     *
     * @param query query
     * @return
     */
    @Override
    public UserOnlineInfoDTO selectOne(UserOnlineInfoQuery query) {
        return null;
    }

    /**
     * 通过query查找列表
     *
     * @param query Q extends BaseQuery查询条件
     * @return java.util.List<V>
     * @author ChenTong
     * @date 2020/6/22 7:05
     */
    @Override
    public List<UserOnlineInfoDTO> selectByCondition(UserOnlineInfoQuery query) {
        return null;
    }

    /**
     * 通过主键删除数据
     *
     * @param dto Object数据库主键
     * @return int
     * @author ChenTong
     * @date 2020/6/22 7:18
     */
    @Override
    public int delete(UserOnlineInfoDTO dto) {
        return 0;
    }

    /**
     * 批量删除数据
     *
     * @param dtoList id列表
     * @return int
     * @author ChenTong
     * @date 2020/7/4 9:09
     */
    @Override
    public int delete(List<UserOnlineInfoDTO> dtoList) {
        return 0;
    }

    /**
     * 更新用户数据
     *
     * @param dto T extends BaseDTO 数据传输对象
     * @return int
     * @author ChenTong
     * @date 2020/6/22 7:18
     */
    @Override
    public int update(UserOnlineInfoDTO dto) {
        return 0;
    }

    /**
     * 插入数据
     *
     * @param dto
     * @return int
     * @author ChenTong
     * @date 2020/6/22 8:18
     */
    @Override
    public int insert(UserOnlineInfoDTO dto) {
        return 0;
    }
}
