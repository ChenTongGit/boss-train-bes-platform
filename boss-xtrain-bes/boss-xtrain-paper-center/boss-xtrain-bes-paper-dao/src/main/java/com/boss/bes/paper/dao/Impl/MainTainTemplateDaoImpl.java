package com.boss.bes.paper.dao.Impl;

import com.boss.bes.paper.dao.MainTainTemplateDao;
import com.boss.bes.paper.dto.templatecomb.TemplateQueryDTO;
import com.boss.bes.paper.entity.Paper;
import com.boss.bes.paper.entity.PaperSubject;
import com.boss.bes.paper.entity.PaperSubjectAnswer;
import com.boss.bes.paper.vo.papermanage.SubjectVO;
import com.boss.bes.paper.vo.templatemanage.TemplateVO;
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
    public List<TemplateVO> queryTemplateList(TemplateQueryDTO templateQueryDTO) {
        return PojoUtils.copyListProperties(getTemplateList(templateQueryDTO),TemplateVO::new);
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
        return getSubjectList(paperId);
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
                .andEqualTo(TEMPLATE,TEMPLATE_SIGN);
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
    public void deleteTemplateByList(List<Paper> list) {
        for (Paper paper:
             list) {
            paperMapper.deleteByPrimaryKey(paper.getPaperId());
        }
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
    public void updateSubjectList(List<PaperSubject> tPaperSubjects) {
        for (PaperSubject paperSubject:
             tPaperSubjects) {
            paperSubjectMapper.updateByPrimaryKey(paperSubject);
        }
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
    public void updateAnswerList(List<PaperSubjectAnswer> paperSubjectAnswers) {
        paperSubjectAnswerMapper.insertList(paperSubjectAnswers);
    }
}
