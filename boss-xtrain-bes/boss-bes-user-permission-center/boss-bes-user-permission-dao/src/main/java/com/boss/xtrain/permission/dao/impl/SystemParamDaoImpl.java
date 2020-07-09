package com.boss.xtrain.permission.dao.impl;

import com.boss.xtrain.permission.dao.SystemParamDao;
import com.boss.xtrain.permission.mapper.SystemParamMapper;
import com.boss.xtrain.permission.pojo.dto.SystemParamDTO;
import com.boss.xtrain.permission.pojo.entity.SystemParam;
import com.boss.xtrain.permission.pojo.query.SystemParamQuery;
import com.boss.xtrain.common.util.PojoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 53534秦昀清
 * @date 2020.07.06
 */
@Repository
public class SystemParamDaoImpl implements SystemParamDao {

    @Resource
    private SystemParamMapper mapper;

    /**
     * 条件查询
     *
     * @param query 组织机构query
     * @return 结果
     */
    @Override
    public List<SystemParam> selectByCondition(SystemParamQuery query) {
        SystemParam systemParam = new SystemParam();
        PojoUtils.copyProperties(query,systemParam);
        return mapper.select(systemParam);
    }

    /**
     * 找所有
     *
     * @return
     */
    @Override
    public List<SystemParam> selectAll() {
        return mapper.selectAll();
    }

    /**
     * 主键查找
     *
     * @param id
     * @return
     */
    @Override
    public SystemParam selectByKey(Long id) {
        return mapper.selectByPrimaryKey(id);
    }

    /**
     * 找一个
     *
     * @param query
     * @return
     */
    @Override
    public SystemParam selectOne(SystemParamQuery query) {
        SystemParam systemParam = new SystemParam();
        PojoUtils.copyProperties(query,systemParam);
        return mapper.selectOne(systemParam);
    }


    /**
     * 通过主键删除数据
     *
     * @param dto Object数据库主键
     * @return int
     */
    @Override
    public int delete(SystemParamDTO dto) {
        return mapper.deleteByPrimaryKey(dto.getId());
    }

    /**
     * 批量删除数据
     *
     * @param dtoList id列表
     * @return int
     */
    @Override
    public int delete(List<SystemParamDTO> dtoList) {
        int count = 0;
        for(SystemParamDTO dto:dtoList){
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
    public int update(SystemParamDTO dto) {
        SystemParam systemParam = new SystemParam();
        PojoUtils.copyProperties(dto,systemParam);
        return mapper.updateByPrimaryKey(systemParam);
    }

    /**
     * 插入数据
     *
     * @param dto T extends BaseDTO 数据传输对象
     * @return int
     */
    @Override
    public int insert(SystemParamDTO dto) {
        SystemParam systemParam = new SystemParam();
        PojoUtils.copyProperties(dto,systemParam);
        return mapper.insert(systemParam);
    }

    /**
     * 批量添加
     *
     * @param dtoList 列表
     * @return int
     */
    @Override
    public int insert(List<SystemParamDTO> dtoList) {
        List<SystemParam> list = PojoUtils.copyListProperties(dtoList,SystemParam::new);
        return mapper.insertList(list);
    }

    /**
     * 是否存在
     *
     * @param id
     * @return boolean
     */
    @Override
    public boolean existsByKey(Long id) {
        return mapper.existsWithPrimaryKey(id);
    }
}
