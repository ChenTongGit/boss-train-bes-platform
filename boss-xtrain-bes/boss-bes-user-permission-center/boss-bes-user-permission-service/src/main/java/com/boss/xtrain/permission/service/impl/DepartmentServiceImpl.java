package com.boss.xtrain.permission.service.impl;

import com.boss.xtrain.common.core.exception.BusinessException;
import com.boss.xtrain.common.core.exception.error.BusinessError;
import com.boss.xtrain.permission.dao.CompanyDao;
import com.boss.xtrain.permission.dao.DepartmentDao;
import com.boss.xtrain.permission.dao.UserDao;
import com.boss.xtrain.permission.pojo.dto.DepartmentDTO;
import com.boss.xtrain.permission.pojo.entity.Company;
import com.boss.xtrain.permission.pojo.entity.Department;
import com.boss.xtrain.permission.pojo.entity.Role;
import com.boss.xtrain.permission.pojo.query.CompanyQuery;
import com.boss.xtrain.permission.pojo.query.DepartmentQuery;
import com.boss.xtrain.permission.service.DepartmentService;
import com.boss.xtrain.common.util.IdWorker;
import com.boss.xtrain.common.util.PojoUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author 53534秦昀清
 * @date 2020.07.07
 */
@Slf4j
@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentDao departmentDao;

    @Autowired
    private CompanyDao companyDao;

    @Autowired
    private UserDao userDao;

    private IdWorker worker = new IdWorker();

    /**
     * 查询组织机构下所有部门信息
     * @param query q
     * @return list
     */
    @Override
    public List<DepartmentDTO> selectAll(DepartmentQuery query) {
        List<DepartmentDTO> departmentDTOList = PojoUtils.copyListProperties(doBeforeQueryOrigin(query),DepartmentDTO::new);
        for(DepartmentDTO departmentDTO:departmentDTOList){
            departmentDTO.setCompanyName(companyDao.selectByKey(departmentDTO.getCompanyId()).getName());
        }
        return departmentDTOList;
    }

    @Override
    public DepartmentDTO selectByPrimaryKey(DepartmentQuery query) {
        try{
            DepartmentDTO dto = new DepartmentDTO();
            PojoUtils.copyProperties(departmentDao.selectByKey(query.getId()),dto);
            return dto;
        }catch (Exception e){
            log.error(BusinessError.SYSTEM_MANAGER_DEPARTMENT_QUERY_ERROR.getMessage(),e);
            throw new BusinessException(BusinessError.SYSTEM_MANAGER_DEPARTMENT_QUERY_ERROR,e);
        }
    }

    /**
     * 搜索一个
     *
     * @param query query
     * @return department
     */
    @Override
    public DepartmentDTO selectOne(DepartmentQuery query) {
        try{
            DepartmentDTO dto = new DepartmentDTO();
            Department department = departmentDao.selectOne(query);
            PojoUtils.copyProperties(department,dto);
            dto.setCompanyName(companyDao.selectByKey(department.getCompanyId()).getName());
            if(department.getParentId()!=null){
                dto.setParentName(departmentDao.selectByKey(department.getParentId()).getName());
            }
            return dto;
        }catch (Exception e){
            log.error(BusinessError.SYSTEM_MANAGER_DEPARTMENT_QUERY_ERROR.getMessage(),e);
            throw new BusinessException(BusinessError.SYSTEM_MANAGER_DEPARTMENT_QUERY_ERROR,e);
        }
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
    public List<DepartmentDTO> selectByCondition(DepartmentQuery query) {
        List<DepartmentDTO> departmentDTOList = new ArrayList<>();
        try{
           if(query.getCompanyId()!=null||query.getParentId()!=null||query.getId()!=null){
               //在初始化的基础上，点击树形图进行选择
               departmentDTOList = PojoUtils.copyListProperties(departmentDao.selectByCondition(query),DepartmentDTO::new);
           }else{
               // 初始化展示改组织机构下的所有部门
               departmentDTOList = PojoUtils.copyListProperties(departmentDao.selectAll(query),DepartmentDTO::new);
           }
            for(DepartmentDTO departmentDTO:departmentDTOList){
                departmentDTO.setCompanyName(companyDao.selectByKey(departmentDTO.getCompanyId()).getName());
                Department parent = departmentDao.selectByKey(departmentDTO.getParentId());
                if(parent!=null){
                    departmentDTO.setParentName(parent.getName());
                }
            }
            return departmentDTOList;
        }catch (Exception e){
            log.error(BusinessError.SYSTEM_MANAGER_DEPARTMENT_QUERY_ERROR.getMessage(),e);
            throw new BusinessException(BusinessError.SYSTEM_MANAGER_DEPARTMENT_QUERY_ERROR,e);
        }
    }

    /**
     * 查询所有
     *
     * @return list--all无条件
     * @author ChenTong
     * @date 2020/7/8 9:50
     */
    @Override
    public List<DepartmentDTO> selectAll() {
        try{
            List<DepartmentDTO> departmentDTOList = PojoUtils.copyListProperties(departmentDao.selectAll(),DepartmentDTO::new);
            for(DepartmentDTO departmentDTO:departmentDTOList){
                departmentDTO.setCompanyName(companyDao.selectByKey(departmentDTO.getCompanyId()).getName());
            }
            return departmentDTOList;
        }catch (Exception e){
            log.error(BusinessError.SYSTEM_MANAGER_DEPARTMENT_QUERY_ERROR.getMessage(),e);
            throw new BusinessException(BusinessError.SYSTEM_MANAGER_DEPARTMENT_QUERY_ERROR,e);
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
    public int delete(DepartmentDTO dto) {
        try{
            return departmentDao.delete(dto);
        }catch (Exception e){
            log.error(BusinessError.SYSTEM_MANAGER_DEPARTMENT_DELETE_ERROR.getMessage(),e);
            throw new BusinessException(BusinessError.SYSTEM_MANAGER_DEPARTMENT_DELETE_ERROR,e);
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
    public int delete(List<DepartmentDTO> dtoList) {
        try{
            return departmentDao.delete(dtoList);
        }catch (Exception e){
            log.error(BusinessError.SYSTEM_MANAGER_DEPARTMENT_DELETE_ERROR.getMessage(),e);
            throw new BusinessException(BusinessError.SYSTEM_MANAGER_DEPARTMENT_DELETE_ERROR,e);
        }
    }

    /**
     * 更新用户数据
     *
     * @param dto T extends BaseDTO 数据传输对象
     * @return int
     * @author ChenTong
     * @date 2020/6/22 7:18
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int update(DepartmentDTO dto) {
        if(!departmentDao.existsByKey(dto.getId())){
            //该条数据不存在
            throw new BusinessException(BusinessError.SYSTEM_MANAGER_DEPARTMENT_NOTIN_ERROR);
        }
        try{
            dto.setUpdatedTime(new Date());
            return departmentDao.deptUpdate(dto);
        }catch (Exception e){
            log.error(BusinessError.SYSTEM_MANAGER_DEPARTMENT_UPDATE_ERROR.getMessage(),e);
            throw new BusinessException(BusinessError.SYSTEM_MANAGER_DEPARTMENT_UPDATE_ERROR,e);
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
    public int insert(DepartmentDTO dto) {
        DepartmentQuery query = new DepartmentQuery();
        PojoUtils.copyProperties(dto,query);
        List<Department> list = departmentDao.selectByCondition(query);
        if(list.isEmpty()){
            try{
                dto.setId(worker.nextId());
                dto.setCreatedTime(new Date());
                return departmentDao.add(dto);
            }catch (Exception e){
                log.error(BusinessError.SYSTEM_MANAGER_DEPARTMENT_INSERT_ERROR.getMessage(),e);
                throw new BusinessException(BusinessError.SYSTEM_MANAGER_DEPARTMENT_INSERT_ERROR,e);
            }
        }
        throw new BusinessException(BusinessError.SYSTEM_MANAGER_DEPARTMENT_REPEAT_ERROR);
    }

    /**
     * 根据userId 获取到orgID,然后用orgId查到所有该组织机构下的department信息
     * @param query 必须包括userID  userDao.getRoleByUserId(query.getUserId()).get(0)得到role对象
     * @return 组织机构表
     */
    private List<Department> doBeforeQueryOrigin(DepartmentQuery query){
        try{
            Role role = userDao.getRoleByUserId(query.getUserId()).get(0);
            Long orgId = role.getOrganizationId();
            query.setOrganizationId(orgId);
            //只需orgId即可,结果有CompanyName
            return departmentDao.selectAll(query);
        }catch (Exception e){
            log.error(BusinessError.SYSTEM_MANAGER_DEPARTMENT_QUERY_ERROR.getMessage(),e);
            throw new BusinessException(BusinessError.SYSTEM_MANAGER_DEPARTMENT_QUERY_ERROR,e);
        }
    }

}

