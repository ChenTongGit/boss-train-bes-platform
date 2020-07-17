package com.boss.xtrain.paper.dao.Impl;

import com.boss.xtrain.common.util.PojoUtils;
import com.boss.xtrain.paper.dao.ExamPaperDao;
import com.boss.xtrain.paper.dto.examservice.AnswerDTO;
import com.boss.xtrain.paper.dto.examservice.ExamServiceQueryPaperDTO;
import com.boss.xtrain.paper.dto.examservice.PaperAllMsgDTO;
import com.boss.xtrain.paper.dto.examservice.SubjectDTO;

import com.boss.xtrain.paper.entity.Paper;
import com.boss.xtrain.paper.entity.PaperSubject;
import com.boss.xtrain.paper.entity.PaperSubjectAnswer;
import com.boss.xtrain.paper.entity.SubjectAnswer;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

@Component
public class ExamPaperDaoImpl extends PaperBaseDaoImpl implements ExamPaperDao {

    @Override
    public PaperAllMsgDTO getOnePaperMsg(ExamServiceQueryPaperDTO queryPaperDTO) {
        Paper paper = paperMapper.selectByPrimaryKey(queryPaperDTO);
        PaperAllMsgDTO paperAllMsgDTO = new PaperAllMsgDTO();
        PojoUtils.copyProperties(paper,paperAllMsgDTO);
        Example subjectExample = new Example(PaperSubject.class);
        Example.Criteria criteria = subjectExample.createCriteria();
        criteria.andEqualTo("paperId",paper.getPaperId());

        List<PaperSubject> paperSubjectList = paperSubjectMapper.selectByExample(subjectExample);
        List<SubjectDTO> subjectDTOS = new ArrayList<>();
        subjectDTOS = PojoUtils.copyListProperties(paperSubjectList,SubjectDTO::new);

        for (SubjectDTO subjectDTO:
                subjectDTOS) {
            Example example = new Example(PaperSubjectAnswer.class);
            Example.Criteria criteria1 = example.createCriteria();
            criteria1.andEqualTo("subjectId",subjectDTO.getPaperSubjectId());
            List<PaperSubjectAnswer> paperSubjectAnswerList = paperSubjectAnswerMapper.selectByExample(example);
            subjectDTO.setAnswers(PojoUtils.copyListProperties(paperSubjectAnswerList, AnswerDTO::new));
        }

        paperAllMsgDTO.setSubjects(subjectDTOS);
        System.out.println(1);
        return paperAllMsgDTO;
    }
}
