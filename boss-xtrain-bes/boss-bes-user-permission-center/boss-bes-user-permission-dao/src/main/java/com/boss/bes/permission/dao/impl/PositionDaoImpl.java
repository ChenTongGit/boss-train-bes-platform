package com.boss.bes.permission.dao.impl;

import com.boss.bes.permission.dao.PositionDao;
import com.boss.bes.permission.mapper.PositionMapper;
import com.boss.bes.permission.pojo.dto.position.PositionDTO;
import com.boss.bes.permission.pojo.dto.position.PositionQueryDTO;
import com.boss.bes.permission.pojo.entity.Position;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/*
 * @Author  :yushiqian
 * @Date    :14:38 2020/07/07
 * @Description :positionDao的具体实现
 * @Version: 1.0
 */

@Component
public class PositionDaoImpl implements PositionDao {

    @Autowired
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
