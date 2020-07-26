package com.boss.xtrain.basedata.pojo.entity;

import java.io.Serializable;
import com.boss.xtrain.common.core.pojo.BaseEntity;
import lombok.*;
import javax.persistence.Column;
import javax.persistence.Table;


@EqualsAndHashCode(callSuper = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "t_comb_exam_config")
@Data
public class CombExamConfig extends BaseEntity implements Serializable {

    @Column(name = "name")
    private String name;

    @Column(name = "remark")
    private String remark;

}