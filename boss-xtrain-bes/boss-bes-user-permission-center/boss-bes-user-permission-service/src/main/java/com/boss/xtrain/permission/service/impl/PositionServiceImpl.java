package com.boss.xtrain.permission.service.impl;

import com.boss.xtrain.common.util.PojoUtils;
import com.boss.xtrain.permission.dao.PositionDao;
import com.boss.xtrain.permission.pojo.dto.PositionDTO;
import com.boss.xtrain.permission.pojo.query.PositionQueryDTO;
import com.boss.xtrain.permission.pojo.entity.Position;
import com.boss.xtrain.permission.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 * @Author  :yushiqian
 * @Date    :15:28 2020/07/07
 * @Description :positionService的实现类
 * @Version: 1.0
 */

@Service
public class PositionServiceImpl implements PositionService {

    @Autowired
    private PositionDao positionDao;

    @Override
    public int create(PositionDTO dto) {
        return positionDao.create(dto);
    }

    @Override
    public int update(PositionDTO dto) {
        return positionDao.update(dto);
    }

    @Override
    public List<PositionDTO> queryByCondition(PositionQueryDTO dto) {
        List<Position> positions = positionDao.queryByCondition(dto);
        return PojoUtils.copyListProperties(positions,PositionDTO::new);
    }

    @Override
    public int deleteByIds(List<Long> ids) {
       return positionDao.deleteByIds(ids);
    }

    @Override
    public List<Position> selectAll() {
        return positionDao.selectAll();
    }
}
