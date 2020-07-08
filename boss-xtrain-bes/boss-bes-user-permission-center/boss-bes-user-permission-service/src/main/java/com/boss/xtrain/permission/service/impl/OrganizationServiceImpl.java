package com.boss.xtrain.permission.service.impl;

import com.boss.xtrain.permission.dao.CompanyDao;
import com.boss.xtrain.permission.dao.OrganizationDao;
import com.boss.xtrain.permission.pojo.dto.OrganizationDTO;
import com.boss.xtrain.permission.pojo.entity.Organization;
import com.boss.xtrain.permission.pojo.query.CompanyQuery;
import com.boss.xtrain.permission.pojo.query.OrganizationQuery;
import com.boss.xtrain.permission.service.OrganizationService;
import com.boss.xtrain.common.util.IdWorker;
import com.boss.xtrain.common.util.PojoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 53534秦昀清
 * @date 2020.07.06
 */
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
        return PojoUtils.copyListProperties(organizationDao.selectByCondition(query),OrganizationDTO::new);
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
            return organizationDao.delete(dto);
        }
        //已被使用，不可被删除
        return -1;
    }

    /**
     * 批量删除数据
     *
     * @param dtoList id列表
     * @return int成功删除个数
     */
    @Override
    public int delete(List<OrganizationDTO> dtoList) {
        int count = 0;
        for(OrganizationDTO dto:dtoList){
            if(isNotUsedInCompany(dto)){
                count+=organizationDao.delete(dto);
            }
        }
        return count;
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
        if (organizationDao.existsByKey(id)){
            return organizationDao.update(dto);
        }
        return -1;
    }

    /**
     * 插入数据
     *
     * @param dto T extends BaseDTO 数据传输对象
     * @return int
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insert(OrganizationDTO dto) {
        OrganizationQuery query = new OrganizationQuery();
        PojoUtils.copyProperties(dto,query);
        List<Organization> list = organizationDao.selectByCondition(query);
        if(list.isEmpty()){
            dto.setId(worker.nextId());
            return organizationDao.insert(dto);
        }
        //数据库中已有这个名字的纪录不能再添加
        return -1;
    }

    /**
     * 查询所有
     *
     * @return 搜索结果列表
     */
    @Override
    public List<OrganizationDTO> selectAll() {
        List<Organization> organizationList =  organizationDao.selectAll();
        return PojoUtils.copyListProperties(organizationList,OrganizationDTO::new);
    }

    @Override
    public OrganizationDTO selectOne(OrganizationQuery query) {
        OrganizationDTO organization = new OrganizationDTO();
        PojoUtils.copyProperties(organizationDao.selectOne(query),organization);
        return organization;
    }

    private boolean isNotUsedInCompany(OrganizationDTO dto){
        Long orgId = dto.getId();
        CompanyQuery query = new CompanyQuery();
        query.setOrganizationId(orgId);
        //如果orgId搜索到的结果是空的，说明该org并未被使用，可以删除。
        return companyDao.selectByCondition(query).isEmpty();
    }
}
