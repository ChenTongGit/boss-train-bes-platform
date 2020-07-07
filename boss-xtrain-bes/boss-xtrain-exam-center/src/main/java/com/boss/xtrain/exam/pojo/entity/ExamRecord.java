package com.boss.xtrain.exam.pojo.entity;

import com.boss.xtrain.common.core.pojo.BaseEntity;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "t_exam_record")
public class ExamRecord extends BaseEntity {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_exam_record.id
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_exam_record.t_pr_id
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    private Long tPrId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_exam_record.t_p_id
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    private Long tPId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_exam_record.plan_start_time
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    private Date planStartTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_exam_record.plan_end_time
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    private Date planEndTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_exam_record.actual_start_time
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    private Date actualStartTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_exam_record.actual_end_time
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    private Date actualEndTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_exam_record.objective_subject_score
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    private BigDecimal objectiveSubjectScore;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_exam_record.t_u_id
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    private Long tUId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_exam_record.subjectvie_subject_score
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    private BigDecimal subjectvieSubjectScore;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_exam_record.marking_assign_time
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    private Date markingAssignTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_exam_record.score
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    private BigDecimal score;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_exam_record.system_evaluate
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    private String systemEvaluate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_exam_record.status
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    private Integer status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_exam_record.company_id
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    private Long companyId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_exam_record.org_id
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    private Long orgId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_exam_record.created_by
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    private Long createdBy;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_exam_record.created_time
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    private Date createdTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_exam_record.updated_by
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    private Long updatedBy;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_exam_record.updated_time
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    private Date updatedTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_exam_record.version
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    private Long version;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_exam_record.id
     *
     * @return the value of t_exam_record.id
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_exam_record.id
     *
     * @param id the value for t_exam_record.id
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_exam_record.t_pr_id
     *
     * @return the value of t_exam_record.t_pr_id
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    public Long gettPrId() {
        return tPrId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_exam_record.t_pr_id
     *
     * @param tPrId the value for t_exam_record.t_pr_id
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    public void settPrId(Long tPrId) {
        this.tPrId = tPrId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_exam_record.t_p_id
     *
     * @return the value of t_exam_record.t_p_id
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    public Long gettPId() {
        return tPId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_exam_record.t_p_id
     *
     * @param tPId the value for t_exam_record.t_p_id
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    public void settPId(Long tPId) {
        this.tPId = tPId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_exam_record.plan_start_time
     *
     * @return the value of t_exam_record.plan_start_time
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    public Date getPlanStartTime() {
        return planStartTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_exam_record.plan_start_time
     *
     * @param planStartTime the value for t_exam_record.plan_start_time
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    public void setPlanStartTime(Date planStartTime) {
        this.planStartTime = planStartTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_exam_record.plan_end_time
     *
     * @return the value of t_exam_record.plan_end_time
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    public Date getPlanEndTime() {
        return planEndTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_exam_record.plan_end_time
     *
     * @param planEndTime the value for t_exam_record.plan_end_time
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    public void setPlanEndTime(Date planEndTime) {
        this.planEndTime = planEndTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_exam_record.actual_start_time
     *
     * @return the value of t_exam_record.actual_start_time
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    public Date getActualStartTime() {
        return actualStartTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_exam_record.actual_start_time
     *
     * @param actualStartTime the value for t_exam_record.actual_start_time
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    public void setActualStartTime(Date actualStartTime) {
        this.actualStartTime = actualStartTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_exam_record.actual_end_time
     *
     * @return the value of t_exam_record.actual_end_time
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    public Date getActualEndTime() {
        return actualEndTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_exam_record.actual_end_time
     *
     * @param actualEndTime the value for t_exam_record.actual_end_time
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    public void setActualEndTime(Date actualEndTime) {
        this.actualEndTime = actualEndTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_exam_record.objective_subject_score
     *
     * @return the value of t_exam_record.objective_subject_score
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    public BigDecimal getObjectiveSubjectScore() {
        return objectiveSubjectScore;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_exam_record.objective_subject_score
     *
     * @param objectiveSubjectScore the value for t_exam_record.objective_subject_score
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    public void setObjectiveSubjectScore(BigDecimal objectiveSubjectScore) {
        this.objectiveSubjectScore = objectiveSubjectScore;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_exam_record.t_u_id
     *
     * @return the value of t_exam_record.t_u_id
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    public Long gettUId() {
        return tUId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_exam_record.t_u_id
     *
     * @param tUId the value for t_exam_record.t_u_id
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    public void settUId(Long tUId) {
        this.tUId = tUId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_exam_record.subjectvie_subject_score
     *
     * @return the value of t_exam_record.subjectvie_subject_score
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    public BigDecimal getSubjectvieSubjectScore() {
        return subjectvieSubjectScore;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_exam_record.subjectvie_subject_score
     *
     * @param subjectvieSubjectScore the value for t_exam_record.subjectvie_subject_score
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    public void setSubjectvieSubjectScore(BigDecimal subjectvieSubjectScore) {
        this.subjectvieSubjectScore = subjectvieSubjectScore;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_exam_record.marking_assign_time
     *
     * @return the value of t_exam_record.marking_assign_time
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    public Date getMarkingAssignTime() {
        return markingAssignTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_exam_record.marking_assign_time
     *
     * @param markingAssignTime the value for t_exam_record.marking_assign_time
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    public void setMarkingAssignTime(Date markingAssignTime) {
        this.markingAssignTime = markingAssignTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_exam_record.score
     *
     * @return the value of t_exam_record.score
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    public BigDecimal getScore() {
        return score;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_exam_record.score
     *
     * @param score the value for t_exam_record.score
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    public void setScore(BigDecimal score) {
        this.score = score;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_exam_record.system_evaluate
     *
     * @return the value of t_exam_record.system_evaluate
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    public String getSystemEvaluate() {
        return systemEvaluate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_exam_record.system_evaluate
     *
     * @param systemEvaluate the value for t_exam_record.system_evaluate
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    public void setSystemEvaluate(String systemEvaluate) {
        this.systemEvaluate = systemEvaluate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_exam_record.status
     *
     * @return the value of t_exam_record.status
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_exam_record.status
     *
     * @param status the value for t_exam_record.status
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_exam_record.company_id
     *
     * @return the value of t_exam_record.company_id
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    public Long getCompanyId() {
        return companyId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_exam_record.company_id
     *
     * @param companyId the value for t_exam_record.company_id
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_exam_record.org_id
     *
     * @return the value of t_exam_record.org_id
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    public Long getOrgId() {
        return orgId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_exam_record.org_id
     *
     * @param orgId the value for t_exam_record.org_id
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_exam_record.created_by
     *
     * @return the value of t_exam_record.created_by
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    public Long getCreatedBy() {
        return createdBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_exam_record.created_by
     *
     * @param createdBy the value for t_exam_record.created_by
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_exam_record.created_time
     *
     * @return the value of t_exam_record.created_time
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    public Date getCreatedTime() {
        return createdTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_exam_record.created_time
     *
     * @param createdTime the value for t_exam_record.created_time
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_exam_record.updated_by
     *
     * @return the value of t_exam_record.updated_by
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    public Long getUpdatedBy() {
        return updatedBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_exam_record.updated_by
     *
     * @param updatedBy the value for t_exam_record.updated_by
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    public void setUpdatedBy(Long updatedBy) {
        this.updatedBy = updatedBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_exam_record.updated_time
     *
     * @return the value of t_exam_record.updated_time
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    public Date getUpdatedTime() {
        return updatedTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_exam_record.updated_time
     *
     * @param updatedTime the value for t_exam_record.updated_time
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_exam_record.version
     *
     * @return the value of t_exam_record.version
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    public Long getVersion() {
        return version;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_exam_record.version
     *
     * @param version the value for t_exam_record.version
     *
     * @mbggenerated Tue Jul 07 17:49:29 CST 2020
     */
    public void setVersion(Long version) {
        this.version = version;
    }
}