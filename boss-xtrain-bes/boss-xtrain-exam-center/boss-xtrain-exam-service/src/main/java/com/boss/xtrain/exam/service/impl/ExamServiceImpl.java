package com.boss.xtrain.exam.service.impl;

import com.alibaba.fastjson.JSON;
import com.boss.xtrain.common.core.exception.BusinessException;
import com.boss.xtrain.common.core.exception.error.BusinessError;
import com.boss.xtrain.common.core.http.CommonRequest;
import com.boss.xtrain.common.redis.api.RedisUtil;
import com.boss.xtrain.common.util.IdWorker;
import com.boss.xtrain.common.util.PojoUtils;
import com.boss.xtrain.exam.dao.AnswerRecordDao;
import com.boss.xtrain.exam.dao.ExamPublishRecordDao;
import com.boss.xtrain.exam.dao.ExamPublishToUserDao;
import com.boss.xtrain.exam.dao.ExamRecordDao;
import com.boss.xtrain.exam.pojo.dto.AnswerRecordDTO;
import com.boss.xtrain.exam.pojo.dto.AnswerRecordTempInsertDTO;
import com.boss.xtrain.exam.pojo.dto.ExamStartAddRecordDTO;
import com.boss.xtrain.exam.pojo.dto.SubmitExamDTO;
import com.boss.xtrain.exam.pojo.entity.AnswerRecord;
import com.boss.xtrain.exam.pojo.entity.ExamPublishRecord;
import com.boss.xtrain.exam.pojo.entity.ExamRecord;
import com.boss.xtrain.exam.pojo.vo.AnswerDetailsVO;
import com.boss.xtrain.exam.pojo.vo.PaperSubjectAnswerVO;
import com.boss.xtrain.exam.pojo.vo.test.SubjectDetailsVO;
import com.boss.xtrain.exam.service.ExamService;
import com.boss.xtrain.exam.service.PaperFeign;
import com.boss.xtrain.paper.dto.examservice.ExamAnswerDTO;
import com.boss.xtrain.paper.dto.examservice.ExamPaperDTO;
import com.boss.xtrain.paper.dto.examservice.ExamPaperQuery;
import com.boss.xtrain.paper.dto.examservice.ExamSubjectDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.*;

/**
 * 手机答卷业务实现
 *
 * @author ChenTong
 * @version 1.0
 * @date 2020/7/10 15:31
 * @copyright
 * @modified
 * @see
 * @since
 **/
@Service
@Slf4j
public class ExamServiceImpl implements ExamService {

    @Autowired
    private ExamRecordDao recordDao;

    @Autowired
    private AnswerRecordDao answerRecordDao;

    @Autowired
    private ExamPublishRecordDao examPublishRecordDao;

    @Autowired
    private IdWorker idWorker;

    @Autowired
    private ExamPublishToUserDao examPublishToUserDao;

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private PaperFeign paperFeign;

    private static final String TEMP_ANSWER_REDIS_KEY = "bes:tempAnswerRecord:";

    private static final String RIGHT_ANSWERS_REDIS_KEY = "bes:rightAnswer:";

    /**
     * 考试开始 初始化考试记录
     *
     * @param dto
     * @return java.lang.Long 考试记录id
     * @author ChenTong
     * @date 2020/7/10 15:32
     */
    @Transactional
    @Override
    public Long insertBasicExamRecord(ExamStartAddRecordDTO dto) {
        if (null == dto)
            throw new BusinessException(BusinessError.EXAM_RECORD_INSERT_FAIL);

        ExamPublishRecord examPublishRecord = new ExamPublishRecord();
        examPublishRecord.setId(dto.getPublishId());
        // 获取考试的基本信息
        examPublishRecord = examPublishRecordDao.selectOne(examPublishRecord);
        Date startTime = examPublishRecord.getStartTime();
        Date endTime = examPublishRecord.getEndTime();
        // 构造需要添加
        ExamRecord examRecord = new ExamRecord();
        // 雪花算法生成id
        examRecord.setId(idWorker.nextId());
        examRecord.setPublishId(dto.getPublishId());
        examRecord.setExamPeople(dto.getExamPeople());
        // 添加计划时间段
        examRecord.setPlanStartTime(startTime);
        examRecord.setPlanEndTime(endTime);
        // 考试开始时间
        examRecord.setActualStartTime(new Date());
        examRecord.setActualEndTime(new Date());
        examRecord.setStatus(0);
        // 分数设置数据初始值
        initialScore(examRecord);
        // 分配阅卷官
        examRecord.setMarkUserId(allocateMarkPeople(examPublishRecord.getId(),examPublishRecord.getMarkingMode()));
        // 分配阅卷时间
        examRecord.setMarkingAssignTime(examRecord.getActualStartTime());

        String key = "examLimitTime:"+examRecord.getId();
        setLimitTimeToRedis(key, examPublishRecord.getLimitTime());

        // 添加考试记录
        int result =  this.recordDao.insertBasicRecord(examRecord);
        if (result != 1)
            throw new BusinessException(BusinessError.EXAM_RECORD_INSERT_FAIL);
        return examRecord.getId();
    }

    /**
     * 为考试进行计时
     * @author ChenTong
     * @param key 考生的考试计时key examRecordId
     * @param limitTime key存在的时间
     * @return void
     * @date 2020/7/11 9:49
     */
    public void setLimitTimeToRedis(String key, Long limitTime) {
        try {
            redisUtil.set(key,limitTime,limitTime);
        }catch (Exception e){
            log.error(e.getMessage(), e);
            throw new BusinessException(BusinessError.SET_EXAM_LIMIT_TIME_FAIL,e);

        }
    }

    /**
     * 获取试卷 可以提供给多个服务使用
     * @param query 查询试卷id 记录id
     * @param queryRedis 为了方便复用 是否需要从redis中恢复答案
     */
    @Override
    public PaperSubjectAnswerVO getPaper(SubmitExamDTO query, boolean queryRedis) {

        // 调用试卷服务获取试卷
        CommonRequest<ExamPaperQuery> request = new CommonRequest<>();
        ExamPaperQuery examPaperQuery = new ExamPaperQuery();
        examPaperQuery.setPaperId(query.getPaperId());
        request.setBody(examPaperQuery);
        ExamPaperDTO examPaperDTO = this.paperFeign.getExamPaper(request).getData();
        if (examPaperDTO == null) {
            // 试卷不存在
            throw new BusinessException(BusinessError.MOBILE_PAPER_NOT_EXIST);
        }
        // 从redis中获取数据
        Map<Long, String> backAnswerMap = null;
        if (queryRedis&&redisUtil.hasKay(TEMP_ANSWER_REDIS_KEY+query.getExamRecordId())){
            backAnswerMap = createBackAnswerMap(query.getExamRecordId());
        }

        PaperSubjectAnswerVO paperSubjectAnswerVO = new PaperSubjectAnswerVO();
        PojoUtils.copyProperties(examPaperDTO, paperSubjectAnswerVO);
        List<SubjectDetailsVO> subjectDetailsVOS = new ArrayList<>();
        for (ExamSubjectDTO subjectDetailsDto : examPaperDTO.getSubjects()) {
            // 试题dto转vo
            SubjectDetailsVO subjectDetailsVO = new SubjectDetailsVO();
            PojoUtils.copyProperties(subjectDetailsDto, subjectDetailsVO);
            // 答案列表dto转vo
            List<AnswerDetailsVO> answerDetailsVOS = new ArrayList<>();
            // 单选题：1
            // 多选题：2
            if (subjectDetailsDto.getSubjectTypeId().equals(1L)
                    || subjectDetailsDto.getSubjectTypeId().equals(2L)) {
                answerDetailsVOS = PojoUtils.copyListProperties(subjectDetailsDto.getAnswers(), AnswerDetailsVO::new);
            }
            subjectDetailsVO.setAnswers(answerDetailsVOS);
            // 恢复答案
            if (queryRedis&&redisUtil.hasKay(TEMP_ANSWER_REDIS_KEY+query.getExamRecordId())) {
                // redis中保存的答案读取，答案不存在设置的是null
                subjectDetailsVO.setMyAnswer(backAnswerMap.get(subjectDetailsDto.getPaperSubjectId()));
            }
            subjectDetailsVOS.add(subjectDetailsVO);
        }

        // 处理选择题答案列表保存到redis中 第一次读取
        if(!redisUtil.hasKay(RIGHT_ANSWERS_REDIS_KEY+query.getPaperId())){
            this.setRightAnswer(examPaperDTO);
        }
        paperSubjectAnswerVO.setSubjects(subjectDetailsVOS);

        return paperSubjectAnswerVO;

    }

    /**
     * 获取考生考试剩余时间
     * @author ChenTong
     * @param key 考生的考试计时key examRecordId
     * @return java.lang.Long
     * @date 2020/7/11 9:53
     */
    public Long getLimitTimeFromRedis(String key){
        try {
            return redisUtil.getExpire(key);
        }catch (Exception e){
            log.error(e.getMessage(), e);
            throw new BusinessException(BusinessError.GET_EXAM_LIMIT_TIME_FAIL,e);
        }
    }


    /**
     * 考试过程中暂时保存考生回答
     * 保存到redis中
     * @param dtos
     * @return java.lang.Integer
     * @author ChenTong
     * @date 2020/7/10 21:47
     */
    @Override
    public Integer insertTemAnswerRecord(List<AnswerRecordTempInsertDTO> dtos) {
        if ( dtos == null || dtos.isEmpty()){
            throw new BusinessException(BusinessError.EXAM_ANSWER_SAVE_FAIL);
        }
        // 设置key
        String key = TEMP_ANSWER_REDIS_KEY+dtos.get(0).getExamRecordId();
        // 保存到redis中 保存三个小时
        long saveTime = 60L*60*3;
        redisUtil.set(key, JSON.toJSONString(dtos), saveTime);

        Object re = redisUtil.get(key);
        log.info(re+"");
            return 1;
    }

    /**
     * 获取试卷使用，
     * 取出redis中的答案，并生成subjectId->answer的map
     *
     * @param recordId 考试记录id，redis的key
     * @return 如果redis中不存在答案，返回空的map
     */
    private Map<Long, String> createBackAnswerMap(Long recordId) {
        List<AnswerRecordTempInsertDTO> answerRecordTempInsertDTOS =  this.getRealAnswer(recordId);
        Map<Long, String> map = new HashMap<>();
        for (AnswerRecordTempInsertDTO dto : answerRecordTempInsertDTOS) {
            map.put(dto.getPaperSubjectId(), dto.getMyAnswer());
        }
        return map;
    }

    /**
     * 考试结束提交答案
     * 提交需要通过试卷的id获取正确答案计算客观题得分
     * @param dto
     * @return java.lang.Integer
     * @author ChenTong
     * @date 2020/7/10 23:42
     */
    @Transactional
    @Override
    public Integer submitExam(SubmitExamDTO dto) {
        // 调用试卷微服务，通过试卷id获取考试试题正确答案 为了可以快速查找使用map存储
        Map<String, String> rightAns =  getRightAnswers(dto.getPaperId());
        // 从缓存中获取考生作答情况
        List<AnswerRecordTempInsertDTO> realAns = getRealAnswer(dto.getExamRecordId());
        // 1、将考试作答写入数据库 2、计算分数记录到考试记录中 3、修改考试记录中考试结束时间
        // 批量添加考试记录
        List<AnswerRecordDTO> answerRecordDTOS = PojoUtils.copyListProperties(realAns, AnswerRecordDTO::new);
        // 将正确答案添加到记录中并进行分数的额计算
        BigDecimal totalScore= new BigDecimal(0);
        for (AnswerRecordDTO answer: answerRecordDTOS){
            answer.setId(idWorker.nextId());
            // 写入正确答案
            answer.setStandardAnswer(rightAns.get(Long.toString(answer.getPaperSubjectId())));
            // 状态
            answer.setStatus(1);
            // 判断该题是否得分并写入
            setSubScore(answer);
            // 计算客观题得分
            totalScore = totalScore.add(answer.getScore());
            answer.setExamRecordId(dto.getExamRecordId());

        }
        ExamRecord examRecord = new ExamRecord();
        examRecord.setId(dto.getExamRecordId());
        examRecord.setScore(totalScore);
        examRecord.setObjectiveSubjectScore(totalScore);
        examRecord.setActualEndTime(new Date());
        examRecord.setStatus(1);
        examRecord.setVersion(0L);

        try {
            // 更新考试记录
            this.recordDao.update(examRecord);
            // pojo转换 保存每道题的作答记录
            List<AnswerRecord> answerRecordList = PojoUtils.copyListProperties(answerRecordDTOS, AnswerRecord::new);
            return this.answerRecordDao.insertBatch(answerRecordList);
        }catch (Exception e){
            log.error(e.getMessage(), e);
            throw new BusinessException(BusinessError.EXAM_ANSWER_SAVE_FAIL);
        }
    }


    /**
     * 提交试卷自动打出选择题分数
     * @author ChenTong
     * @param answer
     * @return void
     * @date 2020/7/19 22:30
     */
    private void setSubScore(AnswerRecordDTO answer) {
        // 获取实际作答情况
        String realAns = answer.getMyAnswer();
        // 考试标准答案
        String standardAns = answer.getStandardAnswer();
        // 该题分值
        BigDecimal score = answer.getStandardScore();
        // 该题题型
        Long subjectType = answer.getSubjectTypeId();

        answer.setScore(new BigDecimal(0));
        switch (subjectType.toString()){
            // 单选
            case "1":
                if (realAns.equals(standardAns))
                    answer.setScore(score);
                break;
            // 多选
            case "2":
                if(answer.getStandardAnswer()==null||answer.getMyAnswer().equals("")||answer.getMyAnswer()==null)
                    break;
                Set<String> set = new HashSet<>(Arrays.asList(answer.getStandardAnswer().split(",")));
                int correctNum = 0; // 选中的题数
                List<String> myAns = Arrays.asList(realAns.split(","));
                for (String ansItem:  myAns) {
                    if (set.contains(ansItem))
                        correctNum++;
                    else{
                        correctNum = 0;
                        break;
                    }
                }
                if (correctNum==set.size()){
                    answer.setScore(score);
                }else if (correctNum > 0){
                    // 只获取的一半分数
                    answer.setScore(score.divide(new BigDecimal(2)));
                }
                break;
            default:
                answer.setScore(new BigDecimal(0));
        }
    }

    /**
     * 获取考试过程中存放的答案
     * @author ChenTong
     * @param examRecordId
     * @return java.util.List<com.boss.xtrain.exam.pojo.dto.AnswerRecordTempInsertDTO>
     * @date 2020/7/11 7:27
     */
    private List<AnswerRecordTempInsertDTO> getRealAnswer(Long examRecordId) {
        try {
            String key = TEMP_ANSWER_REDIS_KEY+examRecordId;
            Object realAnswer =redisUtil.get(key);
            return JSON.parseArray(realAnswer.toString(), AnswerRecordTempInsertDTO.class);
        }catch (Exception e){
            log.error(e.getMessage() ,e);
            throw new BusinessException(BusinessError.GET_TMP_ANSWER_FAIL, e);
        }
    }

    /**
     * 将正确答案保存到redis中
     * @param examPaperDTO
     */
    private void setRightAnswer(ExamPaperDTO examPaperDTO){
        Map<Long, String> rightAns = new HashMap<>();
        for (ExamSubjectDTO subject: examPaperDTO.getSubjects()) {
            // 单选题答案
            if (subject.getSubjectTypeId() == 1){
                for (ExamAnswerDTO answer: subject.getAnswers()) {
                    if (Boolean.TRUE.equals(answer.getRightAnswer())){
                        rightAns.put(subject.getPaperSubjectId(),Long.toString(answer.getPaperSubjectAnswerId()));
                        break;
                    }
                }
                // 多选题
            }else if (subject.getSubjectTypeId() == 2){
                for (ExamAnswerDTO answer: subject.getAnswers()) {
                    if (Boolean.TRUE.equals(answer.getRightAnswer())){
                        if (rightAns.containsKey(subject.getPaperSubjectId())){
                            String rightAnswers = rightAns.get(subject.getPaperSubjectId())+","+answer.getPaperSubjectAnswerId();
                            rightAns.put(subject.getPaperSubjectId(), rightAnswers);
                            continue;
                        }
                        rightAns.put(subject.getPaperSubjectId(),Long.toString(answer.getPaperSubjectAnswerId()));
                    }
                }
            }else{
                rightAns.put(subject.getPaperSubjectId(),subject.getAnswers().get(0).getAnswer());
            }
        }
        // 保存一天
        redisUtil.set(RIGHT_ANSWERS_REDIS_KEY+examPaperDTO.getPaperId(),rightAns,24L*60*60);
    }

    /**
     * 调用试卷中心服务获取试题数据 paper-subject-id:correctAns
     * @param paperId
     * @return
     */
    private Map<String, String> getRightAnswers(Long paperId) {
        try {
           return (LinkedHashMap<String, String>) redisUtil.get(RIGHT_ANSWERS_REDIS_KEY+paperId);
        }catch (Exception e){
            log.error(e.getMessage(), e);
            throw new BusinessException(BusinessError.GET_TMP_ANSWER_FAIL);
        }

    }

    /**
     * 设置开始记录成绩相关初始值
     * @author ChenTong
     * @param examRecord
     * @return void
     * @date 2020/7/10 18:04
     */
    private void initialScore(ExamRecord examRecord){
        BigDecimal zero = new BigDecimal(0);
        examRecord.setSubjectiveSubjectScore(zero);
        examRecord.setScore(zero);
        examRecord.setObjectiveSubjectScore(zero);

    }

    /**
     * 分配阅卷官
     * @author ChenTong
     * @param markMode examPublishRecord中分配阅卷官字段
     * @param examPublishId 考试发布记录id获取用来该场阅卷官
     * @return 被分配到的阅卷官的id
     * @date 2020/7/10 18:05
     */
    private Long allocateMarkPeople(Long examPublishId, Integer markMode){
        // 获取该场考试的阅卷官
        List<Long> markUsers = examPublishToUserDao.queryMarkUserByPublishId(examPublishId);

        if (null == markUsers || markUsers.isEmpty())
            // 没有阅卷官
            throw new BusinessException(BusinessError.EXAM_MARK_PEOPLE_NOT_EXIT);
        // 所被分配的阅卷id
        int index = 0;
        // 开始分配
        if (null != markMode && 0 == markMode){ // 平均分配
            // 平均分配 通过缓存以及分布式锁来进行计数器的维护
            String key = "allocate:"+examPublishId; // 维护分配时的计数器
            Integer currentCount = 0;
            if (Boolean.TRUE.equals(redisUtil.hasKay(key))){
                // 获取当前分配的下标
                currentCount = (Integer) redisUtil.get(key);
                if (currentCount == null){
                    currentCount = 0;
                }
                // 取余 环状
                index = currentCount % markUsers.size();
            }
            // 分配成功 更新状态
            redisUtil.set(key, currentCount+1);

        }else { // 随机分配
            try {
                Random random = SecureRandom.getInstanceStrong();
                index = random.nextInt(markUsers.size());
            } catch (NoSuchAlgorithmException e) {
                log.error(e.getMessage());
            }
        }
        log.info("allocate num: "+index);

        return markUsers.get(index);
    }


}
