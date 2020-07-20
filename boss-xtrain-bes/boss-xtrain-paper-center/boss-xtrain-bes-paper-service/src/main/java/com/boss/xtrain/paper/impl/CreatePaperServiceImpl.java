package com.boss.xtrain.paper.impl;

import com.alibaba.fastjson.JSON;
import com.boss.xtrain.common.core.exception.BusinessException;
import com.boss.xtrain.common.util.IdWorker;
import com.boss.xtrain.common.util.PojoUtils;
import com.boss.xtrain.papaer.annotation.TryCatch;
import com.boss.xtrain.papaer.utils.BasicConverter;
import com.boss.xtrain.papaer.utils.BeanCopierUtil;
import com.boss.xtrain.papaer.utils.SomeParamChange;
import com.boss.xtrain.paper.BaseServiceApi;
import com.boss.xtrain.paper.CreatePaperService;
import com.boss.xtrain.paper.dao.CombPaperDao;
import com.boss.xtrain.paper.dto.fastcomb.*;
import com.boss.xtrain.paper.dto.paperdetail.PaperQueryDTO;
import com.boss.xtrain.paper.dto.standardcomb.StandardCombDTO;
import com.boss.xtrain.paper.dto.templatecomb.TemplateCombDTO;
import com.boss.xtrain.paper.dto.templatecomb.TemplateQueryDTO;
import com.boss.xtrain.paper.entity.Paper;
import com.boss.xtrain.paper.entity.PaperSubject;
import com.boss.xtrain.paper.entity.PaperSubjectAnswer;
import com.boss.xtrain.paper.entity.SubjectAnswer;
import com.boss.xtrain.paper.vo.fastcomb.AnswerVO;
import com.boss.xtrain.paper.vo.fastcomb.CombSubjectListVO;
import com.boss.xtrain.paper.vo.paperdetail.PaperVO;
import com.boss.xtrain.paper.vo.templatecomb.TemplateVO;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
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
    @Autowired
    private BaseServiceApi baseServiceApi;

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
        template.setDownloadTimes(template.getDownloadTimes()+1);
        Paper paper = new Paper();
        PojoUtils.copyProperties(templateCombDto,paper);
        paper.setPaperId(idWorker.nextId());
        paper.setTemplate(true);
        paper.setStatus(false);
        paper.setCombExamTim(new Date());
        paper.setScore(template.getScore());
        paper.setOrgId(template.getOrgId());
        paper.setCreatedTime(new Date());
        paper.setUpdatedTime(new Date());
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
     * @methodsName: addPaper
     * @description: 查询试卷名
     * @param: combConfigItemQueryDTO
     * @return: void
     * @throws:
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    @TryCatch

    public void addPaper(CombConfigItemQueryDTO combConfigItemQueryDTO) {
        if (combConfigItemQueryDTO.getCompanyId()==null){
            combConfigItemQueryDTO.setCompanyId(combConfigItemQueryDTO.getCompany());
        }
        if (combPaperDao.paperNameIsExist(combConfigItemQueryDTO.getPaperName(),combConfigItemQueryDTO.getCompanyId())){
            throw new BusinessException(COMBEXAM_PAPER_NAMEEXIST_ERROR);
        }
        //根据组卷配置id获取组卷后的试卷题目及答案
        CreatePaperDTO createPaperDTO = new CreatePaperDTO();
        createPaperDTO.setId(combConfigItemQueryDTO.getId());
        List<CombSubjectListVO> list = baseServiceApi.addPaper(createPaperDTO);
        CombExamCopyDTO combExamCopyDTO = new CombExamCopyDTO();
        PojoUtils.copyProperties(combConfigItemQueryDTO,combExamCopyDTO);
        createPaper(combExamCopyDTO, list);

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
    @Transactional(rollbackFor = Exception.class)
    @TryCatch

    public void addPaperByConfigItems(CombExamDTO combExamDTO) {
        if (combExamDTO.getCompanyId()==null){
            combExamDTO.setCompanyId(combExamDTO.getCompany());
        }
        if (combPaperDao.paperNameIsExist(combExamDTO.getPaperName(),combExamDTO.getCompanyId())){
            throw new BusinessException(COMBEXAM_PAPER_NAMEEXIST_ERROR);
        }
        //将组卷明细集合传给基础数据服务，获取组卷后的试题和答案
        ConfigItemListDTO configItemListDTO = new ConfigItemListDTO();
        configItemListDTO.setItemList(combExamDTO.getItemList());
        List<CombSubjectListVO> list = baseServiceApi.addPaperByConfigItems(configItemListDTO);
        CombExamCopyDTO combExamCopyDTO = new CombExamCopyDTO();
        BeanCopierUtil.copy(combExamDTO,combExamCopyDTO);
        createPaper(combExamCopyDTO, list);
    }

    /**
     * @param standardCombDTO
     * @methodsName: standardCombExam
     * @description: 标准组卷
     * @param: standardCombDTO
     * @return: void
     * @throws:
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    @TryCatch
    public void standardCombExam(StandardCombDTO standardCombDTO) {
        if (standardCombDTO.getCompanyId()==null){
            standardCombDTO.setCompanyId(standardCombDTO.getCompany());
        }
        if (combPaperDao.paperNameIsExist(standardCombDTO.getPaperName(),standardCombDTO.getCompanyId())){
            throw new BusinessException(COMBEXAM_PAPER_NAMEEXIST_ERROR);
        }
        //将组卷明细集合传给基础数据服务，获取组卷后的试题和答案
        List<CombSubjectListVO> list = baseServiceApi.standardCombExam(standardCombDTO);
        CombExamCopyDTO combExamCopyDTO = new CombExamCopyDTO();
        BeanCopierUtil.copy(standardCombDTO,combExamCopyDTO);
        createPaper(combExamCopyDTO,list);
    }
    @TryCatch
    boolean createPaper(CombExamCopyDTO combExamCopyDTO, List<CombSubjectListVO> list){
        Paper paper = new Paper();
        IdWorker idWorker = new IdWorker();
        Long paperId = idWorker.nextId();
        PojoUtils.copyProperties(combExamCopyDTO,paper);
        paper.setPaperId(paperId);
        paper.setCombExamTim(new Date());
        paper.setDownloadTimes(0);
        paper.setPublishTimes(0);
        paper.setOrgId(combExamCopyDTO.getOrganizationId());
        paper.setTemplate(true);
        BigDecimal score = new BigDecimal(0);
        for (CombSubjectListVO combSubjectListVO:
             list) {
            score=score.add(combSubjectListVO.getScore());
        }
        paper.setScore(score);
        List<PaperSubject> paperSubjectList = new ArrayList<>();
        List<PaperSubjectAnswer> paperSubjectAnswerList = new ArrayList<>();
        for (CombSubjectListVO combSubjectListVO:
            list) {
            PaperSubject paperSubject = new PaperSubject();
            System.out.println(combSubjectListVO.toString());
            BeanCopierUtil.copy(combSubjectListVO,paperSubject,new BasicConverter());
            paperSubject.setPaperId(paperId);
            Long subjectId = idWorker.nextId();
            paperSubject.setPaperSubjectId(subjectId);
            paperSubject.setSubject(combSubjectListVO.getSubjectName());
            paperSubject.setDifficult(SomeParamChange.difficultyChange(combSubjectListVO.getDifficuty()));
            paperSubject.setStatus(true);
            paperSubject.setOrgId(combExamCopyDTO.getOrganizationId());
            paperSubject.setCompanyId(combExamCopyDTO.getCompanyId());
            paperSubject.setCreatedTime(new Date());
            paperSubject.setUpdatedTime(new Date());
            paperSubject.setVersion(0L);
            List<AnswerVO> answerVOList = combSubjectListVO.getAnswerList();

            for (AnswerVO answerVO:
                 answerVOList) {
                PaperSubjectAnswer paperSubjectAnswer = new PaperSubjectAnswer();
                System.out.println(answerVO.toString());
                BeanCopierUtil.copy(answerVO,paperSubjectAnswer,new BasicConverter());
                paperSubjectAnswer.setSubjectId(subjectId);
                paperSubjectAnswer.setPaperSubjectAnswerId(idWorker.nextId());
                paperSubjectAnswer.setStatus(true);
                paperSubjectAnswer.setOrgId(combExamCopyDTO.getOrganizationId());
                paperSubjectAnswer.setCompanyId(combExamCopyDTO.getCompanyId());
                paperSubjectAnswer.setCreatedTime(new Date());
                paperSubjectAnswer.setUpdatedTime(new Date());
                paperSubjectAnswerList.add(paperSubjectAnswer);
            }
            paperSubjectList.add(paperSubject);
        }
        Integer insertPaperCount = combPaperDao.insertPaper(paper);
        Integer insertSubjectCount = combPaperDao.insertSubjectList(paperSubjectList);
        Integer insertAnswerCount = combPaperDao.insertAnswerList(paperSubjectAnswerList);
        //判断是否插入成功
        if (insertPaperCount == 1 && insertSubjectCount == paperSubjectList.size() && insertAnswerCount == paperSubjectAnswerList.size()) {
            return true;
        } else {
            throw new BusinessException(COMBEXAM_ERROR);
        }

        /*
    private BigDecimal score;
private Integer downloadTimes;

    private Integer publishTimes;
    private Long orgId;
    private Boolean template;
         */
    }

}
