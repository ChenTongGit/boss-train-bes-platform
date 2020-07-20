package com.boss.xtrain.exam.dao;

import com.boss.xtrain.common.core.web.dao.IBaseDao;
import com.boss.xtrain.exam.pojo.dto.query.ExamPublishRecordQuery;
import com.boss.xtrain.exam.pojo.entity.ExamPublishRecord;

import java.util.List;

/**
 * 考试发布数据库操作接口
 *
 * @author ChenTong
 * @version 1.0
 * @date 2020/7/12 15:35
 * @copyright
 * @modified
 * @see
 * @since
 **/
public interface ExamPublishRecordDao extends IBaseDao<ExamPublishRecord, ExamPublishRecordQuery> {

    /**
     * 查询所有数据
     * @author ChenTong
     
     * @return java.util.List<com.boss.xtrain.exam.pojo.entity.ExamPublishRecord>
     * @date 2020/7/8 16:05
     */
    List<ExamPublishRecord> selectAll();

    /**
     * 通过id获取该数据的版本号
     * @author ChenTong
     * @return java.lang.Long
     * @date 2020/7/8 23:20
     */
    Long getVersion(Long id);

    /**
     * 批量删除
     * @author ChenTong
     * @param ids
     * @return int
     * @date 2020/7/9 19:07
     */
    int deleteBatch(List<Long> ids);

    /**
     * 批量发布 - 更新发布状态
     * @param records
     * @return
     */
    int updateStatusBatch(List<ExamPublishRecord> records);

    /**
     * 更新发布状态
     * @param record
     * @return
     */
    int updateStatus(ExamPublishRecord record);

    /**
     * 查询单个
     * @param record
     * @return
     */
    ExamPublishRecord selectOne(ExamPublishRecord record);
}
