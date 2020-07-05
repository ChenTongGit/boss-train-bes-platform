package com.boss.xtrain.common.util.pojo;


import com.boss.xtrain.common.util.annotation.ExcelColumn;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyExcelVo extends AbstractExcelDataVo {
    @ExcelColumn("老板")
    private String boss;
}
