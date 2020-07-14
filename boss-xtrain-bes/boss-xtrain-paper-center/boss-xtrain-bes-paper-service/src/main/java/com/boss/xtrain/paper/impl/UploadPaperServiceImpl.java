package com.boss.xtrain.paper.impl;

import com.boss.xtrain.common.core.exception.BusinessException;
import com.boss.xtrain.common.util.IdWorker;
import com.boss.xtrain.common.util.PojoUtils;
import com.boss.xtrain.papaer.annotation.TryCatch;
import com.boss.xtrain.paper.CreatePaperService;
import com.boss.xtrain.paper.UploadPaperService;
import com.boss.xtrain.paper.dao.UploadPaperDao;

import com.boss.xtrain.paper.dto.paperdetail.PaperQueryDTO;
import com.boss.xtrain.paper.dto.uploadexam.UploadPaperDTO;
import com.boss.xtrain.paper.entity.Paper;
import com.boss.xtrain.paper.entity.PaperSubject;
import com.boss.xtrain.paper.entity.PaperSubjectAnswer;
import com.boss.xtrain.paper.entity.SubjectAnswer;
import com.boss.xtrain.paper.vo.uploadexam.PaperVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.boss.xtrain.common.core.exception.error.BusinessError.*;
@Service
public class UploadPaperServiceImpl implements UploadPaperService {

    @Autowired
    private UploadPaperDao uploadPaperDao;
    @Autowired
    private CreatePaperService createPaperService;

    /**
     * @param uploadPaperDto
     * @methodsName: uploadPaper
     * @description: 上传试卷生成模板
     * @param: uploadPaperDto
     * @return: void
     * @throws:
     */
    @Override
    public void uploadPaper(UploadPaperDTO uploadPaperDto) {
        if (uploadPaperDao.templateNameIsExist(uploadPaperDto)){
            throw new BusinessException(UPLOAD_NAMEEXIST_ERROR);
        }
        //生成ID类
        IdWorker idWorker = new IdWorker();
        //试卷
        Paper tPaper = uploadPaperDao.queryPaperById(uploadPaperDto.getPaperId());
        //模板
        Paper template = new Paper();
        PojoUtils.copyProperties(tPaper,template);
        template.setTemplate(true);
        template.setPaperId(idWorker.nextId());
        template.setStatus(false);
        template.setCombExamMa(tPaper.getCombExamMa());
        template.setScore(tPaper.getScore());
        template.setCombExamTim(tPaper.getCombExamTim());
        template.setDownloadTimes(0);
        template.setDifficuty(tPaper.getDifficuty());
        template.setDiscript(tPaper.getDiscript());
        template.setDownloadTimes(0);
        template.setPublishTimes(0);
        Integer uploadPaperCount = uploadPaperDao.uploadPaper(template);
        //将试卷题目及答案复制到新的模板上
        List<SubjectAnswer> subjectAnswers = uploadPaperDao.querySubjectAnswerList(uploadPaperDto.getPaperId());
        //所有答案集合
        List<PaperSubjectAnswer> answerList = new ArrayList<>();
        if (!subjectAnswers.isEmpty()){
            for (SubjectAnswer subjectAnswer : subjectAnswers) {
                List<PaperSubjectAnswer> answers = subjectAnswer.getAnswers();
                subjectAnswer.setPaperSubjectId(idWorker.nextId());
                subjectAnswer.setPaperId(template.getPaperId());
                subjectAnswer.setUpdatedBy(uploadPaperDto.getUpdatedBy());
                subjectAnswer.setUpdatedTime(new Date());
                subjectAnswer.setVersion(1L);
                if (answers != null){
                    for (PaperSubjectAnswer answer : answers) {
                        answer.setSubjectId(subjectAnswer.getPaperSubjectId());
                        answer.setPaperSubjectAnswerId(idWorker.nextId());
                        answerList.add(answer);
                    }
                }
            }
            //判断试卷Insert是否成功
            List<PaperSubject> paperSubjects = PojoUtils.copyListProperties(subjectAnswers, PaperSubject::new);
            Integer insertSubejectCount = uploadPaperDao.insertSubjectList(paperSubjects);
            Integer insertAnswerCount = uploadPaperDao.insertAnswerList(answerList);
            if (uploadPaperCount==0 || insertSubejectCount != subjectAnswers.size() || insertAnswerCount != answerList.size()){
                throw new BusinessException(UPLOAD_PAPER_ERROR);
            }
        }

        //更新试卷上传状态（未上传->已上传）,更新试卷上传次数
        Integer updatePaperStatusCount = uploadPaperDao.updatePaperStatus(tPaper);
        if (updatePaperStatusCount ==0){
            throw new BusinessException(UPLOAD_UPDATE_PAPERSTATUS_ERROR);
        }


    }

    /**
     * @param paperQueryDto
     * @methodsName: getPaper
     * @description: 获取试卷集合
     * @param: paperQueryDto
     * @return: java.util.List<com.boss.bes.paper.pojo.vo.uploadexam.PaperVO>
     * @throws:
     */
    @Override
    @TryCatch
    public List<PaperVO> getPaper(PaperQueryDTO paperQueryDto) {
        return uploadPaperDao.queryPaperList(paperQueryDto);

    }

}
