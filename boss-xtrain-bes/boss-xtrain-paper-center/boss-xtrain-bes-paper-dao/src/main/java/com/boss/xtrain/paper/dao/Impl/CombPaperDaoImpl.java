package com.boss.xtrain.paper.dao.Impl;

import com.boss.xtrain.paper.dao.CombPaperDao;
import com.boss.xtrain.paper.dto.paperdetail.PaperQueryDTO;
import com.boss.xtrain.paper.dto.templatecomb.TemplateQueryDTO;
import com.boss.xtrain.paper.entity.Paper;
import com.boss.xtrain.paper.entity.PaperSubject;
import com.boss.xtrain.paper.entity.PaperSubjectAnswer;
import com.boss.xtrain.paper.entity.SubjectAnswer;
import com.boss.xtrain.paper.vo.paperdetail.PaperVO;
import com.boss.xtrain.paper.vo.templatecomb.TemplateVO;
import com.boss.xtrain.common.util.PojoUtils;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.entity.Example;


import java.util.ArrayList;
import java.util.List;

/**上传试卷DAO实现类
 * @author lenovo
 */
@Component
public class CombPaperDaoImpl extends PaperBaseDaoImpl implements CombPaperDao {
    /**
     * @param paperQueryDTO
     * @methodsName: queryPaperList
     * @description: 获取试卷集合
     * @param: paperQueryDTO
     * @return: java.util.List<com.boss.bes.paper.pojo.vo.paperdetail.PaperVO>
     * @throws:
     */
    @Override
    public List<PaperVO> queryPaperList(PaperQueryDTO paperQueryDTO) {
        List<Paper> paperList = getPaperList(paperQueryDTO);
        List<PaperVO> paperVOList = PojoUtils.copyListProperties(paperList,PaperVO::new);
        return paperVOList;
    }

    /**
     * @param templateQueryDto
     * @methodsName: queryTemplateList
     * @description: 查询模板集合
     * @param: templateQueryDto
     * @return: java.util.List<com.boss.bes.paper.pojo.vo.templatecomb.TemplateVO>
     * @throws:
     */
    @Override
    public List<TemplateVO> queryTemplateList(TemplateQueryDTO templateQueryDto) {
        List<Paper> paperList = getTemplateList(templateQueryDto);
        List<TemplateVO> templateVOList = PojoUtils.copyListProperties(paperList,TemplateVO::new);

        return templateVOList;
    }

    /**
     * @param templateId
     * @methodsName: queryTemplateById
     * @description: 根据id查询模板
     * @param: templateId
     * @return: com.boss.bes.paper.entity.Paper
     * @throws:
     */
    @Override
    public Paper queryTemplateById(Long templateId) {
        return paperMapper.selectByPrimaryKey(templateId);
    }

    /**
     * @param tPaper
     * @methodsName: downLoadTemplate
     * @description: 下载模板：生成试卷
     * @param: tPaper
     * @return: java.lang.Integer
     * @throws:
     */
    @Override
    public Integer downLoadTemplate(Paper tPaper) {
        return paperMapper.insert(tPaper);
    }

    /**
     * @param paper
     * @methodsName: downLoadTemplateTimes
     * @description: 更新模板下载次数
     * @param: paper
     * @return: java.lang.Integer
     * @throws:
     */
    @Override
    public Integer downLoadTemplateTimes(Paper paper) {
        Integer downloadTimes = paper.getDownloadTimes();
        if (downloadTimes == null) {
            downloadTimes = 0;
        }
        paper.setDownloadTimes(downloadTimes + 1);

        return paperMapper.updateByPrimaryKeySelective(paper);

    }

    /**
     * @param paperId
     * @methodsName: querySubjectById
     * @description: 根据模板ID查询其题目集合
     * @param: paperId
     * @return: java.util.List<com.boss.bes.paper.entity.PaperSubject>
     * @throws:
     */
    @Override
    public List<PaperSubject> querySubjectById(Long paperId) {
        Example example = new Example(PaperSubject.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo(PAPER_ID, paperId);
        return paperSubjectMapper.selectByExample(example);

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
            count += paperSubjectMapper.insert(paperSubject);
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
     * @param paper
     * @methodsName: insertPaper
     * @description: 插入一张试卷
     * @param: paper
     * @return: java.lang.Integer
     * @throws:
     */
    @Override
    public Integer insertPaper(Paper paper) {
        return paperMapper.insert(paper);
    }

    /**
     * @methodsName: querySubjectAnswerList
     * @description: 获取试卷的题目和答案集合
     * @param: paperId
     * @return: java.util.List<com.boss.bes.paper.entity.SubjectAnswer>
     * @throws:
     */
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

    /**
     * @param paperName
     * @param companyId
     * @methodsName: paperNameIsExist
     * @description: 判断试卷名是否存在
     * @param: paperName, companyId
     * @return: boolean
     * @throws:
     */

    @Override
    public boolean paperNameIsExist(String paperName, Long companyId) {
        Example example = new Example(Paper.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("paperName",paperName)
                .andEqualTo(TEMPLATE,PAPER_SIGN)
                .andEqualTo("companyId",companyId);
        List<Paper> paperList = paperMapper.selectByExample(example);
        return !paperList.isEmpty();

    }
}
