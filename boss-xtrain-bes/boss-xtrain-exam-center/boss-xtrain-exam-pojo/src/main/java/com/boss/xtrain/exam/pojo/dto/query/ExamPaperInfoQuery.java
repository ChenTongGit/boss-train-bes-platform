package com.boss.xtrain.exam.pojo.dto.query;

/**
 * 获取考试信息query
 *
 * @author ChenTong
 * @version 1.0
 * @date 2020/7/17 18:01
 * @copyright
 * @modified
 * @see
 * @since
 **/
public class ExamPaperInfoQuery {

    /**
     * 考试信息id
     */
    private Long examPublishRecordId;

    public Long getExamPublishRecordId() {
        return examPublishRecordId;
    }

    public void setExamPublishRecordId(Long examPublishRecordId) {
        this.examPublishRecordId = examPublishRecordId;
    }
}
