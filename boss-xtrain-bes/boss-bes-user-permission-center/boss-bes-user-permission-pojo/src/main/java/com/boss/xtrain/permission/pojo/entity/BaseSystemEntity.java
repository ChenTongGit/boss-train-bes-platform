package com.boss.xtrain.permission.pojo.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/*
 * @Author  :yushiqian
 * @Date    :16:12 2020/07/12
 * @Description :公共属性
 * @Version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class BaseSystemEntity implements Serializable {
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
