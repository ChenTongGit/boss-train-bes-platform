package com.boss.bes.paper.dao.Impl;

import com.boss.bes.paper.dto.paperdetail.PaperQueryDTO;
import com.boss.bes.paper.dto.templatecomb.TemplateQueryDTO;
import com.boss.bes.paper.entity.Paper;
import com.boss.bes.paper.entity.PaperSubject;
import com.boss.bes.paper.entity.PaperSubjectAnswer;
import com.boss.bes.paper.mapper.PaperMapper;
import com.boss.bes.paper.mapper.PaperSubjectAnswerMapper;
import com.boss.bes.paper.mapper.PaperSubjectMapper;
import com.boss.bes.paper.vo.papermanage.AnswerVO;
import com.boss.bes.paper.vo.papermanage.SubjectVO;

import com.boss.xtrain.common.util.PojoUtils;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

/**DAO实现类基类
 * @author lenovo
 */
@Component
public class PaperBaseDaoImpl {

    @Resource
    protected PaperMapper paperMapper;

    @Resource
    protected PaperSubjectMapper paperSubjectMapper;

    @Resource
    protected PaperSubjectAnswerMapper paperSubjectAnswerMapper;

    static final String PAPER_ID = "paperId";
    static final String TEMPLATE = "template";
    static final Byte PAPER_SIGN = 1;
    static final Byte TEMPLATE_SIGN = 2;
    List<Paper> getPaperList(PaperQueryDTO paperQueryDTO){
        Example example = new Example(Paper.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo(TEMPLATE,PAPER_SIGN);
        if(paperQueryDTO.getCompanyId() == null){
            criteria.andEqualTo("orgId",paperQueryDTO.getOrgId());
        }else {
            criteria.andEqualTo("companyId",paperQueryDTO.getCompanyId());
        }
        example.orderBy("updatedTime").desc();
        return paperMapper.selectByExample(example);
    }
    List<Paper> getTemplateList(TemplateQueryDTO templateQueryDto){
        Example example = new Example(Paper.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("orgId",templateQueryDto.getOrgId())
                .andEqualTo(TEMPLATE,TEMPLATE_SIGN);
        example.orderBy("updatedTime").desc();
        return paperMapper.selectByExample(example);
    }
    List<SubjectVO> getSubjectList(Long paperId){
        Example paperSubjectExample = new Example(PaperSubject.class);
        Example.Criteria criteriaPs = paperSubjectExample.createCriteria();
        criteriaPs.andEqualTo(PAPER_ID,paperId);
        List<PaperSubject> paperSubjects  =  paperSubjectMapper.selectByExample(paperSubjectExample);
        List<SubjectVO> subjectVOList = PojoUtils.copyListProperties(paperSubjects,SubjectVO::new);
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


}
