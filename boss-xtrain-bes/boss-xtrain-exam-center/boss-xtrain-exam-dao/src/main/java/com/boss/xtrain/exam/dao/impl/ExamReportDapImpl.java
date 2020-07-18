package com.boss.xtrain.exam.dao.impl;

import com.boss.xtrain.exam.dao.ExamReportDao;
import com.boss.xtrain.exam.dao.mapper.ExamPublishRecordMapper;
import com.boss.xtrain.exam.dao.mapper.ExamRecordMapper;
import com.boss.xtrain.exam.pojo.dto.ReportDataItemDTO;
import com.boss.xtrain.exam.pojo.dto.ReportDataListDTO;
import com.boss.xtrain.exam.pojo.dto.query.ExamReportQuery;
import com.boss.xtrain.exam.pojo.entity.ExamPublishRecord;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * 考试报表数据库接口实现
 *
 * @author ChenTong
 * @version 1.0
 * @date 2020/7/13 23:17
 * @copyright
 * @modified
 * @see
 * @since
 **/
@Repository
public class ExamReportDapImpl implements ExamReportDao {

    @Resource
    private ExamPublishRecordMapper publishRecordMapper;

    @Resource
    private ExamRecordMapper examRecordMapper;


    /**
     * 根据dto查询报表表格信息
     *
     * @param query
     * @return
     */
    @Override
    public List<ReportDataListDTO> queryListByCondition(ExamReportQuery query) {
        return publishRecordMapper.queryReportListByCondition(query);
    }

    /**
     * 根据publishId查询对应考试的报表详情
     *
     * @param publishId
     * @return
     */
    @Override
    public List<ReportDataItemDTO> queryDetail(Long publishId) {
        return examRecordMapper.queryReportDetail(publishId);
    }
}
