package com.boss.xtrain.exam.pojo.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

/**
 * 提交阅卷信息dto
 *
 * @author ChenTong
 * @version 1.0
 * @date 2020/7/16 14:54
 * @copyright
 * @modified
 * @see
 * @since
 **/
public class MarkingSubmitDTO {
    /**
     * 考试记录id
     */
    @NotNull
    private Long examRecordId;

    /**
     * 主观题分数
     */
    private BigDecimal subjectiveSubjectScore;

    /**
     * 总分
     */
    private BigDecimal score;

    /**
     * 版本号
     */
    @NotNull
    private Long version;


    /**
     * 批卷记录的列表
     */
    @Valid
    private List<MarkingDataItemDTO> list;

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public Long getExamRecordId() {
        return examRecordId;
    }

    public void setExamRecordId(Long examRecordId) {
        this.examRecordId = examRecordId;
    }

    public BigDecimal getSubjectiveSubjectScore() {
        return subjectiveSubjectScore;
    }

    public void setSubjectiveSubjectScore(BigDecimal subjectiveSubjectScore) {
        this.subjectiveSubjectScore = subjectiveSubjectScore;
    }

    public BigDecimal getScore() {
        return score;
    }

    public void setScore(BigDecimal score) {
        this.score = score;
    }


    public List<MarkingDataItemDTO> getList() {
        return list;
    }

    public void setList(List<MarkingDataItemDTO> list) {
        this.list = list;
    }
}
