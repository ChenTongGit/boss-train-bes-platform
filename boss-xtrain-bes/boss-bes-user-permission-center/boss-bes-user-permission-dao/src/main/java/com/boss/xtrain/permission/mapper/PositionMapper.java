package com.boss.xtrain.permission.mapper;


import com.boss.xtrain.common.core.web.dao.CommonMapper;
import com.boss.xtrain.permission.pojo.query.PositionQueryDTO;
import com.boss.xtrain.permission.pojo.entity.Position;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PositionMapper extends CommonMapper<Position> {

}