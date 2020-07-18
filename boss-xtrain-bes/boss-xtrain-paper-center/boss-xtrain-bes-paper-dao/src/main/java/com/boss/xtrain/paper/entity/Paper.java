package com.boss.xtrain.paper.entity;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "`t_paper`")
public class Paper {
    @Id
    private Long paperId;

    private String paperName;

    private Long paperType;

    private Long difficuty;

    private String combExamMa;

    private Date combExamTim;

    private BigDecimal score;

    private String discript;

    private Integer downloadTimes;

    private Integer publishTimes;

    private Boolean status;

    private Long orgId;

    private Long companyId;

    private Long createdBy;

    private Date createdTime;

    private Long updatedBy;

    private Date updatedTime;
    @Version
    private Long version;

    private Boolean template;

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

    public Long getPaperType() {
        return paperType;
    }

    public void setPaperType(Long paperType) {
        this.paperType = paperType;
    }

    public Long getDifficuty() {
        return difficuty;
    }

    public void setDifficuty(Long difficuty) {
        this.difficuty = difficuty;
    }

    public String getCombExamMa() {
        return combExamMa;
    }

    public void setCombExamMa(String combExamMa) {
        this.combExamMa = combExamMa;
    }

    public Date getCombExamTim() {
        return combExamTim;
    }

    public void setCombExamTim(Date combExamTim) {
        this.combExamTim = combExamTim;
    }

    public BigDecimal getScore() {
        return score;
    }

    public void setScore(BigDecimal score) {
        this.score = score;
    }

    public String getDiscript() {
        return discript;
    }

    public void setDiscript(String discript) {
        this.discript = discript;
    }

    public Integer getDownloadTimes() {
        return downloadTimes;
    }

    public void setDownloadTimes(Integer downloadTimes) {
        this.downloadTimes = downloadTimes;
    }

    public Integer getPublishTimes() {
        return publishTimes;
    }

    public void setPublishTimes(Integer publishTimes) {
        this.publishTimes = publishTimes;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Long getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Long updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public Boolean getTemplate() {
        return template;
    }

    public void setTemplate(Boolean template) {
        this.template = template;
    }
}