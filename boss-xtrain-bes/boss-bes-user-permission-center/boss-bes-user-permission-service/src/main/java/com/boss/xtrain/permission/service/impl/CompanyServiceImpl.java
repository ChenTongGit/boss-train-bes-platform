package com.boss.xtrain.permission.service.impl;

import com.boss.xtrain.common.core.exception.BusinessException;
import com.boss.xtrain.common.core.exception.error.BusinessError;
import com.boss.xtrain.permission.dao.CompanyDao;
import com.boss.xtrain.permission.dao.DepartmentDao;
import com.boss.xtrain.permission.dao.OrganizationDao;
import com.boss.xtrain.permission.dao.UserDao;
import com.boss.xtrain.permission.pojo.dto.CompanyDTO;
import com.boss.xtrain.permission.pojo.entity.Company;
import com.boss.xtrain.permission.pojo.query.CompanyQuery;
import com.boss.xtrain.permission.pojo.query.DepartmentQuery;
import com.boss.xtrain.permission.pojo.query.OrganizationQuery;
import com.boss.xtrain.permission.service.CompanyService;
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
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyDao companyDao;

    @Autowired
    private DepartmentDao departmentDao;

    @Autowired
    private OrganizationDao organizationDao;

    @Autowired
    private UserDao userDao;

    private IdWorker worker = new IdWorker();

    /**
     * 查询所有
     *
     * @return all company
     */
    @Override
    public List<CompanyDTO> selectAll() {
        try{
            List<CompanyDTO> companyDTOList =  PojoUtils.copyListProperties(companyDao.selectAll(),CompanyDTO::new);
            for(CompanyDTO companyDTO:companyDTOList){
                companyDTO.setOrgName(organizationDao.selectByPrimaryKey(companyDTO.getOrganizationId()).getName());
            }
            return companyDTOList;
        }catch (Exception e){
            log.error(BusinessError.SYSTEM_MANAGER_COMPANY_QUERY_ERROR.getMessage(),e);
            throw new BusinessException(BusinessError.SYSTEM_MANAGER_COMPANY_QUERY_ERROR,e);
        }
    }

    @Override
    public CompanyDTO selectByPrimaryKey(CompanyQuery query) {
        try{
            CompanyDTO dto = new CompanyDTO();
            PojoUtils.copyProperties(companyDao.selectByKey(query.getId()),dto);
            return dto;
        }catch (Exception e){
            log.error(BusinessError.SYSTEM_MANAGER_COMPANY_QUERY_ERROR.getMessage(),e);
            throw new BusinessException(BusinessError.SYSTEM_MANAGER_COMPANY_QUERY_ERROR,e);
        }
    }

    /**
     * 搜索一个
     *
     * @param query query
     * @return one company
     */
    @Override
    public CompanyDTO selectOne(CompanyQuery query) {
        try{
            CompanyDTO companyDTO = new CompanyDTO();
            PojoUtils.copyProperties(companyDao.selectOne(query),companyDTO);
            companyDTO.setOrgName(organizationDao.selectByPrimaryKey(companyDTO.getOrganizationId()).getName());
            return companyDTO;
        }catch (Exception e){
            log.error(BusinessError.SYSTEM_MANAGER_COMPANY_QUERY_ERROR.getMessage(),e);
            throw new BusinessException(BusinessError.SYSTEM_MANAGER_COMPANY_QUERY_ERROR,e);
        }
    }

    /**
     * 获得所有的org以供添加公司时选择
     * @return
     */
    @Override
    public List<OrganizationQuery> listAllOrg() {
        try{
            return  PojoUtils.copyListProperties(organizationDao.selectAll(),OrganizationQuery::new);
        }catch (Exception e){
            log.error(BusinessError.SYSTEM_MANAGER_COMPANY_QUERY_ERROR.getMessage(),e);
            throw new BusinessException(BusinessError.SYSTEM_MANAGER_COMPANY_QUERY_ERROR,e);
        }
    }

    /**
     * 组织机构下所有
     * userId-->roleId-->orgId
     * @param query query
     * @return company
     */
    @Override
    public List<CompanyDTO> selectOrgCompanyAll(CompanyQuery query) {
        try{
            //得到user所负责的组织机构
            Long orgId = getOrg(query.getUserId());
            query.setOrganizationId(orgId);
            List<CompanyDTO> companyDTOList = PojoUtils.copyListProperties(companyDao.selectByCondition(query),CompanyDTO::new);
            for(CompanyDTO companyDTO:companyDTOList){
                companyDTO.setOrgName(organizationDao.selectByPrimaryKey(companyDTO.getOrganizationId()).getName());
            }
            return companyDTOList;
        }catch (Exception e){
            log.error(BusinessError.SYSTEM_MANAGER_COMPANY_QUERY_ERROR.getMessage(),e);
            throw new BusinessException(BusinessError.SYSTEM_MANAGER_COMPANY_QUERY_ERROR,e);
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
    public List<CompanyDTO> selectByCondition(CompanyQuery query) {
        try{
            List<CompanyDTO>companyDTOList = PojoUtils.copyListProperties(companyDao.selectByOrg(query.getOrganizationId()),CompanyDTO::new);
            //加orgName
            for(CompanyDTO companyDTO:companyDTOList){
                companyDTO.setOrgName(organizationDao.selectByPrimaryKey(companyDTO.getOrganizationId()).getName());
            }
            return companyDTOList;
        }catch (Exception e){
            log.error(BusinessError.SYSTEM_MANAGER_COMPANY_QUERY_ERROR.getMessage(),e);
            throw new BusinessException(BusinessError.SYSTEM_MANAGER_COMPANY_QUERY_ERROR,e);
        }
    }

    /**
     * 通过主键删除数据
     *
     * @param dto Object数据库主键
     * @return int
     * @author qyq
     * @date 2020/7/9 16:02
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int delete(CompanyDTO dto) {
        if(isNotUsed(dto)){
            try{
                return companyDao.delete(dto);
            }catch (Exception e){
                log.error(BusinessError.SYSTEM_MANAGER_COMPANY_DELETE_ERROR.getMessage(),e);
                throw new BusinessException(BusinessError.SYSTEM_MANAGER_COMPANY_DELETE_ERROR,e);
            }
        }
        throw new BusinessException(BusinessError.SYSTEM_MANAGER_COMPANY_USED_ERROR);
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
    public int delete(List<CompanyDTO> dtoList) {
        for(CompanyDTO dto:dtoList){
            if(!isNotUsed(dto)){
                throw new BusinessException(BusinessError.SYSTEM_MANAGER_COMPANY_USED_ERROR);
            }
        }try{
            return companyDao.delete(dtoList);
        }catch (Exception e){
            log.error(BusinessError.SYSTEM_MANAGER_COMPANY_DELETE_ERROR.getMessage(),e);
            throw new BusinessException(BusinessError.SYSTEM_MANAGER_COMPANY_DELETE_ERROR,e);
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
    public int update(CompanyDTO dto) {
        if(!companyDao.existsByKey(dto.getId())){
            //该条数据不存在
            throw new BusinessException(BusinessError.SYSTEM_MANAGER_COMPANY_NOTIN_ERROR);
        }
        try{
            dto.setUpdatedTime(new Date());
            return companyDao.update(dto);
        }catch (Exception e){
            log.error(BusinessError.SYSTEM_MANAGER_COMPANY_UPDATE_ERROR.getMessage(),e);
            throw new BusinessException(BusinessError.SYSTEM_MANAGER_COMPANY_UPDATE_ERROR,e);
        }
    }

    /**
     * 插入数据
     *
     * @param dto companyDto
     * @return int
     * @author ChenTong
     * @date 2020/6/22 8:18
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insert(CompanyDTO dto) {
        CompanyQuery query = new CompanyQuery();
        PojoUtils.copyProperties(dto,query);
        List<Company> list = companyDao.selectByCondition(query);
        if(!list.isEmpty()){
            throw new BusinessException(BusinessError.SYSTEM_MANAGER_COMPANY_REPEAT_ERROR);
        }
        try{
            dto.setId(worker.nextId());
            Long orgId = dto.getOrganizationId();
            dto.setOrganizationId(orgId);
            dto.setCreatedTime(new Date());
            return companyDao.add(dto);
        }catch (Exception e){
            log.error(BusinessError.SYSTEM_MANAGER_COMPANY_INSERT_ERROR.getMessage(),e);
            throw new BusinessException(BusinessError.SYSTEM_MANAGER_COMPANY_INSERT_ERROR,e);
        }
    }

    private boolean isNotUsed(CompanyDTO dto){
        Long companyId = dto.getId();
        return departmentDao.selectByCompany(companyId).isEmpty();
    }

    /**
     * 获取登录用户所属的org
     * @param userId userId
     * @return id
     */
    private Long getOrg(Long userId){
        return userDao.getRoleByUserId(userId).get(0).getOrganizationId();
    }
}
