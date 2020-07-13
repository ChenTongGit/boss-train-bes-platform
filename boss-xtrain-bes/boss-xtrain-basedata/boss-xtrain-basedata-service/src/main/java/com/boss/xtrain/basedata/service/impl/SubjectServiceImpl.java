package com.boss.xtrain.basedata.service.impl;

import com.boss.xtrain.basedata.dao.*;
import com.boss.xtrain.basedata.pojo.dto.combexamconfig.CombExamItemDTO;
import com.boss.xtrain.basedata.pojo.dto.subject.*;
import com.boss.xtrain.basedata.pojo.entity.CombExamConfig;
import com.boss.xtrain.basedata.pojo.entity.CombExamItem;
import com.boss.xtrain.basedata.pojo.entity.SubjectAnswer;
import com.boss.xtrain.basedata.pojo.vo.subject.*;
import com.boss.xtrain.common.core.exception.BusinessException;
import com.boss.xtrain.common.core.exception.ServiceException;
import com.boss.xtrain.common.core.exception.error.BusinessError;
import com.boss.xtrain.common.util.IdWorker;
import com.boss.xtrain.common.util.PojoUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import com.boss.xtrain.basedata.pojo.entity.Subject;
import com.boss.xtrain.basedata.service.SubjectService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Slf4j
@Service
public class SubjectServiceImpl implements SubjectService{

    @Autowired
    private SubjectDao subjectDao;

    @Autowired
    private CategoryDao categoryDao;

    @Autowired
    private SubjectAnswerDao answerDao;

    @Autowired
    private CombExamConfigDao combExamConfigDao;

    @Autowired
    private CombExamItemDao combExamItemDao;

    @Autowired
    private IdWorker idWorker;


    @Override
    public List<SubjectDTO> querySubjectByCondition(SubjectQueryDTO subjectQueryDTO) {
        Long orgId = subjectQueryDTO.getOrgId();
        if(orgId != null){
            return subjectDao.queryByCondition(subjectQueryDTO.getOrgId(),subjectQueryDTO.getSubjectName(),subjectQueryDTO.getCategoryName(),subjectQueryDTO.getSubjectTypeName());
        }else {
            return subjectDao.queryAll();
        }
    }

    @Override
    public void insertSubject(SubjectUpdateDTO subjectUpdateDTO) {
        isNameAlreadyExist(subjectUpdateDTO);
        Subject subject = new Subject();
        PojoUtils.copyProperties(subjectUpdateDTO,subject);
        subject.setId(idWorker.nextId());
        subjectDao.insertSubject(subject);

        if(!subjectUpdateDTO.getSubjectAnswers().isEmpty()){
            for(SubjectAnswer subjectAnswer : subjectUpdateDTO.getSubjectAnswers()){
                subjectAnswer.setId(idWorker.nextId());
                subjectAnswer.setSubjectId(subject.getId());
            }
            List<SubjectAnswer> answerList = new ArrayList<>();
            answerDao.insertAnswer(answerList);
        }


    }

    @Override
    public void insertSubjectList(List<SubjectUpdateDTO> subjectUpdateDTOS) {

        for(SubjectUpdateDTO s : subjectUpdateDTOS){
            this.insertSubject(s);
        }

    }


    @Override
    public int deleteSubject(SubjectDeleteDTO subjectDeleteDTO) {
        answerDao.deleteAnswer(subjectDeleteDTO.getId());

        Example example = new Example(Subject.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("id",subjectDeleteDTO.getId());
        criteria.andEqualTo("version",subjectDeleteDTO.getVersion());
        subjectDao.deleteSubject(example);

        return 0;
    }

    @Override
    public int deleteSubjectList(SubjectDeleteIdsDTO subjectDeleteIdsDTO) {
        List<Long> ids = subjectDeleteIdsDTO.getIds();
        try{
            answerDao.deleteAnswerList(ids);
            return subjectDao.deleteSubject(ids);
        }catch (Exception e){
            throw new BusinessException(BusinessError.PAPER_PAPER_DELETE_ERROR);
        }
    }

    @Override
    public void updateSubject(SubjectUpdateDTO subjectUpdateDTO) {
        Subject subject = new Subject();
        PojoUtils.copyProperties(subjectUpdateDTO,subject);
        subjectDao.update(subject);

        answerDao.deleteAnswer(subject.getId());
        List<SubjectAnswer> subjectAnswerList = subjectUpdateDTO.getSubjectAnswers();
        for(SubjectAnswer s : subjectAnswerList){
            s.setId(idWorker.nextId());
            s.setSubjectId(subject.getId());
        }
        answerDao.insertAnswer(subjectAnswerList);


    }

    @Override
    public List<SubjectAnswerDTO> queryAnswer(SubjectAnswerQueryDTO answerQueryDTO) {
        Example example = new Example(SubjectAnswer.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("subjectId",answerQueryDTO.getSubjectId());
        return answerDao.queryAnswer(example);
    }

    @Override
    public List<SubjectDTO> querySubject(List<CombExamItemDTO> itemList) {
        List<SubjectDTO> subjectDTOList = new ArrayList<>();
        for(CombExamItemDTO item : itemList){
            Integer num = item.getNum();

            Example example = new Example(Subject.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("categoryId",item.getCategoryId());
            criteria.andEqualTo("subjectTypeId",item.getSubjectTypeId());
            criteria.andEqualTo("difficulty",item.getDifficulty());
            Integer actualNum = subjectDao.countSubject(example);
            log.info(actualNum.toString());

            BigDecimal score = item.getScore();
            if(num <= actualNum){
                List<Subject> subjects;
                if(num.equals(actualNum)){
                    subjects =  subjectDao.querySubject(item);
                }else{
                    subjects =  subjectDao.querySubjectRandom(item,num);
                }
                List<SubjectDTO> subjectDtoList = new ArrayList<>();
                PojoUtils.copyProperties(subjects,subjectDtoList);
                for(SubjectDTO s : subjectDtoList){
                    List<SubjectAnswer> subjectAnswers = answerDao.queryAnswerList(s.getId());
                    s.setSubjectAnswers(subjectAnswers);
                    s.setScore(score);
                    subjectDTOList.add(s);
                }
            }else{
                List<SubjectDTO> subjectDTOArrayList = new ArrayList<>();
                Long categoryId = item.getCategoryId();
                String name = categoryDao.queryCategoryById(categoryId).getName();
                SubjectDTO subjectDTO = new SubjectDTO();
                subjectDTO.setSubjectName(name);
                subjectDTOArrayList.add(subjectDTO);
                return subjectDTOArrayList;
            }
        }
        return subjectDTOList;

    }

    @Override
    public List<SubjectDTO> querySubjectByConfig(CombExamItemDTO configItemsDto) {
        List<CombExamItemDTO> itemList = new ArrayList<>();
        List<SubjectDTO> subjectDtoList = querySubject(itemList);
        if(subjectDtoList.get(0).getId() != null){
            CombExamConfig combExamConfig = new CombExamConfig();
            PojoUtils.copyProperties(configItemsDto,combExamConfig);
            combExamConfig.setId(idWorker.nextId());
            combExamConfig.setName(configItemsDto.getCategoryName());
            combExamConfig.setRemark(configItemsDto.getSubjectTypeName());
            combExamConfig.setCreatedBy(configItemsDto.getConfigId());
            combExamConfig.setVersion(1L);
            combExamConfigDao.insertCombExamConfig(combExamConfig);

            List<CombExamItem> configItemList = new ArrayList<>();
            PojoUtils.copyProperties(itemList,CombExamItem.class);
            for(CombExamItem item : configItemList){
                item.setCategoryId(idWorker.nextId());
                item.setCombExamConfigId(combExamConfig.getId());
            }
            combExamItemDao.insertItem(configItemList);
        }
        return subjectDtoList;

    }

    @Override
    public List<SubjectDTO> queryExamSubject(SubjectExamQueryDTO examSubjectQueryDTO) {
        Long orgId = examSubjectQueryDTO.getOrgId();
        Long subjectTypeId = examSubjectQueryDTO.getSubjectTypeId();
        return subjectDao.queryExamSubject(orgId,subjectTypeId);
    }

    @Override
    public SubjectExamDTO querySubjectById(List<Long> subjectIds) {
        return null;
    }


    @Override
    public Integer querySubjectCount(CombExamItemDTO configItemDto) {
        Example example = new Example(Subject.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("categoryName",configItemDto.getCategoryName());
        criteria.andEqualTo("subjectTypeName",configItemDto.getSubjectTypeName());
        criteria.andEqualTo("difficulty",configItemDto.getDifficulty());
        return subjectDao.countSubject(example);
    }

    @Override
    public void isNameAlreadyExist(SubjectUpdateDTO subjectUpdateDTO) {
        Example example = new Example(Subject.class);
        Example.Criteria criteria = example.createCriteria();
        if(subjectUpdateDTO.getOrganizationId()!= null){
            criteria.andEqualTo("orgId",subjectUpdateDTO.getOrganizationId());
        }
        criteria.andEqualTo("name",subjectUpdateDTO.getSubjectName());
        int count = subjectDao.queryNameCount(example);
        if(count != 0){
            throw new BusinessException(BusinessError.BASE_DATA_SUBJECT_REPEAT_ERROR);
        }

    }


}
