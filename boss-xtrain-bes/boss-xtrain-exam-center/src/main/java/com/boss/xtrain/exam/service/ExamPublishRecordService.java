package com.boss.xtrain.exam.service;

import com.boss.xtrain.common.core.web.service.CommonCurdService;
import com.boss.xtrain.common.core.web.service.CurdService;
import com.boss.xtrain.exam.pojo.dto.ExamPublishRecordDTO;
import com.boss.xtrain.exam.pojo.dto.query.ExamPublishRecordQuery;
import com.boss.xtrain.exam.pojo.vo.ExamPublishRecordVO;
import org.springframework.transaction.annotation.Transactional;

/**
 * 考试发布记录业务层接口
 *
 * @author ChenTong
 * @version 1.0
 * @date 2020/7/7 22:24
 * @copyright
 * @modified
 * @see
 * @since
 **/
@Transactional
public interface ExamPublishRecordService extends CommonCurdService<ExamPublishRecordDTO, ExamPublishRecordVO, ExamPublishRecordQuery> {
    Integer publishExam(ExamPublishRecordDTO dto);
}
