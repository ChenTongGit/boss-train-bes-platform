package com.boss.xtrain.basedata.pojo.dto.combexamconfig;

import com.boss.xtrain.basedata.pojo.vo.combexamitem.CombExamItemVO;
import com.boss.xtrain.common.core.pojo.BaseEntity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Data
public class CombExamConfigDTO extends BaseEntity {
    private Long id;
    private String name;
    private String remark;
    private Long difficulty;
    private String difficultyName;
    private String companyName;
    private String updatedByName;
    private List<CombExamItemVO> combExamItems;
}
