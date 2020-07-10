package com.boss.xtrain.permission.dao.impl;

import com.boss.xtrain.permission.dao.UserOnlineInfoDao;
import com.boss.xtrain.permission.mapper.UserOnlineInfoMapper;
import com.boss.xtrain.permission.pojo.dto.UserOnlineInfoDTO;
import com.boss.xtrain.permission.pojo.entity.UserOnlineInfo;
import com.boss.xtrain.permission.pojo.query.UserOnlineInfoQuery;
import com.boss.xtrain.common.util.PojoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 53534秦昀清
 * @date 2020.07.06
 */
@Repository
public class UserOnlineInfoDaoImpl implements UserOnlineInfoDao {

    @Resource
    private UserOnlineInfoMapper mapper;

    /**
     * 条件查询
     *
     * @param query 组织机构query
     * @return 结果
     */
    @Override
    public List<UserOnlineInfo> selectByCondition(UserOnlineInfoQuery query) {
        UserOnlineInfo info = new UserOnlineInfo();
        PojoUtils.copyProperties(query,info);
        return mapper.select(info);
    }

    /**
     * 获取所有
     *
     * @return 列表
     */
    @Override
    public List<UserOnlineInfo> selectAllOrigin(List<Long> userIds) {
        UserOnlineInfo info = new UserOnlineInfo();
        List<UserOnlineInfo> infoList = new ArrayList<>();
        for(Long userId:userIds){
            info.setUserId(userId);
            info = mapper.selectOne(info);
            infoList.add(info);
        }
        return infoList;
    }

    /**
     * 无条件获取所有
     *
     * @return 列表
     */
    @Override
    public List<UserOnlineInfo> selectAll() {
        return mapper.selectAll();
    }

    /**
     * 主键搜索
     *
     * @param id id
     * @return 信息
     */
    @Override
    public UserOnlineInfo selectByKey(Long id) {
        return mapper.selectByPrimaryKey(id);
    }

    /**
     * 找一个
     *
     * @param query query
     * @return one
     */
    @Override
    public UserOnlineInfo selectOne(UserOnlineInfoQuery query) {
        UserOnlineInfo info = new UserOnlineInfo();
        PojoUtils.copyProperties(query,info);
        return mapper.selectOne(info);
    }

    /**
     * 通过主键删除数据
     *
     * @param dto Object数据库主键
     * @return int
     */
    @Override
    public int delete(UserOnlineInfoDTO dto) {
        return mapper.deleteByPrimaryKey(dto.getId());
    }

    /**
     * 批量删除数据
     *
     * @param dtoList id列表
     * @return int
     */
    @Override
    public int delete(List<UserOnlineInfoDTO> dtoList) {
        int count = 0;
        for(UserOnlineInfoDTO dto:dtoList){
            if(mapper.deleteByPrimaryKey(dto.getId())!=0){
                count++;
            }
        }
        return count;
    }

    /**
     * 更新用户数据
     *
     * @param dto T extends BaseDTO 数据传输对象
     * @return int
     */
    @Override
    public int update(UserOnlineInfoDTO dto) {
        UserOnlineInfo info = new UserOnlineInfo();
        PojoUtils.copyProperties(dto,info);
        return mapper.updateByPrimaryKey(info);
    }

    /**
     * 批量下线
     *
     * @param dtoList T extends BaseDTO 数据传输对象
     * @return int个数
     */
    @Override
    public int update(List<UserOnlineInfoDTO> dtoList) {
        List<UserOnlineInfo> infoList = PojoUtils.copyListProperties(dtoList,UserOnlineInfo::new);
        int count = 0;
        for(UserOnlineInfo info:infoList){
            if(mapper.updateByPrimaryKey(info)!=0){
                count++;
            }
        }
        return count;
    }

    /**
     * 插入数据
     *
     * @param dto T extends BaseDTO 数据传输对象
     * @return int
     */
    @Override
    public int insert(UserOnlineInfoDTO dto) {
        UserOnlineInfo info = new UserOnlineInfo();
        PojoUtils.copyProperties(dto,info);
        return mapper.insert(info);
    }

    /**
     * 是否存在
     *
     * @param id id
     * @return if exist
     */
    @Override
    public boolean existsByKey(Long id) {
        return mapper.existsWithPrimaryKey(id);
    }
}
