package com.boss.xtrain.paper.dao.Impl;

import com.boss.xtrain.common.util.PojoUtils;
import com.boss.xtrain.paper.dao.ExamPaperDao;
import com.boss.xtrain.paper.dto.examservice.ExamAnswerDTO;
import com.boss.xtrain.paper.dto.examservice.ExamPaperQuery;
import com.boss.xtrain.paper.dto.examservice.ExamPaperDTO;
import com.boss.xtrain.paper.dto.examservice.ExamSubjectDTO;

import com.boss.xtrain.paper.entity.Paper;
import com.boss.xtrain.paper.entity.PaperSubject;
import com.boss.xtrain.paper.entity.PaperSubjectAnswer;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Component
public class ExamPaperDaoImpl extends PaperBaseDaoImpl implements ExamPaperDao {

    @Override
    public ExamPaperDTO getExamPaper(ExamPaperQuery queryPaperDTO) {

        // 获取试卷信息
        Paper paper = paperMapper.selectByPrimaryKey(queryPaperDTO);
        ExamPaperDTO examPaperDTO = new ExamPaperDTO();
        PojoUtils.copyProperties(paper, examPaperDTO);

        // 设置查询条件
        Example subjectExample = new Example(PaperSubject.class);
        Example.Criteria criteria = subjectExample.createCriteria();
        criteria.andEqualTo("paperId",paper.getPaperId());

        // 通过试卷id获取该试卷的所有题目
        List<PaperSubject> paperSubjectList = paperSubjectMapper.selectByExample(subjectExample);
        List<ExamSubjectDTO> examSubjectDTOS = PojoUtils.copyListProperties(paperSubjectList, ExamSubjectDTO::new);

        // 获取答案列表
        for (ExamSubjectDTO examSubjectDTO :
                examSubjectDTOS) {
            examSubjectDTO.setSubjectTypeId(examSubjectDTO.getCategoryId());
            Example example = new Example(PaperSubjectAnswer.class);
            Example.Criteria criteria1 = example.createCriteria();
            criteria1.andEqualTo("subjectId", examSubjectDTO.getPaperSubjectId());
            List<PaperSubjectAnswer> paperSubjectAnswerList = paperSubjectAnswerMapper.selectByExample(example);
            examSubjectDTO.setAnswers(PojoUtils.copyListProperties(paperSubjectAnswerList, ExamAnswerDTO::new));
        }

        examPaperDTO.setSubjects(examSubjectDTOS);
        return examPaperDTO;
    }
}
