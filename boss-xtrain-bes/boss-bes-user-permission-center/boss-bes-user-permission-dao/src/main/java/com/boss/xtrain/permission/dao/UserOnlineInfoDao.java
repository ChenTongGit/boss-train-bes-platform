package com.boss.xtrain.permission.dao;

import com.boss.xtrain.permission.pojo.dto.UserOnlineInfoDTO;
import com.boss.xtrain.permission.pojo.entity.UserOnlineInfo;
import com.boss.xtrain.permission.pojo.query.UserOnlineInfoQuery;

import java.util.List;

/**
 * @author 53534秦昀清
 * @date 2020.07.06
 */
public interface UserOnlineInfoDao {
    /**
     *  条件查询
     * @param query 组织机构query
     * @return 结果
     */
    List<UserOnlineInfo> selectByCondition(UserOnlineInfoQuery query);

    /**
     * 获取所有
     * @return 列表
     */
    List<UserOnlineInfo> selectAll();

    /**
     * 主键搜索
     * @param id id
     * @return 信息
     */
    UserOnlineInfo selectByKey(Long id);


    /**
     * 找一个
     * @param query
     * @return
     */
    UserOnlineInfo selectOne(UserOnlineInfoQuery query);

    /**
     * 通过主键删除数据
     *
     * @param dto Object数据库主键
     * @return int
     */
    int delete(UserOnlineInfoDTO dto);

    /**
     * 批量删除数据
     *
     * @param dtoList id列表
     * @return int
     */
    int delete(List<UserOnlineInfoDTO> dtoList);

    /**
     * 更新用户数据
     * 下线
     * @param dto T extends BaseDTO 数据传输对象
     * @return int
     */
    int update(UserOnlineInfoDTO dto);

    /**
     * 批量下线
     * @param dtoList T extends BaseDTO 数据传输对象
     * @return int个数
     */
    int update(List<UserOnlineInfoDTO> dtoList);

    /**
     * 插入数据
     *
     * @param dto T extends BaseDTO 数据传输对象
     * @return int
     */
    int insert(UserOnlineInfoDTO dto);
}
