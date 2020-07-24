package com.boss.xtrain.paper.impl;

import com.boss.xtrain.common.util.IdWorker;
import com.boss.xtrain.common.util.PojoUtils;
import com.boss.xtrain.paper.annotation.TryCatch;
import com.boss.xtrain.paper.MainTainPaperService;
import com.boss.xtrain.paper.dao.MainTainPaperDao;
import com.boss.xtrain.paper.dto.paperdetail.PaperQueryDTO;
import com.boss.xtrain.paper.dto.papermanage.*;
import com.boss.xtrain.paper.dto.templatemanage.SubjectQueryDTO;
import com.boss.xtrain.paper.entity.Paper;
import com.boss.xtrain.paper.entity.PaperSubject;
import com.boss.xtrain.paper.entity.PaperSubjectAnswer;
import com.boss.xtrain.paper.vo.papermanage.PaperVO;
import com.boss.xtrain.paper.vo.papermanage.SubjectVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 维护试卷Service实现类
 */
@Service
public class MainTainPaperServiceImpl implements MainTainPaperService {
    Long version;
    @Autowired
    private MainTainPaperDao mainTainPaperDao;

    /**
     * @param deletePaperDto
     * @methodsName: deletePaperById
     * @description: 删除指定试卷
     * @param: deletePaperDto
     * @return: boolean
     * @throws:
     */
    @Override
    @TryCatch
    public boolean deletePaperById(DeletePaperDTO deletePaperDto) {
        //判断试卷是否被考试服务引用
        Long paperId = deletePaperDto.getPaperId();
        mainTainPaperDao.deletePaperById(paperId);
        return false;
    }

    /**
     * @param paperListDto
     * @methodsName: deletePaperByList
     * @description: 批量删除试卷
     * @param: paperListDto
     * @return: boolean
     * @throws:
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    @TryCatch
    public boolean deletePaperByList(PaperListDTO paperListDto) {
        for (DeletePaperDTO deletePaperDTO:
             paperListDto.getDeletePaperVos()) {
            mainTainPaperDao.deletePaperById(deletePaperDTO.getPaperId());
        }
        return false;

    }



    /**
     * @param subjectQueryDto
     * @methodsName: querySubject
     * @description: 查询指定试卷的题目集合
     * @param: subjectQueryDto
     * @return: java.util.List<com.boss.bes.paper.pojo.vo.papermanage.SubjectVO>
     * @throws:
     */
    @TryCatch
    @Override
    public List<SubjectVO> querySubject(SubjectQueryDTO subjectQueryDto) {
        //查询试卷题目前，查询试卷的version
        Long paperId = subjectQueryDto.getPaperId();

        return mainTainPaperDao.querySubjectList(subjectQueryDto.getPaperId());

    }

    /**
     * @param paperUpdateDto
     * @methodsName: updateSubejctList
     * @description: 批量编辑试卷的题目集合
     * @param: paperUpdateDto
     * @return: void
     * @throws:
     */
    @Override
    public boolean updateSubejctList(PaperUpdateDTO paperUpdateDto) {
        Paper paper = new Paper();
        PojoUtils.copyProperties(paperUpdateDto,paper);
        mainTainPaperDao.deleteSubjects(paper.getPaperId());
        IdWorker idWorker = new IdWorker();
        List<SubjectDTO> subjectDTOS = paperUpdateDto.getSubjectList();
        List<PaperSubject> paperSubjectList = new ArrayList<>();
        List<PaperSubjectAnswer> paperSubjectAnswerList = new ArrayList<>();
        for (SubjectDTO subjectDTO:
                subjectDTOS) {
            PaperSubject paperSubject = new PaperSubject();
            PojoUtils.copyProperties(subjectDTO,paperSubject);
            paperSubject.setPaperSubjectId(idWorker.nextId());
            paperSubject.setPaperId(paper.getPaperId());
            List<AnswerDTO> answerDTOS = subjectDTO.getAnswers();
            for (AnswerDTO answerDTO:
                    answerDTOS) {
                PaperSubjectAnswer paperSubjectAnswer = new PaperSubjectAnswer();
                PojoUtils.copyProperties(answerDTO,paperSubjectAnswer);
                paperSubjectAnswer.setPaperSubjectAnswerId(idWorker.nextId());
                paperSubjectAnswer.setSubjectId(paperSubject.getPaperSubjectId());
                paperSubjectAnswerList.add(paperSubjectAnswer);
            }
            paperSubjectList.add(paperSubject);
        }
        mainTainPaperDao.insertSubjectList(paperSubjectList);
        BigDecimal score = new BigDecimal(0);
        for (PaperSubject paperSubject:
                paperSubjectList) {
            score = score.add(paperSubject.getScore());
        }
        mainTainPaperDao.insertAnswerList(paperSubjectAnswerList);
        paper.setScore(score);
        mainTainPaperDao.updatePaper(paper);

        return true;
    }

    /**
     * @param paperQueryDto
     * @methodsName: getPaper
     * @description: 获取试卷集合
     * @param: paperQueryDto
     * @return: java.util.List<com.boss.bes.paper.pojo.vo.papermanage.PaperVO>
     * @throws:
     */
    @Override
    @TryCatch
    public List<PaperVO> getPaper(PaperQueryDTO paperQueryDto) {
        return PojoUtils.copyListProperties(mainTainPaperDao.queryPaperList(paperQueryDto),PaperVO::new);
    }

}
