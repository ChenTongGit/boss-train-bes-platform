package com.boss.xtrain.basedata.service.impl;

import com.boss.xtrain.basedata.dao.SubjectTypeDao;
import com.boss.xtrain.basedata.pojo.dto.subjecttype.SubjectTypeDTO;
import com.boss.xtrain.basedata.pojo.dto.subjecttype.SubjectTypeDeleteDTO;
import com.boss.xtrain.basedata.pojo.dto.subjecttype.SubjectTypeDeleteIdsDTO;
import com.boss.xtrain.basedata.pojo.dto.subjecttype.SubjectTypeQueryDTO;
import com.boss.xtrain.common.core.exception.BusinessException;
import com.boss.xtrain.common.core.exception.error.BusinessError;
import com.boss.xtrain.common.util.IdWorker;
import com.boss.xtrain.common.util.PojoUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import com.boss.xtrain.basedata.pojo.entity.SubjectType;
import com.boss.xtrain.basedata.service.SubjectTypeService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import java.util.List;

/**
 * @author guo xinrui
 * @description 题目类型service
 * @date 2020/07/08
 */
@Service
@Slf4j
public class SubjectTypeServiceImpl implements SubjectTypeService{

    @Autowired
    private SubjectTypeDao subjectTypeDao;

    @Autowired
    private IdWorker idWorker;

    private final static String ORG_ID = "organizationId";

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
        return subjectTypeDao.deleteSubjectType(example)==1;
    }

    @Override
    public boolean deleteSubjectTypes(SubjectTypeDeleteIdsDTO subjectTypeDeleteIdsDTO) {
        List<SubjectTypeDeleteDTO> subjectTypeDeleteDTOS = subjectTypeDeleteIdsDTO.getIds();

        for (SubjectTypeDeleteDTO subjectTypeDeleteDTO : subjectTypeDeleteDTOS){
            try {
                Example example = new Example(SubjectType.class);
                Example.Criteria criteria = example.createCriteria();
                criteria.andEqualTo("id",subjectTypeDeleteDTO.getId());
                subjectTypeDao.deleteSubjectType(example);
                log.info(subjectTypeDeleteDTO.toString());
            }catch (Exception e){
                Example example = new Example(SubjectType.class);
                Example.Criteria criteria = example.createCriteria();
                criteria.andEqualTo("id",subjectTypeDeleteDTO.getId());
                List<SubjectTypeDTO> subjectTypeDTOS = subjectTypeDao.queryByCondition(example);
                for (SubjectTypeDTO subjectTypeDTO : subjectTypeDTOS){
                    if (subjectTypeDTO.getStatus() == 1){
                        throw new BusinessException(BusinessError.BASE_DATA_SUBJECT_TYPE_INUSE_ERROR,e);
                    }

                }

            }

        }
        return true;
    }

    @Override
    public void updateSubjectType(SubjectTypeDTO subjectTypeDTO) {
        SubjectType subjectType = new SubjectType();
        PojoUtils.copyProperties(subjectTypeDTO,subjectType);
        subjectTypeDao.updateSubjectType(subjectType);
    }

    @Override
    public List<SubjectTypeDTO> querySubjectType(SubjectTypeQueryDTO subjectTypeQueryDTO) {
        Example example = new Example(SubjectType.class);
        example.orderBy("updatedTime").desc();
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo(ORG_ID,subjectTypeQueryDTO.getOrgId());
        criteria.andLike("name","%"+subjectTypeQueryDTO.getName()+"%");
        log.info(subjectTypeDao.queryByCondition(example).toString());
        return subjectTypeDao.queryByCondition(example);

    }

    @Override
    public List<SubjectTypeDTO> queryAll() {
        List<SubjectType> subjectTypes = subjectTypeDao.queryAll();
        return PojoUtils.copyListProperties(subjectTypes,SubjectTypeDTO::new);
    }

    @Override
    public List<SubjectTypeDTO> querySubjectTypeById(Long orgId) {
        Example example = new Example(SubjectType.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo(ORG_ID,orgId);
        return subjectTypeDao.queryByCondition(example);
    }

    @Override
    public int checkRepeatName(SubjectTypeDTO subjectTypeDTO) {
        Example example = new Example(SubjectType.class);
        Example.Criteria criteria = example.createCriteria();
        if(subjectTypeDTO.getOrganizationId()!= null){
            criteria.andEqualTo(ORG_ID,subjectTypeDTO.getOrganizationId());
        }
        criteria.andEqualTo("name",subjectTypeDTO.getName());
        int result = subjectTypeDao.checkRepeatName(example);
        if(result != 0){
            throw new BusinessException(BusinessError.BASE_DATA_SUBJECT_TYPE_REPEAT_ERROR);
        }
        return result;
    }
}
