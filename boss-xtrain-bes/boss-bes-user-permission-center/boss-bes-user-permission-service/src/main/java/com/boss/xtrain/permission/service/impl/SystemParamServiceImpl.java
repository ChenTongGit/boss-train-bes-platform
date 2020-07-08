package com.boss.xtrain.permission.service.impl;

import com.boss.xtrain.permission.dao.SystemParamDao;
import com.boss.xtrain.permission.pojo.dto.SystemParamDTO;
import com.boss.xtrain.permission.pojo.entity.SystemParam;
import com.boss.xtrain.permission.pojo.query.SystemParamQuery;
import com.boss.xtrain.permission.service.SystemParamService;
import com.boss.xtrain.common.util.IdWorker;
import com.boss.xtrain.common.util.PojoUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
/**
 * @author 53534秦昀清
 * @date 2020.07.07
 */
@Service
public class SystemParamServiceImpl implements SystemParamService {

    @Resource
    private SystemParamDao systemParamDao;

    @Resource
    private IdWorker worker;

    /**
     * 查询所有
     *
     * @return
     */
    @Override
    public List<SystemParamDTO> selectAll() {
        return PojoUtils.copyListProperties(systemParamDao.selectAll(),SystemParamDTO::new);
    }

    /**
     * 搜索一个
     *
     * @param query query
     * @return
     */
    @Override
    public SystemParamDTO selectOne(SystemParamQuery query) {
        SystemParamDTO dto = new SystemParamDTO();
        PojoUtils.copyProperties(systemParamDao.selectOne(query),dto);
        return dto;
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
    public List<SystemParamDTO> selectByCondition(SystemParamQuery query) {
        return PojoUtils.copyListProperties(systemParamDao.selectByCondition(query),SystemParamDTO::new);
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
    public int delete(SystemParamDTO dto) {
        return systemParamDao.delete(dto);
    }

    /**
     * 批量删除数据
     *
     * @param dtoList id列表
     * @return int
     * @author ChenTong
     * <<<<<<< HEAD
     * @date 2020/7/4 9:09
     */
    @Override
    public int delete(List<SystemParamDTO> dtoList) {
        return systemParamDao.delete(dtoList);
    }

    /**
     * 更新数据
     *
     * @param dto T extends BaseDTO 数据传输对象
     * @return int
     * @author ChenTong
     * @date 2020/6/22 7:18
     */
    @Override
    public int update(SystemParamDTO dto) {
        Long id = dto.getId();
        if (systemParamDao.existsByKey(id)){
            return systemParamDao.update(dto);
        }
        return -1;
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
    public int insert(SystemParamDTO dto) {
        SystemParamQuery query = new SystemParamQuery();
        PojoUtils.copyProperties(dto,query);
        List<SystemParam> list = systemParamDao.selectByCondition(query);
        if(list.isEmpty()){
            dto.setId(worker.nextId());
            return systemParamDao.insert(dto);
        }
        //数据库中已有这个名字的纪录不能再添加
        return -1;
    }
}
