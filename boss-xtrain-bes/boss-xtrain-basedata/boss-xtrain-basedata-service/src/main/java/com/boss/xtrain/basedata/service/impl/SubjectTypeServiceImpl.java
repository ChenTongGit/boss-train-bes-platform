package com.boss.xtrain.basedata.service.impl;

import com.boss.xtrain.basedata.dao.SubjectTypeDao;
import com.boss.xtrain.basedata.pojo.dto.subject.SubjectDeleteDTO;
import com.boss.xtrain.basedata.pojo.dto.subjecttype.SubjectTypeDTO;
import com.boss.xtrain.basedata.pojo.dto.subjecttype.SubjectTypeDeleteDTO;
import com.boss.xtrain.basedata.pojo.dto.subjecttype.SubjectTypeQueryDTO;
import com.boss.xtrain.basedata.pojo.vo.subject.SubjectDeleteVO;
import com.boss.xtrain.common.core.exception.BusinessException;
import com.boss.xtrain.common.core.exception.error.BusinessError;
import com.boss.xtrain.common.util.IdWorker;
import com.boss.xtrain.common.util.PojoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import com.boss.xtrain.basedata.pojo.entity.SubjectType;
import com.boss.xtrain.basedata.service.SubjectTypeService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

@Service
public class SubjectTypeServiceImpl implements SubjectTypeService{

    @Autowired
    private SubjectTypeDao subjectTypeDao;

    @Autowired
    private IdWorker idWorker;

    @Override
    public int insertSubjectType(SubjectTypeDTO subjectTypeDTO) {
        SubjectType subjectType = new SubjectType();
        PojoUtils.copyProperties(subjectTypeDTO,subjectType);
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
    public boolean deleteSubjectTypes(List<SubjectTypeDeleteDTO> subjectTypeDeleteDTOS) {
        for (SubjectTypeDeleteDTO subjectTypeDeleteDTO : subjectTypeDeleteDTOS){
            Example example = new Example(SubjectType.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("id",subjectTypeDeleteDTO.getId());
            criteria.andEqualTo("version",subjectTypeDeleteDTO.getVersion());
            subjectTypeDao.deleteSubjectType(example);
        }
        return true;
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
        criteria.andEqualTo("organizationId",subjectTypeQueryDTO.getOrgId());
        criteria.andLike("name","%"+subjectTypeQueryDTO.getName()+"%");
        return subjectTypeDao.queryByCondition(example);

    }

    @Override
    public List<SubjectTypeDTO> querySubjectTypeById(Long orgId) {
        Example example = new Example(SubjectType.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("organizationId",orgId);
        return subjectTypeDao.queryByCondition(example);
    }

    @Override
    public int checkRepeatName(SubjectTypeDTO subjectTypeDTO) {
        Example example = new Example(SubjectType.class);
        Example.Criteria criteria = example.createCriteria();
        if(subjectTypeDTO.getOrganizationId()!= null){
            criteria.andEqualTo("organizationId",subjectTypeDTO.getOrganizationId());
        }
        criteria.andEqualTo("name",subjectTypeDTO.getName());
        int result = subjectTypeDao.checkRepeatName(example);
        if(result != 0){
            throw new BusinessException(BusinessError.BASE_DATA_SUBJECT_TYPE_REPEAT_ERROR);
        }
        return result;
    }
}
