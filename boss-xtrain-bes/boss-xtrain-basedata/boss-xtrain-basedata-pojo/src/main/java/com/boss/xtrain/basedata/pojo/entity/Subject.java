package com.boss.xtrain.basedata.pojo.entity;

import com.boss.xtrain.common.core.pojo.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import javax.persistence.Column;
import javax.persistence.Table;
import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@Table(name = "t_subject")
@Data
public class Subject extends BaseEntity implements Serializable {

    private Integer status;
    /**
     * 题型ID
     */
    @Column(name = "t_s_id")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long subjectTypeId;

    /**
     * 题目类别ID
     */
    @Column(name = "t_c_id")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long categoryId;

    /**
     * 题目
     */
    @Column(name = "name")
    private String name;

    /**
     * 图片路径
     */
    @Column(name = "image_url")
    private String imageUrl;

    /**
     * 备注
     */
    @Column(name = "remark")
    private String remark;

    /**
     * 保留字段1
     */
    @Column(name = "field1")
    private String difficulty;

    /**
     * 保留字段2
     */
    @Column(name = "field2")
    private String field2;

    /**
     * 保留字段3
     */
    @Column(name = "field3")
    private String field3;

}