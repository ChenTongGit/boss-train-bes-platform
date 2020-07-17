package com.boss.xtrain.basedata.pojo.dto.subject;

import com.boss.xtrain.basedata.pojo.vo.subject.SubjectVO;
import lombok.Data;

import java.util.List;

@Data
public class SubjectExamDTO {
    private List<SubjectVO> subjectVOS;
    private List<String> categories;
}
