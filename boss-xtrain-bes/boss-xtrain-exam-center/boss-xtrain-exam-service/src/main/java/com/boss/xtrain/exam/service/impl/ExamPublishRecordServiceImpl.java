package com.boss.xtrain.exam.service.impl;

import com.boss.xtrain.common.core.exception.BusinessException;
import com.boss.xtrain.common.core.exception.error.BusinessError;
import com.boss.xtrain.common.util.IdWorker;
import com.boss.xtrain.common.util.PojoUtils;
import com.boss.xtrain.exam.dao.ExamPublishRecordDao;
import com.boss.xtrain.exam.dao.ExamPublishToUserDao;
import com.boss.xtrain.exam.pojo.dto.ExamPublishDTO;
import com.boss.xtrain.exam.pojo.dto.ExamPublishDeleteDTO;
import com.boss.xtrain.exam.pojo.dto.ExamPublishRecordDTO;
import com.boss.xtrain.exam.pojo.dto.ExamPublishToUserDTO;
import com.boss.xtrain.exam.pojo.dto.query.ExamPublishRecordQuery;
import com.boss.xtrain.exam.pojo.entity.ExamPublishRecord;
import com.boss.xtrain.exam.pojo.entity.ExamPublishToUser;
import com.boss.xtrain.exam.service.ExamPublishRecordService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 发布考试记录服务实现
 *
 * @author ChenTong
 * @version 1.0
 * @date 2020/7/7 22:28
 * @copyright
 * @modified
 * @see
 * @since
 **/
@Service
@Slf4j
public class ExamPublishRecordServiceImpl implements ExamPublishRecordService {

    @Resource
    private IdWorker idWorker;

    @Autowired
    private ExamPublishRecordDao examPublishRecordDao;

    @Autowired
    private ExamPublishToUserDao examPublishToUserDao;

    /**
     * 发布考试
     * @author ChenTong
     * @param dto 
     * @return java.lang.Boolean
     * @date 2020/7/9 17:35
     */
    @Override
    public Boolean publishExam(ExamPublishDTO dto) {

        if (dto.getStatus()==1){
            throw new BusinessException(BusinessError.EXAM_PUBLISH_FAIL);
        }
        try {
            ExamPublishRecord record = new ExamPublishRecord();
            PojoUtils.copyProperties(dto, record);
            return this.examPublishRecordDao.updateStatus(record) == 1;
        }catch (Exception e){
            throw new BusinessException(BusinessError.EXAM_PUBLISH_FAIL);
        }

    }


    @Override
    public Boolean publishExamBatch(List<ExamPublishDTO> dtos){
        if (null ==  dtos)
            throw new BusinessException(BusinessError.EXAM_PUBLISH_FAIL);
        // 判断发布状态
        for (ExamPublishDTO item: dtos) {
            if (item.getStatus() == 1){
                throw new BusinessException(BusinessError.EXAM_PUBLISHED);
            }
        }
        List<ExamPublishRecord> records = PojoUtils.copyListProperties(dtos, ExamPublishRecord::new);
        // 更改状态

        // 批量更新发布
        int result = this.examPublishRecordDao.updateStatusBatch(records);
        // TODO 调用接口修改试卷发布次数 状态
        // 批量删除失败
        if (result != records.size())
            throw new BusinessException(BusinessError.EXAM_PUBLISH_FAIL);
        return true;

    }



    /**
     * 通过query查找列表 title
     * @param query Q extends BaseQuery查询条件
     * @return java.util.List<V>
     * @author ChenTong
     * @date 2020/6/22 7:05
     */
    @Override
    public List<ExamPublishRecordDTO> selectByCondition(ExamPublishRecordQuery query) {
        try {
            List<ExamPublishRecordDTO> examPublishRecordDTOS = new ArrayList<>();
            // 获取考试发布记录
            List<ExamPublishRecord> examPublishRecords = examPublishRecordDao.queryByCondition(query);
            // 获取所有发布人及其id的map
            /** uservo(name:string ,id:long)
            // TODO　List<UserVO> publishUsers = systemService.getPublishUsers();
             // 放到map中便于查询
            for (UserVO item: publishUsers) {
             map.put(String,Long)
            }
             **/
            Map<Long, String> publisherMap= new HashMap<>();

            // --------假数据 start
            publisherMap.put(11L, "张三");
            publisherMap.put(12L, "李四");
            // --------假数据 end

            // TODO List<UserVO> markPeople = systemService.geMarkPeople();
            Map<Long, String> markPeople = new HashMap<>();
            // --------假数据 -start
            markPeople.put(1L, "阅卷人1");
            markPeople.put(2L, "阅卷人2");
            markPeople.put(3L, "阅卷人3");
            // --------假数据 end

            // 相关人名以及id的关系查询
            for (ExamPublishRecord item:examPublishRecords) {
                ExamPublishRecordDTO examPublishRecordDTO = new ExamPublishRecordDTO();
                PojoUtils.copyProperties(item, examPublishRecordDTO);
                // 发布人名以及id转换
                examPublishRecordDTO.setPublisherName(publisherMap.get(examPublishRecordDTO.getPublisher()));
                // 阅卷官人民以及id
                ExamPublishToUser examPublishToUserQuery  = new ExamPublishToUser();
                // 获取当前考试的阅卷人列表
                examPublishToUserQuery.setPublishId(item.getId());
                List<ExamPublishToUser> examPublishToUsers = examPublishToUserDao.query(examPublishToUserQuery);
                // 添加到dto中
                examPublishRecordDTO.setMarkPeople(new ArrayList<>());
                for (ExamPublishToUser examPublishToUser: examPublishToUsers) {
                    ExamPublishToUserDTO examPublishToUserDTO = new ExamPublishToUserDTO();
                    examPublishToUserDTO.setMarkPeople(examPublishToUser.getMarkPeople());
                    examPublishToUserDTO.setName(markPeople.get(examPublishToUser.getMarkPeople()));
                    examPublishRecordDTO.getMarkPeople().add(examPublishToUserDTO);
                }
                examPublishRecordDTOS.add(examPublishRecordDTO);
            }
            return examPublishRecordDTOS;
        }catch (Exception e){
            log.error(BusinessError.EXAM_PUBLISH_RECORD_QUERY_RECORD_ERROR.getMessage(), e);
            throw new BusinessException(BusinessError.EXAM_PUBLISH_RECORD_QUERY_RECORD_ERROR, e);
        }
    }

    /**
     * 批量删除数据 事务控制
     * @param dtoList dto列表
     * @return int 返回所删除的行数
     * @author ChenTong
     * @date 2020/7/4 9:09
     */
    @Override
    public Integer delete(List<ExamPublishDeleteDTO> dtoList) {
        if (null==dtoList || dtoList.isEmpty())
            throw new BusinessException(BusinessError.EXAM_PUBLISH_RECORD_DELETE_RECORD_ERROR);
        // 处理ids 与此同时判断是否发布
        List<Long> ids = new ArrayList<>();
        for (ExamPublishDeleteDTO examPublishDeleteDTO : dtoList) {
            if (examPublishDeleteDTO.getStatus() == 1)
                throw new BusinessException(BusinessError.PUBLISH_DELETE_IS_PUBLISHED);
            ids.add(examPublishDeleteDTO.getId());
        }
        // 删除阅卷关系
         examPublishToUserDao.deleteBatchByPublishId(ids);
        // 删除考试发布记录
        int deletePublish =  examPublishRecordDao.deleteBatch(ids);

        if (deletePublish != ids.size()){
            throw new BusinessException(BusinessError.EXAM_PUBLISH_RECORD_DELETE_RECORD_ERROR);
        }

        return ids.size();


    }

    /**
     * 更新考试发布记录数据
     * @param dto T extends BaseDTO 数据传输对象
     * @return int
     * @author ChenTong
     * @date 2020/6/22 7:18
     */
    @Override
    public Integer update(ExamPublishRecordDTO dto) {
        // 不能为空或者已经发布
        if (null == dto || isPublish(dto))
            throw new BusinessException(BusinessError.PUBLISH_DELETE_IS_PUBLISHED);
        // TODO 如果阅卷人ID更改即该数据不为空,则进行更新 1-n 不好更新 删除之后再添加
        return 0;
    }

    /**
     * 插入数据
     * @param dto 考试发布记录dto
     * @return int
     * @author ChenTong
     * @date 2020/6/22 8:18
     * @throws BusinessException 考试发布记录创建异常
     */
    @Override
    public Integer insert(ExamPublishRecordDTO dto) {

        ExamPublishRecord examPublishRecord = new ExamPublishRecord();
        // 数据转换
        PojoUtils.copyProperties(dto, examPublishRecord);
        // 雪花算法获取id
        examPublishRecord.setId(idWorker.nextId());
        // 二维码链接 前端生成二维码
        String qrCodeUrl = String.format("http://localhost:8080/#/exam/{%d}",dto.getId());
        examPublishRecord.setQrcodeUrl(qrCodeUrl);
        // 添加阅卷人
        List<ExamPublishToUser> examPublishToUsers = PojoUtils.copyListProperties(dto.getMarkPeople(), ExamPublishToUser::new);
        for (ExamPublishToUser item: examPublishToUsers
             ) {
            item.setPublishId(examPublishRecord.getId());
            item.setId(idWorker.nextId());
        }

        int insertExamPublishRecordResult =  examPublishRecordDao.insert(examPublishRecord);
        // 数据库添加阅卷人
        int insertMarkResult = examPublishToUserDao.insertBatch(examPublishToUsers);
        if (insertExamPublishRecordResult != 1 || insertMarkResult != examPublishToUsers.size()){
            log.error(BusinessError.EXAM_PUBLISH_RECORD_INSERT_RECORD_ERROR.getMessage());
            throw new BusinessException(BusinessError.EXAM_PUBLISH_RECORD_INSERT_RECORD_ERROR);
        }

        return insertExamPublishRecordResult;


    }
    
    /**
     * 判断该记录是否已经发布
     * @author ChenTong
     * @param dto 
     * @return boolean
     * @date 2020/7/8 23:05
     */
    private boolean isPublish(ExamPublishRecordDTO dto){
        return dto.getStatus() == 1;
    }

    /**
     * 通过记录id获取version
     * @author ChenTong
     * @param dto
     * @return java.lang.Long
     * @date 2020/7/8 23:34
     */
    private Long getVersionById(ExamPublishRecordDTO dto){
        // 从数据库中读取version
        Long version = examPublishRecordDao.getVersion(dto.getId());

        if (null == version)
            throw new BusinessException(BusinessError.EXAM_PUBLISH_RECORD_GET_VERSION_FAIL);
        return version;

    }
}
