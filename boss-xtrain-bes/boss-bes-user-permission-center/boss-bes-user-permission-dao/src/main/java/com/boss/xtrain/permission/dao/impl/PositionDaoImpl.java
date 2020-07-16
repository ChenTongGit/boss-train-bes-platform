package com.boss.xtrain.permission.dao.impl;

import com.boss.xtrain.common.util.PojoUtils;
import com.boss.xtrain.permission.dao.PositionDao;
import com.boss.xtrain.permission.mapper.PositionMapper;
import com.boss.xtrain.permission.pojo.dto.PositionDTO;
import com.boss.xtrain.permission.pojo.query.PositionQueryDTO;
import com.boss.xtrain.permission.pojo.entity.Position;
import javafx.geometry.Pos;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class PositionDaoImpl implements PositionDao {

    @Autowired
    private PositionMapper positionMapper;


    @Override
    public List<PositionDTO> queryByCondition(PositionQueryDTO dto) {
        Position position = new Position();
        PojoUtils.copyProperties(dto,position);
        return PojoUtils.copyListProperties(positionMapper.select(position),PositionDTO::new);
    }

    @Override
    public int deleteByIds(List<Long> ids) {
        int count = 0;
        for(Long id:ids){
            positionMapper.deleteByPrimaryKey(id);
            count++;
        }
        return count;
    }

    @Override
    public int insert(PositionDTO dto) {
        Position position = new Position();
        BeanUtils.copyProperties(dto,position);
        return positionMapper.insert(position);
    }

    @Override
    public int delete(PositionDTO dto) {
        return positionMapper.deleteByPrimaryKey(dto.getId());
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

    @Override
    public boolean isExist(Long id) {
        log.info("positionDao exist:",id);
        return positionMapper.existsWithPrimaryKey(id);
    }

    @Override
    public Position selectOne(PositionQueryDTO dto) {
        Position position = new Position();
        PojoUtils.copyProperties(dto,position);
        return positionMapper.selectOne(position);
    }

}
