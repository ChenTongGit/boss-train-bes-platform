package com.boss.xtrain.paper.dao.Impl;

import com.boss.xtrain.paper.dao.UploadPaperDao;
import com.boss.xtrain.paper.dto.paperdetail.PaperQueryDTO;
import com.boss.xtrain.paper.dto.uploadexam.UploadPaperDTO;
import com.boss.xtrain.paper.entity.Paper;
import com.boss.xtrain.paper.entity.PaperSubject;
import com.boss.xtrain.paper.entity.PaperSubjectAnswer;
import com.boss.xtrain.paper.entity.SubjectAnswer;
import com.boss.xtrain.paper.vo.uploadexam.PaperVO;
import com.boss.xtrain.common.util.PojoUtils;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
@Component
public class UploadPaperDaoImpl extends PaperBaseDaoImpl implements UploadPaperDao {
    /**
     * @param tPaper
     * @methodsName: uploadPaper
     * @description: 上传试卷
     * @param: tPaper
     * @return: java.lang.Integer
     * @throws:
     */
    @Override
    public Integer uploadPaper(Paper tPaper) {
        return paperMapper.insertSelective(tPaper);
    }

    /**
     * @param paperId
     * @methodsName: queryPaperById
     * @description: 根据ID查询试卷
     * @param: paperId
     * @return: com.boss.bes.paper.entity.Paper
     * @throws:
     */
    @Override
    public Paper queryPaperById(Long paperId) {
        return paperMapper.selectByPrimaryKey(paperId);
    }

    /**
     * @param paperQueryDto
     * @methodsName: queryPaperList
     * @description: 获取试卷集合
     * @param: paperQueryDto
     * @return: java.util.List<com.boss.bes.paper.pojo.vo.uploadexam.PaperVO>
     * @throws:
     */
    @Override
    public List<PaperVO> queryPaperList(PaperQueryDTO paperQueryDto) {
        return PojoUtils.copyListProperties(getPaperList(paperQueryDto),PaperVO::new);
    }

    /**
     * @param paper
     * @methodsName: updatePaperStatus
     * @description: 更新试卷状态
     * @param: paper
     * @return: java.lang.Integer
     * @throws:
     */
    @Override
    public Integer updatePaperStatus(Paper paper) {
        final Boolean PAPER_STATUS = true;
        Integer publishTimes = paper.getPublishTimes();
        if (publishTimes == null){
            publishTimes = 0;
        }
        paper.setPublishTimes(publishTimes+1);
        paper.setStatus(PAPER_STATUS);
        return paperMapper.updateByPrimaryKeySelective(paper);

    }

    /**
     * @param list
     * @methodsName: insertSubjectList
     * @description: 插入题目集合
     * @param: list
     * @return: java.lang.Integer
     * @throws:
     */
    @Override
    public Integer insertSubjectList(List<PaperSubject> list) {
        int count = 0;
        for (PaperSubject paperSubject:
             list) {
            count+=paperSubjectMapper.insert(paperSubject);
        }
        return count;
    }

    /**
     * @param list
     * @methodsName: insertAnswerList
     * @description: 插入答案集合
     * @param: list
     * @return: java.lang.Integer
     * @throws:
     */
    @Override
    public Integer insertAnswerList(List<PaperSubjectAnswer> list) {
        int count = 0;
        for (PaperSubjectAnswer paperSubjectAnswer:
             list) {
            count += paperSubjectAnswerMapper.insert(paperSubjectAnswer);
        }
        return count;
    }

    /**
     * @param uploadPaperDto
     * @methodsName: templateNameIsExist
     * @description: 判断试卷名是否存在
     * @param: uploadPaperDto
     * @return: boolean
     * @throws:
     */
    @Override
    public boolean templateNameIsExist(UploadPaperDTO uploadPaperDto) {
        Example example = new Example(Paper.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("paperName",uploadPaperDto.getPaperName())
                .andEqualTo("orgId",uploadPaperDto.getOrganizationId())
                .andEqualTo(TEMPLATE,TEMPLATE_SIGN);
        List<Paper> paperList = paperMapper.selectByExample(example);
        return !paperList.isEmpty();

    }

    @Override
    public List<SubjectAnswer> querySubjectAnswerList(Long paperId) {
        Example subjectExample = new Example(PaperSubject.class);
        Example.Criteria criteria1 = subjectExample.createCriteria();
        criteria1.andEqualTo(PAPER_ID,paperId);
        List<PaperSubject> paperSubjectList = paperSubjectMapper.selectByExample(subjectExample);
        List<SubjectAnswer> result = PojoUtils.copyListProperties(paperSubjectList,SubjectAnswer::new);
        for (SubjectAnswer paperSubject:
                result) {
            Example ansExample = new Example(PaperSubjectAnswer.class);
            Example.Criteria criteria2 = ansExample.createCriteria();
            criteria2.andEqualTo("subjectId",paperSubject.getPaperSubjectId());
            List<PaperSubjectAnswer> paperSubjectAnswerList = paperSubjectAnswerMapper.selectByExample(ansExample);
            paperSubject.setAnswers(paperSubjectAnswerList);
        }
        return result;
    }
}
