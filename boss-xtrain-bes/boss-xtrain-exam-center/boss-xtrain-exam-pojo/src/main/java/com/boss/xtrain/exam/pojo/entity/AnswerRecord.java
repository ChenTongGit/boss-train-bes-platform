package com.boss.xtrain.exam.pojo.entity;

import com.boss.xtrain.common.core.pojo.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Table(name = "t_exam_answer_record")
public class AnswerRecord extends BaseEntity {

    /**
     * 考试记录id
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_exam_answer_record.t_r_id
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    @Column(name = "t_r_id")
    private Long examRecordId;

    /**
     * 考生回答内容
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_exam_answer_record.my_answer
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    @Column(name = "my_answer")
    private String myAnswer;

    /**
     * 标准答案
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_exam_answer_record.standard_answer
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    @Column(name = "standard_answer")
    private String standardAnswer;

    /**
     * 本题的答案
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_exam_answer_record.score
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    @Column(name = "score")
    private BigDecimal score;

    /**
     * 评价
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_exam_answer_record.evaluate
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    @Column(name = "evaluate")
    private String evaluate;

    /**
     * 试卷试题id
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_exam_answer_record.evaluate
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    @Column(name = "t_s_id")
    private Long paperSubjectId;

    public Long getPaperSubjectId() {
        return paperSubjectId;
    }

    public void setPaperSubjectId(Long paperSubjectId) {
        this.paperSubjectId = paperSubjectId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_exam_answer_record.t_r_id
     *
     * @return the value of t_exam_answer_record.t_r_id
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    public Long getExamRecordId() {
        return examRecordId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_exam_answer_record.t_r_id
     *
     * @param examRecordId the value for t_exam_answer_record.t_r_id
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    public void setExamRecordId(Long examRecordId) {
        this.examRecordId = examRecordId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_exam_answer_record.my_answer
     *
     * @return the value of t_exam_answer_record.my_answer
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    public String getMyAnswer() {
        return myAnswer;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_exam_answer_record.my_answer
     *
     * @param myAnswer the value for t_exam_answer_record.my_answer
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    public void setMyAnswer(String myAnswer) {
        this.myAnswer = myAnswer;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_exam_answer_record.standard_answer
     *
     * @return the value of t_exam_answer_record.standard_answer
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    public String getStandardAnswer() {
        return standardAnswer;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_exam_answer_record.standard_answer
     *
     * @param standardAnswer the value for t_exam_answer_record.standard_answer
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    public void setStandardAnswer(String standardAnswer) {
        this.standardAnswer = standardAnswer;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_exam_answer_record.score
     *
     * @return the value of t_exam_answer_record.score
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    public BigDecimal getScore() {
        return score;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_exam_answer_record.score
     *
     * @param score the value for t_exam_answer_record.score
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    public void setScore(BigDecimal score) {
        this.score = score;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_exam_answer_record.evaluate
     *
     * @return the value of t_exam_answer_record.evaluate
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    public String getEvaluate() {
        return evaluate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_exam_answer_record.evaluate
     *
     * @param evaluate the value for t_exam_answer_record.evaluate
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    public void setEvaluate(String evaluate) {
        this.evaluate = evaluate;
    }

}