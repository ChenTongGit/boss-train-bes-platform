package com.boss.xtrain.common.util.pojo;


import com.boss.xtrain.common.util.annotation.ExcelColumn;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserExcelVo extends AbstractExcelDataVo {


    /**
     * 年龄
     */
    @ExcelColumn(value = "年龄")
    private String age;

    /**
     * 居住地
     */
    @ExcelColumn(value = "居住地")
    private String location;

    /**
     * 职业
     */
    @ExcelColumn(value = "工作")
    private String job;
}
