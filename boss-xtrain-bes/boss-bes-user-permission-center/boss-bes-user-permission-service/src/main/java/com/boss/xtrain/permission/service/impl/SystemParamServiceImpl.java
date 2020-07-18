package com.boss.xtrain.permission.service.impl;

import com.boss.xtrain.common.core.exception.BusinessException;
import com.boss.xtrain.common.core.exception.error.BusinessError;
import com.boss.xtrain.permission.dao.SystemParamDao;
import com.boss.xtrain.permission.dao.UserDao;
import com.boss.xtrain.permission.pojo.dto.SystemParamDTO;
import com.boss.xtrain.permission.pojo.entity.SystemParam;
import com.boss.xtrain.permission.pojo.query.SystemParamQuery;
import com.boss.xtrain.permission.service.SystemParamService;
import com.boss.xtrain.common.util.IdWorker;
import com.boss.xtrain.common.util.PojoUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
/**
 * @author 53534秦昀清
 * @date 2020.07.07
 */
@Slf4j
@Service
public class SystemParamServiceImpl implements SystemParamService {

    @Autowired
    private SystemParamDao systemParamDao;

    @Autowired
    private UserDao userDao;

    private IdWorker worker = new IdWorker();

    /**
     * 查询所有
     *
     * @return LIST
     */
    @Override
    public List<SystemParamDTO> selectAll() {
        try {
            return PojoUtils.copyListProperties(systemParamDao.selectAll(), SystemParamDTO::new);
        }catch (Exception e){
            log.error(BusinessError.SYSTEM_MANAGER_PARAM_QUERY_ERROR.getMessage(),e);
            throw new BusinessException(BusinessError.SYSTEM_MANAGER_PARAM_QUERY_ERROR,e);
        }
    }

    /**
     * 搜索一个
     *
     * @param query query
     * @return ONE
     */
    @Override
    public SystemParamDTO selectOne(SystemParamQuery query) {
        try {
            SystemParamDTO dto = new SystemParamDTO();
            PojoUtils.copyProperties(systemParamDao.selectOne(query), dto);
            return dto;
        }catch (Exception e){
            log.error(BusinessError.SYSTEM_MANAGER_PARAM_QUERY_ERROR.getMessage(),e);
            throw new BusinessException(BusinessError.SYSTEM_MANAGER_PARAM_QUERY_ERROR,e);
        }
    }

    /**
     * 搜索树节点
     * 不需要了
     * @param query query
     * @return
     */
    @Override
    public List<SystemParamQuery> selectTree(SystemParamQuery query) {
        return PojoUtils.copyListProperties(getOriginParam(query),SystemParamQuery::new);
    }

    /**
     * 查询组织机构所有
     *
     * @param orgId 所负责的组织机构ID
     * @return LIST
     */
    @Override
    public List<SystemParamDTO> selectAllUnderOrg(Long orgId) {
        return PojoUtils.copyListProperties(systemParamDao.selectAllUnderOrg(orgId),SystemParamDTO::new);
    }

    @Override
    public int deleteByParamType(SystemParamDTO dto) {
        SystemParamQuery query = new SystemParamQuery();
        //获取到所有参数类型为传入至的纪录
        query.setParamType(dto.getParamType());
        List<SystemParamDTO> systemParamDTOList = PojoUtils.copyListProperties(systemParamDao.selectByCondition(query),SystemParamDTO::new);
        for(SystemParamDTO systemParamDTO:systemParamDTOList){
            if(systemParamDTO.getStatus()!=0){
                throw new BusinessException(BusinessError.SYSTEM_MANAGER_PARAM_USED_ERROR);
            }
        }
        try{
            return systemParamDao.delete(systemParamDTOList);
        }catch (Exception e){
            log.error(BusinessError.SYSTEM_MANAGER_PARAM_DELETE_ERROR.getMessage(),e);
            throw new BusinessException(BusinessError.SYSTEM_MANAGER_PARAM_DELETE_ERROR,e);
        }
    }

    /**
     * 通过query查找列表
     * paramType 通过点击paramType树搜索
     * @param query Q extends BaseQuery查询条件
     * @return java.util.List<V>
     * @author ChenTong
     * @date 2020/6/22 7:05
     */
    @Override
    public List<SystemParamDTO> selectByCondition(SystemParamQuery query) {
        try{
            return PojoUtils.copyListProperties(systemParamDao.selectByCondition(query),SystemParamDTO::new);
        }catch (Exception e){
            log.error(BusinessError.SYSTEM_MANAGER_PARAM_QUERY_ERROR.getMessage(),e);
            throw new BusinessException(BusinessError.SYSTEM_MANAGER_PARAM_QUERY_ERROR,e);
        }
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
    @Transactional(rollbackFor = Exception.class)
    public int delete(SystemParamDTO dto) {
        //启用状态
        if(dto.getStatus()!=0){
            throw new BusinessException(BusinessError.SYSTEM_MANAGER_PARAM_USED_ERROR);
        }
        try{
            return systemParamDao.delete(dto);
        }catch (Exception e){
            log.error(BusinessError.SYSTEM_MANAGER_PARAM_DELETE_ERROR.getMessage(),e);
            throw new BusinessException(BusinessError.SYSTEM_MANAGER_PARAM_DELETE_ERROR,e);
        }
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
    @Transactional(rollbackFor = Exception.class)
    public int delete(List<SystemParamDTO> dtoList) {
        for(SystemParamDTO dto:dtoList){
            //启用状态
            if(dto.getStatus()!=0){
                throw new BusinessException(BusinessError.SYSTEM_MANAGER_PARAM_USED_ERROR);
            }
        }
        try{
            return systemParamDao.delete(dtoList);
        }catch (Exception e){
            log.error(BusinessError.SYSTEM_MANAGER_PARAM_DELETE_ERROR.getMessage(),e);
            throw new BusinessException(BusinessError.SYSTEM_MANAGER_PARAM_DELETE_ERROR,e);
        }
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
    @Transactional(rollbackFor = Exception.class)
    public int update(SystemParamDTO dto) {
        if (!systemParamDao.existsByKey(dto.getId())){
            //该条数据不存在
            throw new BusinessException(BusinessError.SYSTEM_MANAGER_PARAM_NOTIN_ERROR);
        }
        try{
            dto.setUpdatedTime(new Date());
            return systemParamDao.update(dto);
        }catch (Exception e){
            log.error(BusinessError.SYSTEM_MANAGER_PARAM_UPDATE_ERROR.getMessage(),e);
            throw new BusinessException(BusinessError.SYSTEM_MANAGER_PARAM_UPDATE_ERROR,e);
        }
    }

    /**
     * 插入数据
     *
     * @param dto dto
     * @return int
     * @author ChenTong
     * @date 2020/6/22 8:18
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insert(SystemParamDTO dto) {
        SystemParamQuery query = new SystemParamQuery();
        PojoUtils.copyProperties(dto,query);
        List<SystemParam> list = systemParamDao.selectByCondition(query);
        if(!list.isEmpty()){
            //数据库中已有这个名字的纪录不能再添加
            throw new BusinessException(BusinessError.SYSTEM_MANAGER_PARAM_REPEAT_ERROR);
        }
        try {
            dto.setId(worker.nextId());
            dto.setCreatedTime(new Date());
            return systemParamDao.insert(dto);
        }catch (Exception e){
            log.error(BusinessError.SYSTEM_MANAGER_PARAM_INSERT_ERROR.getMessage(),e);
            throw new BusinessException(BusinessError.SYSTEM_MANAGER_PARAM_INSERT_ERROR,e);
        }
    }

    /**
     * 获取登录用户所属的org
     * //@param
     * @return id
     */
    private Long getOrg(Long userId){
        return userDao.getRoleByUserId(userId).get(0).getOrganizationId();
    }

    /**
     *  获取登录用户负责的组织机构，然后根据orgId得到数据库中 组织机构所有的param
     * @param query userId
     * @return
     */
    private List<SystemParam> getOriginParam(SystemParamQuery query){
        try{
            Long orgId = userDao.getRoleByUserId(query.getUserId()).get(0).getOrganizationId();
            return systemParamDao.selectAllUnderOrg(orgId);
        }catch (Exception e){
            log.error(BusinessError.SYSTEM_MANAGER_PARAM_QUERY_ERROR.getMessage(),e);
            throw new BusinessException(BusinessError.SYSTEM_MANAGER_PARAM_QUERY_ERROR,e);
        }
    }
}
