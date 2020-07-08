package com.boss.xtrain.basedata.pojo.vo.category;

import com.boss.xtrain.common.core.pojo.BaseVO;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CategoryVO extends BaseVO {
    private Long id;
    private String name;
    private Long parentId;
    private Date updateTime;
    private Long version;
}
