package com.boss.xtrain.exam.pojo.dto;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * 阅卷结果 总体
 *
 * @author ChenTong
 * @version 1.0
 * @date 2020/7/16 14:50
 * @copyright
 * @modified
 * @see
 * @since
 **/
public class MarkingTempListDTO {
    /**
     * 考试记录id
     */
    @NotNull(message = "考试记录id不能为空")
    private Long examRecordId;

    /**
     * 批卷记录的列表
     */
    private List<MarkingDataItemDTO> list;

    public Long getExamRecordId() {
        return examRecordId;
    }

    public void setExamRecordId(Long examRecordId) {
        this.examRecordId = examRecordId;
    }

    public List<MarkingDataItemDTO> getList() {
        return list;
    }

    public void setList(List<MarkingDataItemDTO> list) {
        this.list = list;
    }
}
