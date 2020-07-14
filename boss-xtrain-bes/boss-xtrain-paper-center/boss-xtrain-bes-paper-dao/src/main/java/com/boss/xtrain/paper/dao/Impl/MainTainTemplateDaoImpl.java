package com.boss.xtrain.paper.dao.Impl;

import com.boss.xtrain.paper.dao.MainTainTemplateDao;
import com.boss.xtrain.paper.dto.templatecomb.TemplateQueryDTO;
import com.boss.xtrain.paper.entity.Paper;
import com.boss.xtrain.paper.entity.PaperSubject;
import com.boss.xtrain.paper.entity.PaperSubjectAnswer;

import com.boss.xtrain.paper.vo.templatemanage.AnswerVO;
import com.boss.xtrain.paper.vo.templatemanage.SubjectVO;
import com.boss.xtrain.paper.vo.templatemanage.TemplateVO;
import com.boss.xtrain.common.util.PojoUtils;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;
@Component
public class MainTainTemplateDaoImpl extends PaperBaseDaoImpl implements MainTainTemplateDao {

    /**
     * @param templateQueryDTO
     * @methodsName: queryTemplateList
     * @description: 获取模板集合
     * @param: templateQueryDTO
     * @return: java.util.List<com.boss.bes.paper.pojo.vo.templatemanage.TemplateVO>
     * @throws:
     */
    @Override
    public List<TemplateVO> queryTemplateList(com.boss.xtrain.paper.dto.templatemanage.TemplateQueryDTO templateQueryDTO) {
        return null;
    }

    /**
     * @param paperId
     * @methodsName: querySubjectList
     * @description: 获取题目集合
     * @param: paperId
     * @return: java.util.List<com.boss.bes.paper.pojo.vo.papermanage.SubjectVO>
     * @throws:
     */
    @Override
    public List<SubjectVO> querySubjectList(Long paperId) {

        Example paperSubjectExample = new Example(PaperSubject.class);
        Example.Criteria criteriaPs = paperSubjectExample.createCriteria();
        criteriaPs.andEqualTo(PAPER_ID,paperId);
        List<PaperSubject> paperSubjects  =  paperSubjectMapper.selectByExample(paperSubjectExample);
        List<SubjectVO> subjectVOList = PojoUtils.copyListProperties(paperSubjects, SubjectVO::new);
        for (SubjectVO subjectVO :
                subjectVOList) {
            Example paperSubjectAnsExample = new Example(PaperSubjectAnswer.class);
            Example.Criteria criteriaPsa = paperSubjectAnsExample.createCriteria();
            criteriaPsa.andEqualTo("subjectId",subjectVO.getPaperSubjectId());
            List<PaperSubjectAnswer> paperSubjectAnswers = paperSubjectAnswerMapper.selectByExample(paperSubjectAnsExample);
            List<AnswerVO> answerVOList = PojoUtils.copyListProperties(paperSubjectAnswers,AnswerVO::new);
            subjectVO.setAnswers(answerVOList);
        }

        return subjectVOList;
    }

    /**
     * @param paperId
     * @methodsName: deleteTemplateById
     * @description: 删除模板
     * @param: paperId
     * @return: java.lang.Integer
     * @throws:
     */
    @Override
    public Integer deleteTemplateById(Long paperId) {
        Example example = new Example(Paper.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo(PAPER_ID,paperId)
                .andEqualTo(TEMPLATE,0);
        return paperMapper.deleteByExample(example);


    }

    /**
     * @param list
     * @methodsName: deleteTemplateByList
     * @description: 批量删除模板
     * @param: list
     * @return: java.lang.Integer
     * @throws:
     */
    @Override
    public Integer deleteTemplateByList(List<Paper> list) {
        int count = 0;
        for (Paper paper:
             list) {
            count +=deleteTemplateById(paper.getPaperId());
        }
        return count;
    }

    /**
     * @param tPaperSubjects
     * @methodsName: updateSubjectList
     * @description: 更新题目集合
     * @param: tPaperSubjects
     * @return: java.lang.Integer
     * @throws:
     */
    @Override
    public Integer updateSubjectList(List<PaperSubject> tPaperSubjects) {
        int count = 0;
        for (PaperSubject paperSubject:
             tPaperSubjects) {
            count+=paperSubjectMapper.updateByPrimaryKey(paperSubject);
        }
        return count;
    }

    /**
     * @param paperId
     * @methodsName: queryPaperVersion
     * @description: 获取试卷version
     * @param: paperId
     * @return: java.lang.Long
     * @throws:
     */
    @Override
    public Long queryPaperVersion(Long paperId) {
        Example example = new Example(Paper.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo(PAPER_ID,paperId);
        Paper tPaper = paperMapper.selectOneByExample(example);
        return tPaper.getVersion();
    }

    /**
     * @param tPaper
     * @methodsName: updateVersion
     * @description: 更新试卷version
     * @param: tPaper
     * @return: java.lang.Integer
     * @throws:
     */
    @Override
    public Integer updateVersion(Paper tPaper) {
        Example example = new Example(Paper.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("version",tPaper.getVersion()-1)
                .andEqualTo(PAPER_ID,tPaper.getPaperId());
        return paperMapper.updateByExampleSelective(tPaper,example);

    }

    /**
     * @param paper
     * @methodsName: updatePaperScore
     * @description: 更新模板总分
     * @param: paper
     * @return: java.lang.Integer
     * @throws:
     */
    @Override
    public Integer updatePaperScore(Paper paper) {
        Example example = new Example(Paper.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo(PAPER_ID,paper.getPaperId());
        return paperMapper.updateByExampleSelective(paper,example);
    }



    /**
     * @param tPaperSubjectAnswerList
     * @methodsName: insertAnswerList
     * @description: 添加答案
     * @param: tPaperSubjectAnswerList
     * @return: java.lang.Integer
     * @throws:
     */
    @Override
    public void insertAnswerList(List<PaperSubjectAnswer> tPaperSubjectAnswerList) {


        for (PaperSubjectAnswer paperSubjectAnswer : tPaperSubjectAnswerList) {
            paperSubjectAnswer.setCreatedTime(new Date());
            paperSubjectAnswer.setUpdatedTime(new Date());
            paperSubjectAnswerMapper.insert(paperSubjectAnswer);

        }


    }

    /**
     * @param paperId
     * @methodsName: deleteSubjects
     * @description: 删除所有题目
     * @param: paperId
     * @return: java.lang.Integer
     * @throws:
     */
    @Override
    public Integer deleteSubjects(Long paperId) {
        Example example = new Example(PaperSubject.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo(PAPER_ID,paperId);
        return paperSubjectMapper.deleteByExample(example);

    }

    /**
     * @param paperSubjectAnswers
     * @methodsName: updateAnswerList
     * @description: 插入答案集合
     * @param: paperSubjectAnswers
     * @return: java.lang.Integer
     * @throws:
     */
    @Override
    public Integer updateAnswerList(List<PaperSubjectAnswer> paperSubjectAnswers) {
        int count  = 0;
        for (PaperSubjectAnswer paperSubjectAnswer:
             paperSubjectAnswers) {
            count += paperSubjectAnswerMapper.insert(paperSubjectAnswer);
        }
        // paperSubjectAnswerMapper.insertList(paperSubjectAnswers);
        return count;
    }
}
