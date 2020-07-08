package com.boss.xtrain.permission.service.impl;

import com.boss.xtrain.permission.dao.CompanyDao;
import com.boss.xtrain.permission.dao.DepartmentDao;
import com.boss.xtrain.permission.pojo.dto.CompanyDTO;
import com.boss.xtrain.permission.pojo.entity.Company;
import com.boss.xtrain.permission.pojo.query.CompanyQuery;
import com.boss.xtrain.permission.pojo.query.DepartmentQuery;
import com.boss.xtrain.permission.service.CompanyService;
import com.boss.xtrain.common.util.IdWorker;
import com.boss.xtrain.common.util.PojoUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 53534秦昀清
 * @date 2020.07.07
 */
@Service
public class CompanyServiceImpl implements CompanyService {

    @Resource
    private CompanyDao companyDao;

    @Resource
    private DepartmentDao departmentDao;

    @Resource
    private IdWorker worker;

    /**
     * 查询所有
     *
     * @return
     */
    @Override
    public List<CompanyDTO> selectAll() {
        return PojoUtils.copyListProperties(companyDao.selectAll(),CompanyDTO::new);
    }

    /**
     * 搜索一个
     *
     * @param query query
     * @return
     */
    @Override
    public CompanyDTO selectOne(CompanyQuery query) {
        CompanyDTO companyDTO = new CompanyDTO();
        PojoUtils.copyProperties(companyDao.selectOne(query),companyDTO);
        return  companyDTO;
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
        return PojoUtils.copyListProperties(companyDao.selectByCondition(query),CompanyDTO::new);
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
    public int delete(CompanyDTO dto) {
        if(isNotUsed(dto)){
            return companyDao.delete(dto);
        }
        return -1;
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
    public int delete(List<CompanyDTO> dtoList) {
        int count = 0;
        for(CompanyDTO dto:dtoList){
            if(isNotUsed(dto)){
                count+=companyDao.delete(dto);
            }
        }
        return count;
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
    public int update(CompanyDTO dto) {
        if(companyDao.existsByKey(dto.getId())){
            return companyDao.update(dto);
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
    @Transactional(rollbackFor = Exception.class)
    public int insert(CompanyDTO dto) {
        CompanyQuery query = new CompanyQuery();
        PojoUtils.copyProperties(dto,query);
        List<Company> list = companyDao.selectByCondition(query);
        if(list.isEmpty()){
            dto.setId(worker.nextId());
            return companyDao.insert(dto);
        }
        return -1;
    }

    private boolean isNotUsed(CompanyDTO dto){
        Long companyId = dto.getId();
        DepartmentQuery query = new DepartmentQuery();
        query.setCompanyId(companyId);
        return departmentDao.selectByCondition(query).isEmpty();
    }
}
