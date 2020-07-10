package com.boss.bes.paper.dao.Impl;

import com.boss.bes.paper.dao.DownloadTemplateDao;
import com.boss.bes.paper.dto.downloadtemplate.TemplateCombDTO;
import com.boss.bes.paper.dto.templatecomb.TemplateQueryDTO;
import com.boss.bes.paper.entity.Paper;
import com.boss.bes.paper.entity.PaperSubject;
import com.boss.bes.paper.entity.PaperSubjectAnswer;
import com.boss.bes.paper.vo.downloadtemplate.TemplateVO;
import com.boss.xtrain.common.util.PojoUtils;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
@Component
public class DownloadTemplateDaoImpl extends PaperBaseDaoImpl implements DownloadTemplateDao {
    /**
     * @param templateQueryDTO
     * @methodsName: queryTemplateList
     * @description: 查询模板集合
     * @param: templateQueryDTO
     * @return: java.util.List<com.boss.bes.paper.pojo.vo.downloadtemplate.TemplateVO>
     * @throws:
     */
    @Override
    public List<TemplateVO> queryTemplateList(TemplateQueryDTO templateQueryDTO) {
        return PojoUtils.copyListProperties(getTemplateList(templateQueryDTO),TemplateVO::new);
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
     * @description: 新增模板
     * @param: tPaper
     * @return: java.lang.Integer
     * @throws:
     */
    @Override
    public Integer downLoadTemplate(Paper tPaper) {
        return paperMapper.insertSelective(tPaper);
    }

    /**
     * @param paper
     * @methodsName: downLoadTemplateTimes
     * @description: 更新模板的下载次数
     * @param: paper
     * @return: java.lang.Integer
     * @throws:
     */
    @Override
    public Integer downLoadTemplateTimes(Paper paper) {
        Integer downloadTimes = paper.getDownloadTimes();
        if (downloadTimes == null){
            downloadTimes = 0;
        }
        paper.setDownloadTimes(downloadTimes+1);
        return paperMapper.updateByPrimaryKeySelective(paper);

    }

    /**
     * @param list
     * @methodsName: insertSubjectList
     * @description: 插入试卷集合
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
     * @param templateCombDto
     * @methodsName: paperNameIsExist
     * @description: 查询模板名是否存在
     * @param: templateCombDto
     * @return: boolean
     * @throws:
     */
    @Override
    public boolean paperNameIsExist(TemplateCombDTO templateCombDto) {
        Example example = new Example(Paper.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("companyId",templateCombDto.getCompanyId())
                .andEqualTo("paperName",templateCombDto.getPaperName())
                .andEqualTo(TEMPLATE,PAPER_SIGN);
        List<Paper> paperList = paperMapper.selectByExample(example);
        return !paperList.isEmpty();

    }
}
