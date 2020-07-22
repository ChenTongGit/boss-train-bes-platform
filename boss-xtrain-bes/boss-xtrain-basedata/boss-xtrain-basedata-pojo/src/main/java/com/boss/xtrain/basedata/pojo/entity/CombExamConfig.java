package com.boss.xtrain.basedata.pojo.entity;

import java.io.Serializable;
import java.util.Date;
import com.boss.xtrain.common.core.pojo.BaseEntity;
import lombok.*;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

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