package com.boss.xtrain.exam.dao;

import com.boss.xtrain.exam.pojo.dto.ReportDataItemDTO;
import com.boss.xtrain.exam.pojo.dto.ReportDataListDTO;
import com.boss.xtrain.exam.pojo.dto.query.ExamReportQuery;

import java.util.List;

/**
 * 考试报表数据库操作接口
 *
 * @author ChenTong
 * @version 1.0
 * @date 2020/7/13 23:14
 * @copyright
 * @modified
 * @see
 * @since
 **/
public interface ExamReportDao {

    /**
     * 根据dto查询报表表格信息
     *
     * @param query
     * @return
     */
    List<ReportDataListDTO> queryListByCondition(ExamReportQuery query);

    /**
     * 根据publishId查询对应考试的报表详情
     *
     * @param publishId
     * @return
     */
    List<ReportDataItemDTO> queryDetail(Long publishId);
}
