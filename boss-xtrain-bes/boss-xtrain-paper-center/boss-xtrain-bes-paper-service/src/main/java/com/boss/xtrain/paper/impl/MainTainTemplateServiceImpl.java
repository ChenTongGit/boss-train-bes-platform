package com.boss.xtrain.paper.impl;

import com.boss.xtrain.common.core.exception.BusinessException;
import com.boss.xtrain.common.util.IdWorker;
import com.boss.xtrain.common.util.PojoUtils;
import com.boss.xtrain.papaer.annotation.TryCatch;
import com.boss.xtrain.paper.MainTainTemplateService;
import com.boss.xtrain.paper.dao.MainTainTemplateDao;
import com.boss.xtrain.paper.dto.templatemanage.*;
import com.boss.xtrain.paper.entity.Paper;
import com.boss.xtrain.paper.entity.PaperSubject;
import com.boss.xtrain.paper.entity.PaperSubjectAnswer;
import com.boss.xtrain.paper.vo.templatemanage.SubjectVO;
import com.boss.xtrain.paper.vo.templatemanage.TemplateVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.boss.xtrain.common.core.exception.error.BusinessError.*;

@Service
public class MainTainTemplateServiceImpl implements MainTainTemplateService {
    Long version;
    @Autowired
    private MainTainTemplateDao mainTainTemplateDao;

    /**
     * @param templateQueryDto
     * @methodsName: queryTemplate
     * @description: 获取模板集合
     * @param: templateQueryDto
     * @return: java.util.List<com.boss.bes.paper.pojo.vo.templatemanage.TemplateVO>
     * @throws:
     */
    @Override
    @TryCatch
    public List<TemplateVO> queryTemplate(TemplateQueryDTO templateQueryDto) {

        return mainTainTemplateDao.queryTemplateList(templateQueryDto);
    }



    /**
     * @param subjectQueryDto
     * @methodsName: querySubjectList
     * @description: 查询指定模板的题目集合
     * @param: subjectQueryDto
     * @return: java.util.List<com.boss.bes.paper.pojo.vo.templatemanage.SubjectVO>
     * @throws:
     */
    @Override
    @TryCatch
    public List<SubjectVO> querySubjectList(SubjectQueryDTO subjectQueryDto) {
        //查询模板题目前，查询模板的version
        return mainTainTemplateDao.querySubjectList(subjectQueryDto.getPaperId());

    }


    /**
     * /**
     *
     * @param deleteTemplateDto
     * @methodsName: deleteTemplateById
     * @description: 删除指定模板
     * @param: deleteTemplateDto
     * @return: void
     * @throws:
     */
    @Override
    @TryCatch
    public void deleteTemplateById(DeleteTemplateDTO deleteTemplateDto) {
        if(mainTainTemplateDao.deleteTemplateById(deleteTemplateDto.getPaperId())==0){
            throw new BusinessException(MAINTAIN_TEMPLATE_DELETE_ERROR);
        }
    }

    /**
     * @param templateListDTO
     * @methodsName: deleteTemplateByList
     * @description: 批量删除模板
     * @param: templateListDTO
     * @return: void
     * @throws:
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    @TryCatch
    public void deleteTemplateByList(TemplateListDTO templateListDTO) {
        List<Paper> list = PojoUtils.copyListProperties(templateListDTO.getDeleteTemplateVos(),Paper::new);
        Integer count = mainTainTemplateDao.deleteTemplateByList(list);
        if (count != templateListDTO.getDeleteTemplateVos().size()){
            throw new BusinessException(MAINTAIN_TEMPLATE_BATCHDELETE_ERROR);
        }
    }




    @Override
    @Transactional(rollbackFor = Exception.class)
    @TryCatch
    public void updateSubejctList(TemplateUpdateDTO templateUpdateDto) {
        //为题目和答案赋值ID
        IdWorker idWorker = new IdWorker();
        List<AnswerDTO> answerDtoList = new ArrayList<>();
        List<SubjectDTO> subjectDtoList = templateUpdateDto.getSubjectList();
        for (SubjectDTO subjectDTO : subjectDtoList) {
            long subjectId = idWorker.nextId();
            subjectDTO.setSubjectId(subjectId);
            List<AnswerDTO> answers = subjectDTO.getAnswers();
            for (AnswerDTO answer : answers) {
                long answerId = idWorker.nextId();
                answer.setAnswerId(answerId);
                answer.setSubjectId(subjectId);
                answerDtoList.add(answer);
            }
        }
        //答案集合
        List<PaperSubjectAnswer> paperSubjectAnswers = PojoUtils.copyListProperties(answerDtoList,PaperSubjectAnswer::new);
        //题目集合
        List<SubjectDTO> subjectList = templateUpdateDto.getSubjectList();
        List<PaperSubject> tPaperSubjects = PojoUtils.copyListProperties(subjectList, PaperSubject::new);
        //获取试卷总分
        float score = 0;
        List<SubjectDTO> subjectDtos = templateUpdateDto.getSubjectList();
        for (SubjectDTO subjectDTO : subjectDtos) {
            score += subjectDTO.getScore().floatValue();
        }
        BigDecimal paperScore =BigDecimal.valueOf(score);
        Paper paper = new Paper();
        PojoUtils.copyProperties(templateUpdateDto,paper);
        paper.setScore(paperScore);
        paper.setUpdatedTime(new Date());
        //更新模板和总分
        Integer updateIsSuccess = mainTainTemplateDao.updatePaperScore(paper);
        if (updateIsSuccess != 1) {
            throw new BusinessException(MAINTAIN_TEMPLATE_UPDATEINFO_ERROR);
        }

        //更新题目集合
        mainTainTemplateDao.deleteSubjects(templateUpdateDto.getPaperId());
        int count = mainTainTemplateDao.updateSubjectList(tPaperSubjects);

        if (count != tPaperSubjects.size()) {
            throw new BusinessException(MAINTAIN_TEMPLATE_UPDATESUBJECTLIST_ERROR);
        }
        //更新答案集合
        Integer updateAnswerCount = mainTainTemplateDao.updateAnswerList(paperSubjectAnswers);
        if (updateAnswerCount != paperSubjectAnswers.size()){
            throw new BusinessException(MAINTAIN_TEMPLATE_UPDATEANSWERLIST_ERROR);
        }

        //更新version
        version++;
        Paper tPaper = new Paper();
        tPaper.setPaperId(templateUpdateDto.getPaperId());
        tPaper.setVersion(version);
        if (mainTainTemplateDao.updateVersion(tPaper) != 1){
            throw new BusinessException(MAINTAIN_TEMPLATE_UPDATE_ERROR);
        }
    }



}
