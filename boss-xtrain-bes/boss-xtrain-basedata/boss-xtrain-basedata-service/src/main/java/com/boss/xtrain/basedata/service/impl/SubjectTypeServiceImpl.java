package com.boss.xtrain.basedata.service.impl;

import com.boss.xtrain.basedata.dao.SubjectTypeDao;
import com.boss.xtrain.basedata.pojo.dto.subjecttype.SubjectTypeDTO;
import com.boss.xtrain.basedata.pojo.dto.subjecttype.SubjectTypeDeleteDTO;
import com.boss.xtrain.basedata.pojo.dto.subjecttype.SubjectTypeInsertDTO;
import com.boss.xtrain.basedata.pojo.dto.subjecttype.SubjectTypeQueryDTO;
import com.boss.xtrain.common.util.IdWorker;
import com.boss.xtrain.common.util.PojoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.boss.xtrain.basedata.pojo.entity.SubjectType;
import com.boss.xtrain.basedata.mapper.SubjectTypeMapper;
import com.boss.xtrain.basedata.service.SubjectTypeService;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

public class SubjectTypeServiceImpl implements SubjectTypeService{

    @Autowired
    private SubjectTypeDao subjectTypeDao;

    @Autowired
    private IdWorker idWorker;

    @Override
    public int insertSubjectType(SubjectTypeInsertDTO subjectTypeInsertDTO) {
        SubjectType subjectType = new SubjectType();
        PojoUtils.copyProperties(subjectTypeInsertDTO,subjectType);
        subjectType.setId(idWorker.nextId());
        return subjectTypeDao.insertSubjectType(subjectType);
    }

    @Override
    public boolean deleteSubjectType(SubjectTypeDeleteDTO subjectTypeDeleteDTO) {
        Example example = new Example(SubjectType.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("id",subjectTypeDeleteDTO.getId());
        criteria.andEqualTo("version",subjectTypeDeleteDTO.getVersion());
        return subjectTypeDao.deleteSubjectType(example)==1;
    }

    @Override
    public void updateSubjectType(SubjectTypeDTO subjectTypeDTO) {
        SubjectType subjectType = new SubjectType();
        PojoUtils.copyProperties(subjectTypeDTO,subjectType);

        Example example = new Example(SubjectType.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("id",subjectTypeDTO.getId());
        criteria.andEqualTo("version",subjectTypeDTO.getVersion());
        subjectTypeDao.updateSubjectType(subjectType,example);
    }

    @Override
    public List<SubjectTypeDTO> querySubjectType(SubjectTypeQueryDTO subjectTypeQueryDTO) {
        Example example = new Example(SubjectType.class);
        example.orderBy("updatedTime").desc();
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("orgId",subjectTypeQueryDTO.getOrgId());
        criteria.andLike("subjectTypeName","%"+subjectTypeQueryDTO.getSubjectTypeName()+"%");
        return subjectTypeDao.querySubjectTypeByCondition(example);

    }

    @Override
    public List<SubjectTypeDTO> querySubjectTypeById(Long orgId) {
        Example example = new Example(SubjectType.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("orgId",orgId);
        return subjectTypeDao.querySubjectTypeByCondition(example);
    }

    @Override
    public int checkRepeatName(Example example) {
        return 0;
    }
}
