package com.boss.xtrain.basedata.service;

import com.boss.xtrain.basedata.pojo.dto.combexamconfig.*;


import java.util.List;

public interface CombExamConfigService{

    void insertConfig(CombExamConfigDTO combExamConfigDTO);

    void deleteConfig(CombExamConfigDeleteDTO combExamConfigDeleteDTO);

    void updateConfig(CombExamConfigUpdateDTO combExamConfigUpdateDTO);

    List<CombExamConfigDTO> queryConfig(CombExamConfigQueryDTO combExamConfigQueryDTO);

    List<CombExamItemDTO> queryItem(CombExamItemQueryDTO combExamItemQueryDTO);

    boolean insertItem(List<CombExamItemDTO> itemList);

    void deleteConfigs(CombExamConfigDeleteDTO object);

    void checkRepeatName(CombExamConfigDTO combExamConfigDto);


}
