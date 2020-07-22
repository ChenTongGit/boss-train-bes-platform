package com.boss.xtrain.basedata.service.impl;

import com.boss.xtrain.basedata.dao.*;
import com.boss.xtrain.basedata.mapper.SubjectTypeMapper;
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

    @Autowired
    private SubjectTypeMapper subjectTypeMapper;


    @Override
    public List<SubjectDTO> querySubjectByCondition(SubjectQueryDTO subjectQueryDTO) {
        List<SubjectDTO> subjectDTOList = new ArrayList<>();
        Long orgId = subjectQueryDTO.getOrgId();
        String name= subjectQueryDTO.getName();
        String subjectTypeName = subjectQueryDTO.getSubjectTypeName();
        //Long categoryId = subjectQueryDTO.getCategoryId();
        String categoryName = subjectQueryDTO.getCategoryName();
        subjectQueryDTO.setCategoryName(categoryName);

        Example example = new Example(Subject.class);
        Example.Criteria criteria = example.createCriteria();

        SubjectUpdateDTO subjectUpdateDTO = new SubjectUpdateDTO();
        PojoUtils.copyProperties(subjectQueryDTO,subjectUpdateDTO);
        log.info(subjectUpdateDTO.toString());

        List<Long> typesIds = queryTypeIdByName(subjectUpdateDTO);
        log.info(typesIds.toString());
        List<Long> categoryIds = queryCategoryIdByName(subjectUpdateDTO);


        if(orgId != null){
            Category category;
            List<SubjectDTO> subjectDTOS = new ArrayList<>();
            criteria.andEqualTo("organizationId",orgId);
            if (!categoryName.equals("")){
                for (Long id :categoryIds){
                    subjectUpdateDTO.setCategoryId(id);
                    criteria.andEqualTo("categoryId",subjectUpdateDTO.getCategoryId());
                    category = categoryDao.queryCategoryById(subjectUpdateDTO.getCategoryId());
                    criteria.andLike("name","%"+name+"%");

                    if (subjectDao.queryByCondition(example).size()>0){
                        subjectDTOS = subjectDao.queryByCondition(example);
                    }
                    Example example1 = new Example(SubjectType.class);
                    Example.Criteria criteria1 = example1.createCriteria();
                    for (SubjectDTO subjectDTO : subjectDTOS){
                        subjectDTO.setCategoryName(category.getName());
                        criteria1.andEqualTo("id",subjectDTO.getSubjectTypeId());
                        List<String> typeNameById = subjectTypeDao.queryTypeNameById(example1);
                        subjectDTO.setSubjectTypeName(typeNameById.get(0));
                    }

                }
                log.info(subjectDTOS.toString());
                return subjectDTOS;
            }

            if (!subjectTypeName.equals("")){
                for (Long id : typesIds){
                    subjectUpdateDTO.setSubjectTypeId(id);
                    criteria.andEqualTo("subjectTypeId",subjectUpdateDTO.getSubjectTypeId());
                    log.info(subjectUpdateDTO.getSubjectTypeId().toString());
                    criteria.andLike("name","%"+name+"%");
                    if (subjectDao.queryByCondition(example).size()>0){
                        subjectDTOS = subjectDao.queryByCondition(example);
                    }
                    log.info("sbdto:{}",subjectDTOS.toString());
                    Example example1 = new Example(SubjectType.class);
                    Example.Criteria criteria1 = example1.createCriteria();

                    for (SubjectDTO subjectDTO : subjectDTOS){
                        criteria1.andEqualTo("id",subjectDTO.getSubjectTypeId());
                        List<String> typeList = subjectTypeDao.queryTypeNameById(example1);
                        log.info("typelist{}",typeList.toString());
                        category = categoryDao.queryCategoryById(subjectDTO.getCategoryId());
                        subjectDTO.setSubjectTypeName(typeList.get(0));
                        subjectDTO.setCategoryName(category.getName());
                        log.info(subjectDTO.toString());
                    }

                }

                log.info("dtos:{}",subjectDTOS.toString());
                return subjectDTOS;
            }

            SubjectType subjectType = new SubjectType();
            criteria.andEqualTo("organizationId",orgId);
            criteria.andLike("name","%"+name+"%");
            subjectDTOList = subjectDao.queryByCondition(example);
            log.info(subjectDTOList.toString());
            for (SubjectDTO subjectDTO : subjectDTOList){
                category = categoryDao.queryCategoryById(subjectDTO.getCategoryId());
                subjectType = subjectTypeMapper.selectByPrimaryKey(subjectDTO.getSubjectTypeId());
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
        Example example = new Example(Subject.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("id",answerQueryDTO.getSubjectId());
        List<SubjectDTO> subjectDTOS = subjectDao.querySubjectOtherInfo(example);

        log.info(subjectDTOS.toString());
        List<String> categoryNames = new ArrayList<>();
        List<String> typeNames = new ArrayList<>();
        List<String> difficulties = new ArrayList<>();

        for (SubjectDTO subjectDTO : subjectDTOS){
            Example example1 = new Example(Category.class);
            Example.Criteria criteria1 = example1.createCriteria();
            criteria1.andEqualTo("id",subjectDTO.getCategoryId());
            categoryNames = categoryDao.queryCategoryNameById(example1);
            Example example2 = new Example(SubjectType.class);
            Example.Criteria criteria2 = example2.createCriteria();
            criteria2.andEqualTo("id",subjectDTO.getSubjectTypeId());
            typeNames = subjectTypeDao.queryTypeNameById(example2);
            Example example3 = new Example(Subject.class);
            Example.Criteria criteria3 = example3.createCriteria();
            criteria3.andEqualTo("difficulty",subjectDTO.getId());
            difficulties = subjectDao.querySubjectDifficult(example);
        }

        log.info(typeNames.toString());
        log.info(categoryNames.toString());
        log.info(difficulties.toString());
        int count = 0;

        List<SubjectAnswerDTO> subjectAnswerDTOS =  queryAnswer(answerQueryDTO);
        if (subjectAnswerDTOS.isEmpty() || categoryNames.isEmpty() || typeNames.isEmpty() || difficulties.isEmpty()){
            throw new BusinessException(BusinessError.BASE_DATA_SUBJECT_UPDATE_ERROR);
        }else {
            for (SubjectAnswerDTO s : subjectAnswerDTOS) {
                s.setCategoryName(categoryNames.get(count));
                log.info("categoryName:{}", categoryNames.get(count));
                s.setSubjectTypeName(typeNames.get(count));
                s.setDifficulty(difficulties.get(count));
                count++;
            }
        }


        log.info(subjectAnswerDTOS.toString());


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
            log.info(actualNum.toString());

            BigDecimal score = item.getScore();
            if(num <= actualNum){
                List<Subject> subjects;
                if(num.equals(actualNum)){
                    subjects =  subjectDao.querySubject(item);
                }else{
                    subjects =  subjectDao.querySubjectRandom(item,num);
                }
                log.info(subjects.toString());
                List<SubjectDTO> subjectDtoList = PojoUtils.copyListProperties(subjects,SubjectDTO::new);
                List<String> categoryNames = new ArrayList<>();
                List<String> typeNames = new ArrayList<>();
                List<String> difficulties = new ArrayList<>();

                int count = 0;
                for (Subject subject : subjects){
                    Example example1 = new Example(Category.class);
                    Example.Criteria criteria1 = example1.createCriteria();
                    criteria1.andEqualTo("id",subject.getCategoryId());
                    categoryNames = categoryDao.queryCategoryNameById(example1);
                    Example example2 = new Example(SubjectType.class);
                    Example.Criteria criteria2 = example2.createCriteria();
                    criteria2.andEqualTo("id",subject.getSubjectTypeId());
                    typeNames = subjectTypeDao.queryTypeNameById(example2);
                    Example example3 = new Example(Subject.class);
                    Example.Criteria criteria3 = example3.createCriteria();
                    criteria3.andEqualTo("difficulty",subject.getId());
                    difficulties = subjectDao.querySubjectDifficult(example);
                }
                if (subjects.isEmpty() || categoryNames.isEmpty() || typeNames.isEmpty() || difficulties.isEmpty()){
                    throw new BusinessException(BusinessError.MAINTAIN_PAPER_DELETE_ERROR);
                }else {
                    for (SubjectDTO s : subjectDtoList) {
                        s.setCategoryName(categoryNames.get(count));
                        s.setSubjectTypeName(typeNames.get(count));
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
        if (configItemDto.getDifficultyName() == "简单"){
            configItemDto.setDifficulty(1L);
        }else if (configItemDto.getDifficultyName() == "中等"){
            configItemDto.setDifficulty(2L);
        }else if (configItemDto.getDifficultyName() == "复杂"){
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
            criteria.andEqualTo("organizationId",subjectUpdateDTO.getOrganizationId());
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
