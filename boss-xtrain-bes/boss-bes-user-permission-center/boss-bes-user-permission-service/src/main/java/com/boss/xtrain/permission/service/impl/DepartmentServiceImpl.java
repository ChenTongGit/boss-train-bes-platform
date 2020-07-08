package com.boss.xtrain.permission.service.impl;

import com.boss.xtrain.permission.dao.CompanyDao;
import com.boss.xtrain.permission.dao.DepartmentDao;
import com.boss.xtrain.permission.pojo.dto.DepartmentDTO;
import com.boss.xtrain.permission.pojo.entity.Company;
import com.boss.xtrain.permission.pojo.entity.Department;
import com.boss.xtrain.permission.pojo.query.CompanyQuery;
import com.boss.xtrain.permission.pojo.query.DepartmentQuery;
import com.boss.xtrain.permission.service.DepartmentService;
import com.boss.xtrain.common.util.IdWorker;
import com.boss.xtrain.common.util.PojoUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 53534秦昀清
 * @date 2020.07.07
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Resource
    private DepartmentDao departmentDao;

    @Resource
    private CompanyDao companyDao;

    @Resource
    private IdWorker worker;

    /**
     * 查询所有
     *
     * @return
     */
    @Override
    public List<DepartmentDTO> selectTree(DepartmentQuery query) {
        CompanyQuery companyQuery = new CompanyQuery();
        Long orgId = query.getOrganizationId();
        String orgName = query.getOrgName();
        List<Department> all = new ArrayList<>();
        if(orgId!=null||orgName!=null){
            companyQuery.setOrganizationId(orgId);
            companyQuery.setOrgName(orgName);
            List<Company> companyList = companyDao.selectByCondition(companyQuery);
            if(!companyList.isEmpty()){
                for(Company company:companyList){
                    query.setCompanyId(company.getId());
                    List<Department> temp = departmentDao.selectByCondition(query);
                    //去看一下addAll方法！！！
                    all.addAll(temp);
                }
            }
        }
        return PojoUtils.copyListProperties(all,DepartmentDTO::new);
    }

    /**
     * 搜索一个
     *
     * @param query query
     * @return
     */
    @Override
    public DepartmentDTO selectOne(DepartmentQuery query) {
        DepartmentDTO dto = new DepartmentDTO();
        PojoUtils.copyProperties(departmentDao.selectOne(query),dto);
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
    public List<DepartmentDTO> selectByCondition(DepartmentQuery query) {
        return PojoUtils.copyListProperties(departmentDao.selectByCondition(query),DepartmentDTO::new);
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
    public int delete(DepartmentDTO dto) {
        return departmentDao.delete(dto);
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
    public int delete(List<DepartmentDTO> dtoList) {
        return departmentDao.delete(dtoList);
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
    public int update(DepartmentDTO dto) {
        if(departmentDao.existsByKey(dto.getId())){
            return departmentDao.update(dto);
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
    public int insert(DepartmentDTO dto) {
        DepartmentQuery query = new DepartmentQuery();
        PojoUtils.copyProperties(dto,query);
        List<Department> list = departmentDao.selectByCondition(query);
        if(list.isEmpty()){
            dto.setId(worker.nextId());
            return departmentDao.insert(dto);
        }
        return -1;
    }
}
