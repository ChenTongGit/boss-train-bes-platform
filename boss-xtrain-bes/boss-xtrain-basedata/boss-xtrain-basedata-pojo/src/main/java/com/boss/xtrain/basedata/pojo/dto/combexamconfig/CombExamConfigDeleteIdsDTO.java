package com.boss.xtrain.basedata.pojo.dto.combexamconfig;

import lombok.Data;

import java.util.List;

@Data
public class CombExamConfigDeleteIdsDTO {
    private List<CombExamConfigDeleteDTO> deleteList;
}
