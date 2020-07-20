package com.boss.xtrain.exam.pojo.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

/**
 * @author ChenTong
 * @date 2020/7/20 6:48
 * @copyright
 * @modified
 * @see
 * @since
 **/
public class ExamPaperInfoListVO {
    /**
     * 试卷id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long paperId;

    /**
     * 试卷名称
     */
    private String paperName;

    public Long getPaperId() {
        return paperId;
    }

    public void setPaperId(Long paperId) {
        this.paperId = paperId;
    }

    public String getPaperName() {
        return paperName;
    }

    public void setPaperName(String paperName) {
        this.paperName = paperName;
    }
}
