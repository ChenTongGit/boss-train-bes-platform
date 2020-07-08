package com.boss.xtrain.permission.pojo.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * @author 53534秦昀清
 * @date 2020.07.08
 */
@Data
abstract class BaseSystemEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 主键id
     */
    @Id
    private Long id;

    /**
     * 状态
     */
    @Column(name = "status")
    private Integer status;

    /**
     * 创建时间
     */
    @Column(name = "created_time")
    private Date createdTime;

    /**
     *  创建人ID 初始插入的时候创建后续不变用于追踪记录的操作人
     */
    @Column(name = "created_by")
    private Long createdBy;

    /**
     *  更新时间记录便于追踪
     */
    @Column(name = "updated_time")
    private Date updatedTime;

    /**
     *  更新人ID 后续的update更新此字典
     */
    @Column(name = "updated_by")
    private Long updatedBy;

}
