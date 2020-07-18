package com.boss.xtrain.exam.service;

import com.boss.xtrain.common.core.exception.BusinessException;
import com.boss.xtrain.exam.pojo.dto.*;
import com.boss.xtrain.exam.pojo.dto.query.ExamPublishRecordQuery;
import com.github.pagehelper.PageInfo;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
public interface ExamPublishRecordService{


    /**
     * 发布考试
     * @author ChenTong
     * @param dto 
     * @return java.lang.Boolean
     * @date 2020/7/9 18:49
     */
    Boolean publishExam(ExamPublishDTO dto);

    /**
     * 批量发布
     * @author ChenTong
     * @param dtos
     * @return java.lang.Boolean
     * @date 2020/7/9 18:57
     */
    @Transactional
    Boolean publishExamBatch(List<ExamPublishDTO> dtos);

    /**
     * 通过query查找列表 title
     * @param query Q extends BaseQuery查询条件
     * @return java.util.List<V>
     * @author ChenTong
     * @date 2020/6/22 7:05
     */
    List<ExamPublishRecordDTO> selectByPage(ExamPublishRecordQuery query);
    
    /**
     * 通过query查询单个考试发布记录
     * @author ChenTong
     * @param query 
     * @return com.boss.xtrain.exam.pojo.dto.ExamPublishRecordDTO
     * @date 2020/7/10 12:00
     */
    ExamPublishRecordDTO selectOne(Long query);

    /**
     * 批量删除数据 事务控制
     * @param dtoList dto列表
     * @return int 返回所删除的行数
     * @author ChenTong
     * @date 2020/7/4 9:09
     */
    @Transactional
    Integer delete(List<ExamPublishDeleteDTO> dtoList) ;

    /**
     * 更新考试发布记录数据
     * @param dto T extends BaseDTO 数据传输对象
     * @return int
     * @author ChenTong
     * @date 2020/6/22 7:18
     */
    @Transactional
    Integer update(ExamPublishRecordUpdateDTO dto);

    /**
     * 插入数据
     * @param dto 考试发布记录dto
     * @return int
     * @author ChenTong
     * @date 2020/6/22 8:18
     * @throws BusinessException 考试发布记录创建异常
     */
    Integer insert(ExamPublishRecordAddDTO dto);




}
