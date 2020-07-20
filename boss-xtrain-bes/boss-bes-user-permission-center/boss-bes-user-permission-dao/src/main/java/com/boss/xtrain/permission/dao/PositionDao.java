package com.boss.xtrain.permission.dao;

import com.boss.xtrain.common.core.web.dao.IBaseDao;
import com.boss.xtrain.permission.pojo.dto.PositionDTO;
import com.boss.xtrain.permission.pojo.query.PositionQueryDTO;
import com.boss.xtrain.permission.pojo.entity.Position;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/*
 * @Author  :yushiqian
 * @Date    :14:30 2020/07/07
 * @Description :dao层接口
 * @Version: 1.0
 */
public interface PositionDao extends IBaseDao<PositionDTO,PositionQueryDTO> {

    /**
     * @param  ids
     * @return  int 影响行数
     * @description 通过id批量删除职位信息
     */
    int deleteByIds(@Param("ids")List<Long> ids);


    /**
     * @param
     * @return  list<position>
     * @description 测试方法
     */
    List<Position> selectAll();

    /**
     * 该id是否存在
     *
     * @param id
     * @return boolean
     *
    */
    boolean isExist(Long id);

    /**
     * @param id
     * @return  Position
     * @description
     */
    Position selectByKey(Long id);
    /**
     * 避开切面注入 insert
     *
     * @param dto
     * @return int
     *
    */
    int positionInsert(PositionDTO dto);
    /**
     *
     * 避开切面注入 update
     * @param dto
     * @return int
     *
    */
    int positionUpdate(PositionDTO dto);
}
