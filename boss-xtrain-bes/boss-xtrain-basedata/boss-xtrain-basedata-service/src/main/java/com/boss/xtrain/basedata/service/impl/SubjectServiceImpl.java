package com.boss.xtrain.basedata.service.impl;

import com.boss.xtrain.basedata.dao.*;
import com.boss.xtrain.basedata.pojo.dto.combexamconfig.CombExamItemDTO;
import com.boss.xtrain.basedata.pojo.dto.paper.ConfigItemDTO;
import com.boss.xtrain.basedata.pojo.dto.paper.StandardCombDTO;
import com.boss.xtrain.basedata.pojo.dto.subject.*;
import com.boss.xtrain.basedata.pojo.entity.*;
import com.boss.xtrain.common.core.exception.BusinessException;
import com.boss.xtrain.common.core.exception.error.BusinessError;
import com.boss.xtrain.common.util.IdWorker;
import com.boss.xtrain.common.util.PojoUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import com.boss.xtrain.basedata.service.SubjectService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author guo xinrui
 * @description 题目service
 * @date 2020/07/08
 */
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
    private SubjectTypeDao subjectTypeDao;

    @Autowired
    private CombExamConfigDao combExamConfigDao;

    @Autowired
    private CombExamItemDao combExamItemDao;

    @Autowired
    private IdWorker idWorker;

    private String ORG_ID = "organizationId";
    @Override
    public List<SubjectDTO> querySubjectByCondition(SubjectQueryDTO subjectQueryDTO) {
        List<SubjectDTO> subjectDTOList;
        Long orgId = subjectQueryDTO.getOrgId();

        Example example = new Example(Subject.class);
        Example.Criteria criteria = example.createCriteria();

        SubjectUpdateDTO subjectUpdateDTO = new SubjectUpdateDTO();
        PojoUtils.copyProperties(subjectQueryDTO, subjectUpdateDTO);

        criteria.andEqualTo(ORG_ID,subjectUpdateDTO.getOrganizationId());

        List<SubjectDTO> subjectDTOS;
        if (orgId != null) {
            if (!subjectUpdateDTO.getCategoryName().equals("")) {
                subjectDTOS = querySubjectByCategory(subjectUpdateDTO);
                return subjectDTOS;
            }
            if (!subjectUpdateDTO.getSubjectTypeName().equals("")){
                subjectDTOS = querySubjectByType(subjectUpdateDTO);
                return subjectDTOS;
            }
            criteria.andEqualTo(ORG_ID,orgId);
            criteria.andLike("name","%"+subjectUpdateDTO.getName()+"%");
            subjectDTOList = subjectDao.queryByCondition(example);
            for (SubjectDTO subjectDTO : subjectDTOList){
                Category category = categoryDao.queryCategoryById(subjectDTO.getCategoryId());
                SubjectType subjectType = subjectTypeDao.queryTypeById(subjectDTO.getSubjectTypeId());
                subjectDTO.setCategoryName(category.getName());
                subjectDTO.setSubjectTypeName(subjectType.getName());
            }
            return subjectDTOList;
        }else {
            return subjectDao.queryAll();
        }
    }

    @Override
    public void insertSubject(SubjectUpdateDTO subjectUpdateDTO) {
        checkRepeatName(subjectUpdateDTO);
        Subject subject = new Subject();
        log.info(subjectUpdateDTO.toString());
        List<Long> categoryIds = getCategoryIdBy(subjectUpdateDTO);
        for (Long id : categoryIds){
            subject.setCategoryId(id);
        }
        List<Long> typeIds = getSubjectTypeIdBy(subjectUpdateDTO);
        for (Long id : typeIds){
            subject.setSubjectTypeId(id);
        }
        PojoUtils.copyProperties(subjectUpdateDTO,subject);
        subject.setId(idWorker.nextId());
        log.info(subject.toString());
        subjectDao.insertSubject(subject);

        if(!subjectUpdateDTO.getSubjectAnswers().isEmpty()){
            for(SubjectAnswer subjectAnswer : subjectUpdateDTO.getSubjectAnswers()){
                subjectAnswer.setId(idWorker.nextId());
                subjectAnswer.setSubjectId(subject.getId());
            }
            List<SubjectAnswer> answerList = PojoUtils.copyListProperties(subjectUpdateDTO.getSubjectAnswers(),SubjectAnswer::new);
            answerDao.insertAnswer(answerList);
        }else {
            throw new BusinessException(BusinessError.BASE_DATA_SUBJECT_INSERT_ERROR);
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
        List<SubjectDeleteDTO> subjectDeleteDTOS = subjectDeleteIdsDTO.getIds();
        List<Long> ids =  subjectDeleteDTOS.stream().map(SubjectDeleteDTO::getId).collect(Collectors.toList());
        try{
            answerDao.deleteAnswerList(ids);
            return subjectDao.deleteSubject(ids);
        }catch (Exception e){
            throw new BusinessException(BusinessError.BASE_DATA_SUBJECT_DELETE_ERROR);
        }
    }

    @Override
    public void updateSubject(SubjectUpdateDTO subjectUpdateDTO) {
        Subject subject = new Subject();
        log.info(subjectUpdateDTO.toString());
        PojoUtils.copyProperties(subjectUpdateDTO,subject);
        log.info(subject.toString());
        subjectDao.updateSubject(subject);

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
    public List<SubjectAnswerDTO> querySubjectOtherInfo(SubjectAnswerQueryDTO answerQueryDTO){
        SubjectDTO subjectDTO = subjectDao.querySubjectOtherInfo(answerQueryDTO.getSubjectId());

        Category category = categoryDao.queryCategoryById(subjectDTO.getCategoryId());
        SubjectType subjectType = subjectTypeDao.queryTypeById(subjectDTO.getSubjectTypeId());
        Example example3 = new Example(Subject.class);
        Example.Criteria criteria3 = example3.createCriteria();
        criteria3.andEqualTo("difficulty",subjectDTO.getId());
        List<String> difficulties = subjectDao.querySubjectDifficult(example3);

        List<SubjectAnswerDTO> subjectAnswerDTOS =  queryAnswer(answerQueryDTO);
        if (subjectAnswerDTOS.isEmpty() || category.getName().isEmpty() || subjectType.getName().isEmpty() || difficulties.isEmpty()){
            throw new BusinessException(BusinessError.BASE_DATA_SUBJECT_UPDATE_ERROR);
        }else {
            for (SubjectAnswerDTO s : subjectAnswerDTOS) {
                s.setCategoryName(category.getName());
                s.setSubjectTypeName(subjectType.getName());
                s.setDifficulty(difficulties.get(0));

            }
        }
        return subjectAnswerDTOS;

    }

    @Override
    public List<DifficultDTO> queryDifficult(DifficultQueryDTO difficultQueryDTO) {
        Example example = new Example(Dictionary.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("category",difficultQueryDTO.getCategory());
        return subjectDao.queryDifficult(example);
    }

    @Override
    public List<Long> queryCategoryIdByName(SubjectUpdateDTO subjectUpdateDTO) {
        Example example = new Example(Category.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andLike("name","%"+subjectUpdateDTO.getCategoryName()+"%");
        return subjectDao.queryCategoryIdByName(example);
    }

    @Override
    public List<Long> queryTypeIdByName(SubjectUpdateDTO subjectUpdateDTO) {
        Example example = new Example(SubjectType.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andLike("name","%"+subjectUpdateDTO.getSubjectTypeName()+"%");
        return subjectDao.queryTypeIdByName(example);
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
            criteria.andEqualTo("difficulty",item.getDifficultyName());
            Integer actualNum = subjectDao.countSubject(example);
            BigDecimal score = item.getScore();
            if(num <= actualNum){
                List<Subject> subjects;
                if(num.equals(actualNum)){
                    subjects =  subjectDao.querySubject(item);
                }else{
                    subjects =  subjectDao.querySubjectRandom(item,num);
                }
                List<SubjectDTO> subjectDtoList = PojoUtils.copyListProperties(subjects,SubjectDTO::new);
                Category category = new Category();
                SubjectType subjectType = new SubjectType();
                List<String> difficulties = new ArrayList<>();

                int count = 0;
                for (Subject subject : subjects){
                    category= categoryDao.queryCategoryById(subject.getCategoryId());
                    subjectType = subjectTypeDao.queryTypeById(subject.getSubjectTypeId());
                    Example example3 = new Example(Subject.class);
                    Example.Criteria criteria3 = example3.createCriteria();
                    criteria3.andEqualTo("difficulty",subject.getId());
                    difficulties = subjectDao.querySubjectDifficult(example);
                }
                if (subjects.isEmpty() || category.getName().isEmpty() || subjectType.getName().isEmpty() || difficulties.isEmpty()){
                    throw new BusinessException(BusinessError.MAINTAIN_PAPER_DELETE_ERROR);
                }else {
                    for (SubjectDTO s : subjectDtoList) {
                        s.setCategoryName(category.getName());
                        s.setSubjectTypeName(subjectType.getName());
                        s.setDifficulty(difficulties.get(count));
                        if (subjectDtoList.size() < count-1) {
                            count++;
                        }
                    }
                }
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
                subjectDTO.setName(name);
                subjectDTOArrayList.add(subjectDTO);
                return subjectDTOArrayList;
            }
        }
        return subjectDTOList;

    }

    @Override
    public List<SubjectDTO> querySubjectByConfig(StandardCombDTO standardCombDTO) {
        List<ConfigItemDTO> itemList = standardCombDTO.getItemList();
        List<CombExamItemDTO> itemDTOS = PojoUtils.copyListProperties(itemList,CombExamItemDTO::new);
        List<SubjectDTO> subjectDtoList = querySubject(itemDTOS);
        log.info(subjectDtoList.toString());
        if(subjectDtoList.get(0).getId() != null){
            CombExamConfig combExamConfig = new CombExamConfig();
            PojoUtils.copyProperties(standardCombDTO,combExamConfig);
            combExamConfig.setId(idWorker.nextId());
            combExamConfig.setName(standardCombDTO.getCombConfigName());
            combExamConfig.setRemark(standardCombDTO.getDiscript());
            combExamConfig.setCreatedBy(standardCombDTO.getCreatedBy());
            combExamConfig.setVersion(1L);
            combExamConfigDao.insertCombExamConfig(combExamConfig);

            List<CombExamItem> configItemList = PojoUtils.copyListProperties(itemList,CombExamItem::new);
            for(CombExamItem item : configItemList){
                item.setCategoryId(idWorker.nextId());
                item.setCombExamConfigId(combExamConfig.getId());
            }
            combExamItemDao.insertItem(configItemList);
        }
        return subjectDtoList;

    }

    @Override
    public List<Long> getCategoryIdBy(SubjectUpdateDTO subjectUpdateDTO) {
        Example example = new Example(Category.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andLike("name",subjectUpdateDTO.getCategoryName());
        return subjectDao.queryCategoryIdByName(example);
    }

    @Override
    public List<Long> getSubjectTypeIdBy(SubjectUpdateDTO subjectUpdateDTO) {
        Example example = new Example(SubjectType.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andLike("name",subjectUpdateDTO.getSubjectTypeName());
        return subjectDao.queryTypeIdByName(example);
    }

    @Override
    public List<SubjectDTO> querySubjectByCategory(SubjectUpdateDTO subjectUpdateDTO) {
        Example example = new Example(Subject.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo(ORG_ID,subjectUpdateDTO.getOrganizationId());
        List<SubjectDTO> subjectDTOS = new ArrayList<>();
            List<Long> categoryIds = queryCategoryIdByName(subjectUpdateDTO);
            for (Long id : categoryIds) {
                subjectUpdateDTO.setCategoryId(id);
                criteria.andEqualTo("categoryId", subjectUpdateDTO.getCategoryId());
                Category category = categoryDao.queryCategoryById(subjectUpdateDTO.getCategoryId());
                criteria.andLike("name", "%" + subjectUpdateDTO.getName() + "%");

                if (subjectDao.queryByCondition(example).size()>0) {
                    subjectDTOS = subjectDao.queryByCondition(example);
                }

                for (SubjectDTO subjectDTO : subjectDTOS) {
                    subjectDTO.setCategoryName(category.getName());
                    SubjectType subjectType = subjectTypeDao.queryTypeById(subjectDTO.getSubjectTypeId());
                    subjectDTO.setSubjectTypeName(subjectType.getName());
                }

            }
        return subjectDTOS;
    }

    @Override
    public List<SubjectDTO> querySubjectByType(SubjectUpdateDTO subjectUpdateDTO) {
        Example example = new Example(Subject.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo(ORG_ID,subjectUpdateDTO.getOrganizationId());
        List<Long> typesIds = queryTypeIdByName(subjectUpdateDTO);
        List<SubjectDTO> subjectDTOS = new ArrayList<>();

        for (Long id : typesIds) {
            subjectUpdateDTO.setSubjectTypeId(id);
            criteria.andEqualTo("subjectTypeId", subjectUpdateDTO.getSubjectTypeId());
            criteria.andLike("name", "%" + subjectUpdateDTO.getName() + "%");
            if (subjectDao.queryByCondition(example).size() > 0) {
                subjectDTOS = subjectDao.queryByCondition(example);
            }

            for (SubjectDTO subjectDTO : subjectDTOS) {
                SubjectType subjectType = subjectTypeDao.queryTypeById(subjectDTO.getSubjectTypeId());
                Category category = categoryDao.queryCategoryById(subjectDTO.getCategoryId());
                subjectDTO.setSubjectTypeName(subjectType.getName());
                subjectDTO.setCategoryName(category.getName());
            }

        }

        return subjectDTOS;
    }

    @Override
    public List<SubjectDTO> queryExamSubject(SubjectExamQueryDTO examSubjectQueryDTO) {
        Long orgId = examSubjectQueryDTO.getOrgId();
        Long subjectTypeId = examSubjectQueryDTO.getSubjectTypeId();
        return subjectDao.queryExamSubject(orgId,subjectTypeId);
    }

    @Override
    public SubjectExamDTO querySubjectById(List<Long> subjectIds) {
        List<SubjectDTO> subjectDtoList = new ArrayList<>();
        for(Long subjectId : subjectIds){
            subjectDtoList.add(subjectDao.querySubjectById(subjectId));
        }
        return null;

    }


    @Override
    public Integer querySubjectCount(CombExamItemDTO configItemDto) {
        if (configItemDto.getDifficultyName().equals("简单")){
            configItemDto.setDifficulty(1L);
        }else if (configItemDto.getDifficultyName().equals("中等")){
            configItemDto.setDifficulty(2L);
        }else if (configItemDto.getDifficultyName().equals("复杂")){
            configItemDto.setDifficulty(3L);
        }
        Example example = new Example(Subject.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("categoryId",configItemDto.getCategoryId());
        criteria.andEqualTo("subjectTypeId",configItemDto.getSubjectTypeId());
        criteria.andEqualTo("difficulty",configItemDto.getDifficulty());
        return subjectDao.countSubject(example);
    }

    @Override
    public void checkRepeatName(SubjectUpdateDTO subjectUpdateDTO) {
        Example example = new Example(Subject.class);
        Example.Criteria criteria = example.createCriteria();
        log.info(String.valueOf(subjectUpdateDTO.getOrganizationId()));
        if(subjectUpdateDTO.getOrganizationId()!= null){
            criteria.andEqualTo(ORG_ID,subjectUpdateDTO.getOrganizationId());
        }
        criteria.andEqualTo("name",subjectUpdateDTO.getName());
        log.info(subjectUpdateDTO.getName());
        int count = subjectDao.queryNameCount(example);
        log.info(String.valueOf(count));
        if(count != 0){
            throw new BusinessException(BusinessError.BASE_DATA_SUBJECT_REPEAT_ERROR);
        }

    }


}
