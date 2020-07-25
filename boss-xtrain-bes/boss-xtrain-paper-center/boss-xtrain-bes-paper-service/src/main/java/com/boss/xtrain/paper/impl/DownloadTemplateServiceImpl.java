package com.boss.xtrain.paper.impl;

import com.boss.xtrain.common.core.exception.BusinessException;
import com.boss.xtrain.common.util.IdWorker;
import com.boss.xtrain.common.util.PojoUtils;
import com.boss.xtrain.paper.annotation.TryCatch;
import com.boss.xtrain.paper.DownloadTemplateService;
import com.boss.xtrain.paper.dao.DownloadTemplateDao;
import com.boss.xtrain.paper.dto.downloadtemplate.TemplateCombDTO;
import com.boss.xtrain.paper.dto.templatecomb.TemplateQueryDTO;
import com.boss.xtrain.paper.entity.Paper;
import com.boss.xtrain.paper.entity.PaperSubject;
import com.boss.xtrain.paper.entity.PaperSubjectAnswer;
import com.boss.xtrain.paper.entity.SubjectAnswer;
import com.boss.xtrain.paper.vo.downloadtemplate.TemplateVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.boss.xtrain.common.core.exception.error.BusinessError.*;

@Service
public class DownloadTemplateServiceImpl implements DownloadTemplateService {
    @Autowired
    private DownloadTemplateDao downloadTemplateDao;

    /**
     * @param templateQueryDto
     * @author: zjh
     * @methodsName: getTempalte
     * @description: 获取模板
     * @param: templateQueryDto
     * @return: java.util.List<com.boss.bes.paper.pojo.vo.downloadtemplate.TemplateVO>
     * @throws:
     */
    @Override
    public List<TemplateVO> getTempalte(TemplateQueryDTO templateQueryDto) {
        return downloadTemplateDao.queryTemplateList(templateQueryDto);
    }

    /**
     * @param templateCombDto
     * @methodsName: downLoadTemplate
     * @description: 下载模板
     * @param: templateCombDto
     * @return: void
     * @throws:
     */
    @TryCatch
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void downLoadTemplate(TemplateCombDTO templateCombDto) {
        if (templateCombDto.getCompanyId()==null || templateCombDto.getCompanyId().toString().equals("")){
            templateCombDto.setCompanyId(templateCombDto.getCompany());
        }
        if (downloadTemplateDao.paperNameIsExist(templateCombDto)){
            throw new BusinessException(DOWNLOAD_NAMEEXIST_ERROR);
        }
        IdWorker idWorker = new IdWorker();
        Paper template = downloadTemplateDao.queryTemplateById(templateCombDto.getPaperId());
        Paper paper = new Paper();
        paper.setTemplate(true);
        paper.setPaperId(idWorker.nextId());
        paper.setScore(template.getScore());
        paper.setCombExamMa(template.getCombExamMa());
        paper.setStatus(false);
        paper.setCombExamTim(template.getCombExamTim());
        Integer downLoadTemplateCount = downloadTemplateDao.downLoadTemplate(paper);

        //将模板题目及答案复制到新的试卷上
        List<SubjectAnswer> subjectAnswers = downloadTemplateDao.querySubjectAnswerList(templateCombDto.getPaperId());
        //所有答案集合
        List<PaperSubjectAnswer> answerList = new ArrayList<>();
        if (!subjectAnswers.isEmpty()) {
            for (SubjectAnswer subjectAnswer : subjectAnswers) {
                List<PaperSubjectAnswer> answers = subjectAnswer.getAnswers();
                subjectAnswer.setPaperSubjectId(idWorker.nextId());
                subjectAnswer.setPaperId(paper.getPaperId());
                subjectAnswer.setUpdatedBy(templateCombDto.getUpdatedBy());
                subjectAnswer.setUpdatedTime(new Date());
                subjectAnswer.setVersion(1L);
                if (answers != null) {
                    for (PaperSubjectAnswer paperSubjectAnswer : answers) {
                        paperSubjectAnswer.setSubjectId(subjectAnswer.getPaperSubjectId());
                        paperSubjectAnswer.setPaperSubjectAnswerId(idWorker.nextId());
                        answerList.add(paperSubjectAnswer);
                    }
                }
            }
            List<PaperSubject> paperSubjects = PojoUtils.copyListProperties(subjectAnswers,PaperSubject::new);
            Integer insertSubjectCount = downloadTemplateDao.insertSubjectList(paperSubjects);
            Integer insertAnswerCount = downloadTemplateDao.insertAnswerList(answerList);
            if (downLoadTemplateCount==0 || subjectAnswers.size() != insertSubjectCount || answerList.size() != insertAnswerCount){
                throw new BusinessException(DOWNLOAD_TEMPLATE_ERROR);
            }
        }
        //更新模板下载次数
        Integer downLoadTemplateTimesCount = downloadTemplateDao.downLoadTemplateTimes(template);
        //判断模板下载次数update是否成功
        if (downLoadTemplateTimesCount==0){
            throw new BusinessException(DOWNLOAD_PUBLISHTIMES_ERROR);
        }

    }
}
