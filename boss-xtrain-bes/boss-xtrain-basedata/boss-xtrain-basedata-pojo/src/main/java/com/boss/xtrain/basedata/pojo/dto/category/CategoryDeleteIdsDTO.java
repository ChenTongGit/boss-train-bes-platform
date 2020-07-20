package com.boss.xtrain.basedata.pojo.dto.category;

import com.boss.xtrain.basedata.pojo.vo.category.CategoryDeleteVO;
import lombok.Data;

import java.util.List;

@Data
public class CategoryDeleteIdsDTO {
    private List<CategoryDeleteDTO> ids;
}
