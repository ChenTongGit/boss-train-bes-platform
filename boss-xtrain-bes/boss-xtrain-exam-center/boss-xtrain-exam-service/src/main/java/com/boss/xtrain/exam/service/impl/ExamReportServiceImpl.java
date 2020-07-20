package com.boss.xtrain.exam.service.impl;

import com.boss.xtrain.common.core.exception.BusinessException;
import com.boss.xtrain.common.core.exception.error.BusinessError;
import com.boss.xtrain.exam.dao.ExamReportDao;
import com.boss.xtrain.exam.pojo.dto.ReportDataItemDTO;
import com.boss.xtrain.exam.pojo.dto.ReportDataListDTO;
import com.boss.xtrain.exam.pojo.dto.query.ExamReportQuery;
import com.boss.xtrain.exam.service.ExamReportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ChenTong
 * @date 2020/7/14 7:44
 * @copyright
 * @modified
 * @see
 * @since
 **/
@Service
@Slf4j
public class ExamReportServiceImpl implements ExamReportService {

    @Autowired
    private ExamReportDao examReportDao;
    /**
     * 根据dto查询报表表格信息
     *
     * @param query
     * @return
     */
    @Override
    public List<ReportDataListDTO> queryListByCondition(ExamReportQuery query) {
        try {
            return examReportDao.queryListByCondition(query);
        }catch (Exception e){
            log.error(e.getMessage(), e);
            throw new BusinessException(BusinessError.EXAM_REPORT_QUERY_FAIL);
        }
    }

    /**
     * 根据publishId查询对应考试的报表详情
     *
     * @param publishId
     * @return
     */
    @Override
    public List<ReportDataItemDTO> queryDetail(Long publishId) {
        try {
            return examReportDao.queryDetail(publishId);
        }catch (Exception e){
            log.error(e.getMessage(), e);
            throw new BusinessException(BusinessError.EXAM_REPORT_DETAIL_QUERY_FAIL);
        }
    }
}
