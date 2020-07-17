package com.boss.xtrain.exam.service.impl;

import com.boss.xtrain.common.core.exception.BusinessException;
import com.boss.xtrain.common.core.exception.error.BusinessError;
import com.boss.xtrain.common.util.PojoUtils;
import com.boss.xtrain.exam.dao.ExamRecordDao;
import com.boss.xtrain.exam.pojo.dto.ExamRecordDTO;
import com.boss.xtrain.exam.pojo.dto.query.ExamRecordDetailQuery;
import com.boss.xtrain.exam.pojo.dto.query.ExamRecordQuery;
import com.boss.xtrain.exam.pojo.entity.ExamRecord;
import com.boss.xtrain.exam.pojo.entity.ExamRecordListEntity;
import com.boss.xtrain.exam.pojo.vo.test.PaperSubjectAnswerVO;
import com.boss.xtrain.exam.service.ExamRecordService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 考试记录业务逻辑实现
 *
 * @author ChenTong
 * @version 1.0
 * @date 2020/7/11 15:03
 * @copyright
 * @modified
 * @see
 * @since
 **/
@Service
@Slf4j
public class ExamRecordServiceImpl implements ExamRecordService {

    @Autowired
    private ExamRecordDao examRecordDao;
    /**
     * 考试记录条件查询
     *
     * @param query
     * @return java.util.List<com.boss.xtrain.exam.pojo.dto.ExamRecordDTO>
     * @author ChenTong
     * @date 2020/7/11 15:03
     */
    @Transactional
    @Override
    public List<ExamRecordDTO> queryForCondition(ExamRecordQuery query) {
        // 从数据库读取数据
        try {
            //
            List<ExamRecordListEntity> listEntities = this.examRecordDao.queryListDataByCondition(query);
            // pojo数据转换
            return PojoUtils.copyListProperties(listEntities,ExamRecordDTO::new);
        }catch (Exception e){
            log.error(e.getMessage(), e);
            throw new BusinessException(BusinessError.EXAM_RECORD_QUERY_FAIL);
        }

    }

    @Override
    public PaperSubjectAnswerVO getCompletePaper(ExamRecordDetailQuery submitPaperVO, boolean queryRedis) {
        return null;
    }
}
