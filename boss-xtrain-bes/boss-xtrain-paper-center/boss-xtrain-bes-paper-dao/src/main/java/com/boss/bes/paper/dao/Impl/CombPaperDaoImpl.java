package com.boss.bes.paper.dao.Impl;

import com.boss.bes.paper.dao.CombPaperDao;
import com.boss.bes.paper.dto.paperdetail.PaperQueryDTO;
import com.boss.bes.paper.dto.templatecomb.TemplateQueryDTO;
import com.boss.bes.paper.entity.Paper;
import com.boss.bes.paper.entity.PaperSubject;
import com.boss.bes.paper.entity.PaperSubjectAnswer;
import com.boss.bes.paper.vo.paperdetail.PaperVO;
import com.boss.bes.paper.vo.templatecomb.TemplateVO;
import com.boss.xtrain.common.util.PojoUtils;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.entity.Example;


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
        return paperSubjectMapper.insertList(list);
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
        return paperSubjectAnswerMapper.insertList(list);
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
