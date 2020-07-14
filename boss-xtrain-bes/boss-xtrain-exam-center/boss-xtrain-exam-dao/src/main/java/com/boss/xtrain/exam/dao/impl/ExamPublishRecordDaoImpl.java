package com.boss.xtrain.exam.dao.impl;

import com.boss.xtrain.exam.dao.ExamPublishRecordDao;
import com.boss.xtrain.exam.dao.mapper.ExamPublishRecordMapper;
import com.boss.xtrain.exam.pojo.dto.query.ExamPublishRecordQuery;
import com.boss.xtrain.exam.pojo.entity.ExamPublishRecord;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 考试发布记录
 *
 * @author ChenTong
 * @version 1.0
 * @date 2020/7/8 15:37
 * @copyright
 * @modified
 * @see
 * @since
 **/
@Repository
@Slf4j
public class ExamPublishRecordDaoImpl implements ExamPublishRecordDao {

    @Resource
    private ExamPublishRecordMapper mapper;
    /**
     * @param entity
     * @param:
     * @return:
     * @see
     * @since
     */
    @Override
    public int insert(ExamPublishRecord entity) {
        return mapper.insert(entity);
    }

    /**
     * @param entity
     * @param:
     * @return:
     * @see
     * @since
     */
    @Override
    public int delete(ExamPublishRecord entity) {
        return 0;
    }

    /**
     * 根据主键更新不为null的属性
     * @param entity
     * @param:
     * @return:
     * @see
     * @since
     */
    @Override
    public int update(ExamPublishRecord entity) {
        return mapper.updateByPrimaryKeySelective(entity);
    }


    /**
     * 按条件查找
     * @author ChenTong
     * @param query
     * @return java.util.List<com.boss.xtrain.exam.pojo.entity.ExamPublishRecord>
     * @date 2020/7/8 22:39
     */
    @Override
    public List<ExamPublishRecord> queryByCondition(ExamPublishRecordQuery query) {
        return mapper.queryListByCondition(query);
    }



    /**
     * 查询所有数据
     *
     * @return java.util.List<com.boss.xtrain.exam.pojo.entity.ExamPublishRecord>
     * @author ChenTong
     * @date 2020/7/8 16:05
     */
    @Override
    public List<ExamPublishRecord> selectAll() {
        return mapper.selectAll();
    }



    /**
     * 通过id获取该数据的版本号
     * @author ChenTong
     * @return java.lang.Long
     * @date 2020/7/8 23:20
     */
    @Override
    public Long getVersion(Long id) {
        return mapper.getVersionById(id);
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @Override
    public int deleteBatch(List<Long> ids) {
        return mapper.deleteBatch(ids);
    }

    /**
     * 批量发布 - 更新发布状态
     *
     * @param records
     * @return
     */
    @Override
    public int updateStatusBatch(List<ExamPublishRecord> records) {
        for (ExamPublishRecord record: records
             ) {
            mapper.updateByPrimaryKeySelectiveWithVersion(record);
        }
        return records.size();
    }

    @Override
    public int updateStatus(ExamPublishRecord record) {
        return mapper.updateByPrimaryKeySelectiveWithVersion(record);
    }

    /**
     * 查询单个
     *
     * @param record
     * @return
     */
    @Override
    public ExamPublishRecord selectOne(ExamPublishRecord record) {
        return mapper.selectOne(record);
    }
}
