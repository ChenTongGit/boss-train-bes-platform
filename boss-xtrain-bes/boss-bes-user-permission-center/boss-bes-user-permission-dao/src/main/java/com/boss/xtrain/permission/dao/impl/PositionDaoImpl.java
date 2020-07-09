package com.boss.xtrain.permission.dao.impl;

import com.boss.xtrain.permission.dao.PositionDao;
import com.boss.xtrain.permission.mapper.PositionMapper;
import com.boss.xtrain.permission.pojo.dto.PositionDTO;
import com.boss.xtrain.permission.pojo.query.PositionQueryDTO;
import com.boss.xtrain.permission.pojo.entity.Position;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/*
 * @Author  :yushiqian
 * @Date    :14:38 2020/07/07
 * @Description :positionDao的具体实现
 * @Version: 1.0
 */

@Repository
public class PositionDaoImpl implements PositionDao {

    @Resource
    private PositionMapper positionMapper;


    @Override
    public List<Position> queryByCondition(PositionQueryDTO dto) {
        return positionMapper.queryByCondition(dto);
    }

    @Override
    public int deleteByIds(List<Long> ids) {
        return positionMapper.deleteByIds(ids);
    }

    @Override
    public int create(PositionDTO dto) {
        Position position = new Position();
        BeanUtils.copyProperties(dto,position);
        return positionMapper.insertSelective(position);
    }

    @Override
    public int update(PositionDTO dto) {
        Position position = new Position();
        BeanUtils.copyProperties(dto,position);
        return positionMapper.updateByPrimaryKeySelective(position);
    }

    @Override
    public List<Position> selectAll() {
        return positionMapper.selectAll();
    }

}
