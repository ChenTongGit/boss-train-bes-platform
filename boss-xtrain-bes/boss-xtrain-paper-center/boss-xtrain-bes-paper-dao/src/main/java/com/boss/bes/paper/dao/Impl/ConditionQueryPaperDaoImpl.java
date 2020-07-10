package com.boss.bes.paper.dao.Impl;

import com.boss.bes.paper.dao.ConditionQueryPaperDao;
import com.boss.bes.paper.dto.conditionquerypaper.QueryPaperDTO;
import com.boss.bes.paper.dto.conditionquerypaper.QueryPaperNameListDTO;
import com.boss.bes.paper.entity.Paper;
import com.boss.bes.paper.mapper.PaperMapper;
import com.boss.bes.paper.vo.conditionquerypaper.PaperNameVO;
import com.boss.bes.paper.vo.paperdetail.PaperVO;
import com.boss.xtrain.common.util.PojoUtils;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 条件查询试卷DAO实现类
 */
@Component
public class ConditionQueryPaperDaoImpl  implements ConditionQueryPaperDao {
    @Resource
    private PaperMapper paperMapper;
    static final String TEMPLATE = "template";
    static final String ORG_ID = "orgId";
    static final String COMPANY_ID = "companyId";

    /**
     * @param queryPaperDto
     * @methodsName: queryPaperByCondition
     * @description: 条件查询试卷
     * @param: queryPaperDto
     * @return: java.util.List<com.boss.bes.paper.pojo.vo.conditionquerypaper.PaperVO>
     * @throws:
     */
    @Override
    public List<PaperVO> queryPaperByCondition(QueryPaperDTO queryPaperDto) {
        final Byte TEMPLATE_SIGN = 1;
        //根据查询条件查询试卷
        String combExamManLike = "%" + queryPaperDto.getCombExamMan() + "%";
        String paperNameLike = "%" + queryPaperDto.getPaperName() + "%";
        if (queryPaperDto.getCombExamMan() == null) {
            combExamManLike = null;
        }
        if (queryPaperDto.getPaperName() == null) {
            paperNameLike = null;
        }
        Example example = new Example(Paper.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andBetween("combExamTime", queryPaperDto.getBeginTime(), queryPaperDto.getEndTime())
                .andLike("paperName", paperNameLike)
                .andEqualTo("paperType", queryPaperDto.getPaperType())
                .andEqualTo("difficuty", queryPaperDto.getDifficuty())
                .andEqualTo(TEMPLATE, queryPaperDto.getTemplate())
                .andLike("combExamMan", combExamManLike);
        //无公司id查根据组织机构id查，判断模板标记是试卷还是模板
        if (queryPaperDto.getCompanyId() == null || queryPaperDto.getTemplate().equals(TEMPLATE_SIGN)) {
            criteria.andEqualTo(ORG_ID, queryPaperDto.getOrganizationId());
        } else {
            criteria.andEqualTo(COMPANY_ID, queryPaperDto.getCompanyId());
        }
        example.orderBy("updatedTime").desc();
        List<Paper> list = paperMapper.selectByExample(example);


        return PojoUtils.copyListProperties(list,PaperVO::new);
    }

    /**
     * @param queryPaperNameDto
     * @methodsName: queryPaperName
     * @description: 查询试卷名
     * @param: queryPaperNameDto
     * @return: java.util.List<com.boss.bes.paper.pojo.vo.conditionquerypaper.PaperNameVO>
     * @throws:
     */
    @Override
    public List<PaperNameVO> queryPaperName(QueryPaperNameListDTO queryPaperNameDto) {
        final Byte PAPER_SIGN = 1;
        Example example = new Example(Paper.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo(TEMPLATE, queryPaperNameDto.getTemplate());
        //判断当前是试卷查询框还是模板查询框
        if (!queryPaperNameDto.getTemplate().equals(PAPER_SIGN)) {
            criteria.andEqualTo(ORG_ID, queryPaperNameDto.getOrganizationId());

        } else {
            if (queryPaperNameDto.getCompanyId() == null) {
                criteria.andEqualTo(ORG_ID, queryPaperNameDto.getOrganizationId());
            } else {
                criteria.andEqualTo(COMPANY_ID, queryPaperNameDto.getCompanyId());
            }

        }
        List<Paper> papers = paperMapper.selectByExample(example);
        Set<String> paperNames = new HashSet<>();
        List<Paper> paperList = new ArrayList<>();
        for (Paper paper:
             papers) {
            if(paperNames.contains(paper.getPaperName())){
                continue;
            }else{
                paperList.add(paper);
                paperNames.add(paper.getPaperName());
            }
        }

        return PojoUtils.copyListProperties(paperList,PaperNameVO::new);
    }
}
