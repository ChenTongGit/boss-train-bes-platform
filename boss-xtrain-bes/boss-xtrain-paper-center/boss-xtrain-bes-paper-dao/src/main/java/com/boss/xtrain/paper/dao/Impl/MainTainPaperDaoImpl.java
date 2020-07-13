package com.boss.xtrain.paper.dao.Impl;

import com.boss.xtrain.paper.dao.MainTainPaperDao;
import com.boss.xtrain.paper.dto.paperdetail.PaperQueryDTO;
import com.boss.xtrain.paper.entity.Paper;
import com.boss.xtrain.paper.entity.PaperSubject;
import com.boss.xtrain.paper.entity.PaperSubjectAnswer;
import com.boss.xtrain.paper.vo.paperdetail.PaperVO;
import com.boss.xtrain.paper.vo.papermanage.SubjectVO;
import com.boss.xtrain.common.util.PojoUtils;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
@Component
public class MainTainPaperDaoImpl extends PaperBaseDaoImpl implements MainTainPaperDao {
    /**
     * @param paperId
     * @methodsName: deletePaperById
     * @description: 删除试卷
     * @param: paperId
     * @return: java.lang.Integer
     * @throws:
     */
    @Override
    public Integer deletePaperById(Long paperId) {

        Example example = new Example(Paper.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo(PAPER_ID,paperId)
                .andEqualTo(TEMPLATE,PAPER_SIGN);
        return paperMapper.deleteByExample(example);

    }

    /**
     * @param papers
     * @methodsName: deletePaperByList
     * @description: 根据试卷id查询题目集合
     * @param: papers
     * @return: java.lang.Integer
     * @throws:
     */
    @Override
    public void deletePaperByList(List<Paper> papers) {
        for (Paper paper:
             papers) {
            paperMapper.deleteByPrimaryKey(paper.getPaperId());
        }
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
     * @param tPaperSubjects
     * @methodsName: updateSubjectList
     * @description: 根据试卷id查询题目集合
     * @param: tPaperSubjects
     * @return: java.lang.Integer
     * @throws:
     */
    @Override
    public void updateSubjectList(List<PaperSubject> tPaperSubjects) {
        paperSubjectMapper.insertList(tPaperSubjects);
    }

    /**
     * @param paperQueryDTO
     * @methodsName: queryPaperList
     * @description: 查询试卷查询试卷
     * @param: paperQueryDTO
     * @return: java.util.List<com.boss.bes.paper.pojo.vo.papermanage.PaperVO>
     * @throws:
     */
    @Override
    public List<PaperVO> queryPaperList(PaperQueryDTO paperQueryDTO) {
        return PojoUtils.copyListProperties(getPaperList(paperQueryDTO),PaperVO::new);
    }

    /**
     * @param paperId
     * @methodsName: queryPaperVersion
     * @description: 查询试卷version
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
     * @description: 更新version
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
     * @description: 更新试卷总分
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
     * @description: 插入试卷题目集合
     * @param: paperSubjectAnswers
     * @return: java.lang.Integer
     * @throws:
     */
    @Override
    public Integer updateAnswerList(List<PaperSubjectAnswer> paperSubjectAnswers) {
        return paperSubjectAnswerMapper.insertList(paperSubjectAnswers);
    }
}
