package com.boss.xtrain.permission.service.impl;

import com.boss.xtrain.common.core.exception.BusinessException;
import com.boss.xtrain.common.core.exception.error.BusinessError;
import com.boss.xtrain.permission.dao.CompanyDao;
import com.boss.xtrain.permission.dao.OrganizationDao;
import com.boss.xtrain.permission.pojo.dto.OrganizationDTO;
import com.boss.xtrain.permission.pojo.entity.Organization;
import com.boss.xtrain.permission.pojo.query.CompanyQuery;
import com.boss.xtrain.permission.pojo.query.OrganizationQuery;
import com.boss.xtrain.permission.service.OrganizationService;
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
 * @date 2020.07.06
 */
@Slf4j
@Service
public class OrganizationServiceImpl implements OrganizationService {

    @Autowired
    private OrganizationDao organizationDao;

    @Autowired
    private CompanyDao companyDao;

    private IdWorker worker = new IdWorker();

    /**
     * 通过query查找列表
     *
     * @param query Q extends BaseQuery查询条件
     * @return java.util.List<V>
     */
    @Override
    public List<OrganizationDTO> selectByCondition(OrganizationQuery query) {
        try{
            return PojoUtils.copyListProperties(organizationDao.selectByCondition(query),OrganizationDTO::new);
        }catch (Exception e){
            log.error(BusinessError.SYSTEM_MANAGER_ORGANIZATION_QUERY_ERROR.getMessage(),e);
            throw new BusinessException(BusinessError.SYSTEM_MANAGER_ORGANIZATION_QUERY_ERROR,e);
        }
    }

    /**
     * 通过主键删除数据
     *
     * @param dto Object数据库主键
     * @return int
     */
    @Override
    public int delete(OrganizationDTO dto) {
        if(isNotUsedInCompany(dto)){
            try {
                return organizationDao.delete(dto);
            }catch (Exception e){
                log.error(BusinessError.SYSTEM_MANAGER_ORGANIZATION_DELETE_ERROR.getMessage(),e);
                throw new BusinessException(BusinessError.SYSTEM_MANAGER_ORGANIZATION_DELETE_ERROR,e);
            }
        }
        //已被使用，不可被删除
        throw new BusinessException(BusinessError.SYSTEM_MANAGER_ORGANIZATION_USED_ERROR);
    }

    /**
     * 批量删除数据
     *
     * @param dtoList id列表
     * @return int成功删除个数
     */
    @Override
    public int delete(List<OrganizationDTO> dtoList) {
        for(OrganizationDTO dto:dtoList){
            //已被使用，不可被删除
            if(!isNotUsedInCompany(dto)){
                throw new BusinessException(BusinessError.SYSTEM_MANAGER_ORGANIZATION_USED_ERROR);
            }
        }try{
            return organizationDao.delete(dtoList);
        }catch (Exception e){
            log.error(BusinessError.SYSTEM_MANAGER_ORGANIZATION_DELETE_ERROR.getMessage(),e);
            throw new BusinessException(BusinessError.SYSTEM_MANAGER_ORGANIZATION_DELETE_ERROR,e);
        }
    }

    /**
     * 更新用户数据
     *
     * @param dto T extends BaseDTO 数据传输对象
     * @return int
     */
    @Override
    public int update(OrganizationDTO dto) {
        Long id = dto.getId();
        if (!organizationDao.existsByKey(id)){
            //该条数据不存在
            throw new BusinessException(BusinessError.SYSTEM_MANAGER_ORGANIZATION_NOTIN_ERROR);
        }
        try{
            dto.setUpdatedTime(new Date());
            dto.setVersion(organizationDao.selectByPrimaryKey(dto.getId()).getVersion());
            return organizationDao.orgUpdate(dto);
        }catch (Exception e){
            log.error(BusinessError.SYSTEM_MANAGER_ORGANIZATION_UPDATE_ERROR.getMessage(),e);
            throw new BusinessException(BusinessError.SYSTEM_MANAGER_ORGANIZATION_UPDATE_ERROR,e);
        }
    }

    /**
     * 插入数据
     *
     * @param dto T extends BaseDTO 数据传输对象
     * @return int
     */
    @Override
    public int insert(OrganizationDTO dto) {
        OrganizationQuery query = new OrganizationQuery();
        PojoUtils.copyProperties(dto,query);
        List<Organization> list = organizationDao.selectByCondition(query);
        if(!list.isEmpty()){
            //数据库中已有这个名字的纪录不能再添加
            throw new BusinessException(BusinessError.SYSTEM_MANAGER_ORGANIZATION_REPEAT_ERROR);
        }
        try {
            dto.setId(worker.nextId());
            dto.setVersion(0L);
            dto.setCreatedTime(new Date());
            return organizationDao.orgInsert(dto);
        }catch (Exception e){
            log.error(BusinessError.SYSTEM_MANAGER_ORGANIZATION_INSERT_ERROR.getMessage(),e);
            throw new BusinessException(BusinessError.SYSTEM_MANAGER_ORGANIZATION_INSERT_ERROR,e);
        }
    }

    /**
     * 查询所有
     *
     * @return 搜索结果列表
     */
    @Override
    public List<OrganizationDTO> selectAll() {
        try {
            List<Organization> organizationList = organizationDao.selectAll();
            return PojoUtils.copyListProperties(organizationList, OrganizationDTO::new);
        }catch (Exception e){
            log.error(BusinessError.SYSTEM_MANAGER_ORGANIZATION_QUERY_ERROR.getMessage(),e);
            throw new BusinessException(BusinessError.SYSTEM_MANAGER_ORGANIZATION_QUERY_ERROR,e);
        }
    }

    @Override
    public OrganizationDTO selectByPrimaryKey(OrganizationQuery query) {
        try{
            OrganizationDTO dto = new OrganizationDTO();
            PojoUtils.copyProperties(organizationDao.selectByPrimaryKey(query.getId()),dto);
            return dto;
        }catch (Exception e){
            log.error(BusinessError.SYSTEM_MANAGER_ORGANIZATION_QUERY_ERROR.getMessage(),e);
            throw new BusinessException(BusinessError.SYSTEM_MANAGER_ORGANIZATION_QUERY_ERROR,e);
        }
    }

    /**
     * 只查一个
     * @param query query
     * @return org
     */
    @Override
    public OrganizationDTO selectOne(OrganizationQuery query) {
        try {
            OrganizationDTO organization = new OrganizationDTO();
            PojoUtils.copyProperties(organizationDao.selectOne(query), organization);
            return organization;
        }catch (Exception e){
            log.error(BusinessError.SYSTEM_MANAGER_ORGANIZATION_QUERY_ERROR.getMessage(),e);
            throw new BusinessException(BusinessError.SYSTEM_MANAGER_ORGANIZATION_QUERY_ERROR,e);
        }
    }

    private boolean isNotUsedInCompany(OrganizationDTO dto){
        Long orgId = dto.getId();
        //如果orgId搜索到的结果是空的，说明该org并未被使用，可以删除。
        return companyDao.selectByOrg(orgId).isEmpty();
    }
}