package com.boss.xtrain.basedata.api.paper;

import com.boss.xtrain.common.core.pojo.BaseVO;
import lombok.Data;

@Data
public class CombConfigVO extends BaseVO {
    private String combConfigId;
    private String name;
    private String difficulty;
    private String difficultyName;
    private String remark;
    private String companyName;
    private String updateByName;

}
