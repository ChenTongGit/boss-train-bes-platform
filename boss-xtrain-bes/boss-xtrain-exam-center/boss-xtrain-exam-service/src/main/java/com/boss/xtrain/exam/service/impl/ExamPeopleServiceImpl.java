package com.boss.xtrain.exam.service.impl;

import com.boss.xtrain.common.core.exception.BusinessException;
import com.boss.xtrain.common.core.exception.error.BusinessError;
import com.boss.xtrain.common.util.IdWorker;
import com.boss.xtrain.common.util.PojoUtils;
import com.boss.xtrain.exam.dao.ExamPeopleDao;
import com.boss.xtrain.exam.pojo.dto.ExamPeopleRegisterDTO;
import com.boss.xtrain.exam.pojo.entity.ExamPeople;
import com.boss.xtrain.exam.service.ExamPeopleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 考生服务实现
 *
 * @author ChenTong
 * @version 1.0
 * @date 2020/7/10 0:08
 * @copyright
 * @modified
 * @see
 * @since
 **/
@Service
@Slf4j
public class ExamPeopleServiceImpl implements ExamPeopleService {

    @Autowired
    private ExamPeopleDao examPeopleDao;

    @Autowired
    private IdWorker idWorker;

    /**
     * 注册
     * @author ChenTong
     * @param dto
     * @return java.lang.Integer
     * @date 2020/7/10 0:17
     */
    @Override
    public Integer register(ExamPeopleRegisterDTO dto) {
        if (null == dto)
            throw new BusinessException(BusinessError.EXAM_PEOPLE_REG_FAIL);
        try {
            // 转换dto=》entity
            ExamPeople entity = new ExamPeople();
            PojoUtils.copyProperties(dto, entity);
            // 雪花算法生成id
            entity.setId(idWorker.nextId());
            return this.examPeopleDao.insert(entity);
        }catch (Exception e){
            log.error(BusinessError.EXAM_PEOPLE_REG_FAIL.getMessage(),e);
            throw new BusinessException(BusinessError.EXAM_PEOPLE_REG_FAIL, e);
        }
    }
}
