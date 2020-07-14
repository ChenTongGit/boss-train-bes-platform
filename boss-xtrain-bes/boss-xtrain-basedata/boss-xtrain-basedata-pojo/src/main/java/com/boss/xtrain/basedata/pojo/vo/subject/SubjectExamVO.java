package com.boss.xtrain.basedata.pojo.vo.subject;

import lombok.Data;

import java.util.List;

@Data
public class SubjectExamVO {
    private List<SubjectVO> subjectVOS;
    private List<String> categories;
}
