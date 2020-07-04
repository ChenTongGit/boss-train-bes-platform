package com.boss.xtrain.pojo;

import com.boss.xtrain.annotation.ExcelColumn;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class AbstractExcelDataVo {
    @ExcelColumn(value = "名字")
    private String name;

}
