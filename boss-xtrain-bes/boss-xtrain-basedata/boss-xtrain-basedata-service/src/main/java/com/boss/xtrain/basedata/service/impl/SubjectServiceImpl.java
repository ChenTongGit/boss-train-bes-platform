package com.boss.xtrain.basedata.service.impl;

import com.boss.xtrain.basedata.dao.SubjectDao;
import com.boss.xtrain.basedata.pojo.dto.subject.*;
import com.boss.xtrain.basedata.pojo.vo.subject.*;
import com.boss.xtrain.common.core.exception.ServiceException;
import com.boss.xtrain.common.core.exception.error.BusinessError;
import com.boss.xtrain.common.core.http.CommonPage;
import com.boss.xtrain.common.util.IdWorker;
import com.boss.xtrain.common.util.PojoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.boss.xtrain.basedata.mapper.SubjectMapper;
import com.boss.xtrain.basedata.pojo.entity.Subject;
import com.boss.xtrain.basedata.service.SubjectService;

import java.util.List;


public class SubjectServiceImpl implements SubjectService{

    @Autowired
    private SubjectDao subjectDao;

    @Autowired
    private IdWorker idWorker;


    @Override
    public List<SubjectDTO> querySubjectByCondition(SubjectQueryDTO subjectQueryDTO) {
        Long orgId = subjectQueryDTO.getOrgId();
        if (orgId != null){
            return subjectDao.queryByCondition(subjectQueryDTO);
        }else {
            throw new ServiceException(BusinessError.BASE_DATA_SUBJECT_QUERY_ERROR);
        }
    }

    @Override
    public int insertSubject(SubjectInsertDTO subjectInsertDTO) {
        Subject subject =  new Subject();
        PojoUtils.copyProperties(subjectInsertDTO, subject);
        subject.setId(idWorker.nextId());
        subjectDao.insertSubject(subjectInsertDTO);

        if (!subjectInsertDTO.getSubjectAnswers().isEmpty()){

        }
        return 0;
    }

    @Override
    public int deleteSubject(SubjectDeleteDTO subjectDeleteDTO) {

        return 0;
    }

    @Override
    public int deleteSubjectByIds(SubjectDeleteDTO subjectDeleteDTO) {
        return 0;
    }

    @Override
    public void updateSubject(SubjectUpdateDTO subjectUpdateDTO) {

    }

    @Override
    public List<SubjectVO> getSubjectBydIds(SubjectVO subjectVO) {
        return null;
    }
}
