package com.boss.xtrain.paper.impl;

import com.boss.xtrain.common.core.exception.BusinessException;
import com.boss.xtrain.common.util.IdWorker;
import com.boss.xtrain.common.util.PojoUtils;
import com.boss.xtrain.papaer.annotation.TryCatch;
import com.boss.xtrain.paper.CreatePaperService;
import com.boss.xtrain.paper.dao.CombPaperDao;
import com.boss.xtrain.paper.dto.fastcomb.CombConfigItemQueryDTO;
import com.boss.xtrain.paper.dto.fastcomb.CombExamDTO;
import com.boss.xtrain.paper.dto.paperdetail.PaperQueryDTO;
import com.boss.xtrain.paper.dto.standardcomb.StandardCombDTO;
import com.boss.xtrain.paper.dto.templatecomb.TemplateCombDTO;
import com.boss.xtrain.paper.dto.templatecomb.TemplateQueryDTO;
import com.boss.xtrain.paper.entity.Paper;
import com.boss.xtrain.paper.entity.PaperSubject;
import com.boss.xtrain.paper.entity.PaperSubjectAnswer;
import com.boss.xtrain.paper.entity.SubjectAnswer;
import com.boss.xtrain.paper.vo.paperdetail.PaperVO;
import com.boss.xtrain.paper.vo.templatecomb.TemplateVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.boss.xtrain.common.core.exception.error.BusinessError.*;

/**
 * 组卷service实现类
 * @author lenovo
 */
@Service
public class CreatePaperServiceImpl implements CreatePaperService {
    @Autowired
    private CombPaperDao combPaperDao;
    /**
     * @param paperQueryDto
     * @methodsName: queryPaperName
     * @description: 获取试卷集合
     * @param: paperQueryDto
     * @return: java.util.List<com.boss.bes.paper.pojo.vo.paperdetail.PaperVO>
     * @throws:
     */
    @TryCatch
    @Override
    public List<PaperVO> getPaper(PaperQueryDTO paperQueryDto) {
        return combPaperDao.queryPaperList(paperQueryDto);
    }

    /**
     * @param templateQueryDto
     * @methodsName: templateQueryDto
     * @description: 获取模板集合
     * @param: templateQueryDto
     * @return: java.util.List<com.boss.bes.paper.pojo.vo.templatecomb.TemplateVO>
     * @throws:
     */
    @TryCatch
    @Override
    public List<TemplateVO> getTempalte(TemplateQueryDTO templateQueryDto) {
        return combPaperDao.queryTemplateList(templateQueryDto);
    }

    /**
     * @param templateCombDto
     * @methodsName: downLoadTemplate
     * @description: 下载模板：生成试卷
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
        if (combPaperDao.paperNameIsExist(templateCombDto.getPaperName(),templateCombDto.getCompanyId())){
            throw new BusinessException(COMBEXAM_PAPER_NAMEEXIST_ERROR);
        }

        //查询下载的模板为基础生成新试卷
        IdWorker idWorker = new IdWorker();
        Paper template = combPaperDao.queryTemplateById(templateCombDto.getPaperId());
        Paper paper = new Paper();
        PojoUtils.copyProperties(templateCombDto,paper);
        paper.setPaperId(idWorker.nextId());
        paper.setTemplate(true);
        paper.setStatus(false);
        paper.setCombExamTim(new Date());
        paper.setScore(template.getScore());
        paper.setOrgId(template.getOrgId());
        Integer downLoadTemplateCount = combPaperDao.insertPaper(paper);

        //将模板题目及答案复制到新的试卷上
        List<SubjectAnswer> subjectAnswerList = combPaperDao.querySubjectAnswerList(templateCombDto.getPaperId());
        List<PaperSubjectAnswer> paperSubjectAnswerList = new ArrayList<>();
        if(null!=subjectAnswerList){
            for (SubjectAnswer subjectAnswer:
                    subjectAnswerList) {
                subjectAnswer.setPaperId(paper.getPaperId());
                subjectAnswer.setPaperSubjectId(idWorker.nextId());
                // PojoUtils.copyProperties(templateCombDto,subjectAnswer);
                List<PaperSubjectAnswer> tempAnswers = subjectAnswer.getAnswers();
                if(null!=tempAnswers){
                    for (PaperSubjectAnswer paperSubjectAnswer:
                            tempAnswers) {
                        paperSubjectAnswer.setPaperSubjectAnswerId(idWorker.nextId());
                        paperSubjectAnswer.setSubjectId(subjectAnswer.getPaperSubjectId());
                        // PojoUtils.copyProperties(templateCombDto,paperSubjectAnswer);
                        paperSubjectAnswerList.add(paperSubjectAnswer);
                    }
                }
            }
        }
        List<PaperSubject> paperSubjectList = PojoUtils.copyListProperties(subjectAnswerList,PaperSubject::new);
        System.out.println(111);
        if (downLoadTemplateCount == 0 || paperSubjectList.size() != combPaperDao.insertSubjectList(paperSubjectList) || paperSubjectAnswerList.size() != combPaperDao.insertAnswerList(paperSubjectAnswerList)) {
            throw new BusinessException(COMBEXAM_DOWNLOADTEMPLATE_ERROR);
        }

        //更新模板的下载次数
        Integer downLoadTemplateTimesCount = combPaperDao.downLoadTemplateTimes(template);
        //判断更新模板下载次数是否成功
        if (downLoadTemplateTimesCount == 0) {
        throw new BusinessException(COMBEXAM_UPDATE_PUBLISHTIMES_ERROR);
        }
}

    /**
     * @param combConfigItemQueryDTO
     * @author: zjh
     * @methodsName: addPaper
     * @description: 查询试卷名
     * @param: combConfigItemQueryDTO
     * @return: void
     * @throws:
     */
    @Override
    public void addPaper(CombConfigItemQueryDTO combConfigItemQueryDTO) {

    }

    /**
     * @param combExamDTO
     * @methodsName: addPaperByConfigItems
     * @description: 查询试卷名
     * @param: combExamDTO
     * @return: void
     * @throws:
     */
    @Override
    public void addPaperByConfigItems(CombExamDTO combExamDTO) {

    }

    /**
     * @param standardCombDTO
     * @methodsName: standardCombExam
     * @description: 标准组卷
     * @param: standardCombDTO
     * @return: void
     * @throws:
     */
    @Override
    public void standardCombExam(StandardCombDTO standardCombDTO) {

    }
}
