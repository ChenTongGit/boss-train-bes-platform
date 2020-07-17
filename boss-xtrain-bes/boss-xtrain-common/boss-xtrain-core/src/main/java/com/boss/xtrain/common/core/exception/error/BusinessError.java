package com.boss.xtrain.common.core.exception.error;

import lombok.Getter;

/**
 * @author 郭心蕊
 * @date 2020/07/02
 * @description 业务错误码设计
 */

@Getter
public enum BusinessError {

    /**
     * 基础数据服务 题目类别错误
     */
    BASE_DATA_CATEGORY_INSERT_ERROR("200201","新增题目类别失败"),
    BASE_DATA_CATEGORY_DELETE_ERROR("200202","删除题目类别失败"),
    BASE_DATA_CATEGORY_UPDATE_ERROR("200203","更新题目类别失败"),
    BASE_DATA_CATEGORY_QUERY_ERROR("200204","查询题目类别失败"),
    BASE_DATA_CATEGORY_INSERT_REPEAT_ERROR("200205","题目类别已存在"),
    BASE_DATA_CATEGORY_DELETE_NOT_EXIST_ERROR("200206","删除的题目类别已经不存在"),
    BASE_DATA_CATEGORY_START_ERROR("200207","启用题目类别失败"),
    BASE_DATA_CATEGORY_STOP_ERROR("200208","停用题目类别失败"),
    BASE_DATA_CATEGORY_INUSE_ERROR("200209","删除的题目类别正在使用"),

    /**
     * 基础数据服务 题型错误
     */
    BASE_DATA_SUBJECT_TYPE_INSERT_ERROR("200301","新增题型失败"),
    BASE_DATA_SUBJECT_TYPE_DELETE_ERROR("200302","删除题型失败"),
    BASE_DATA_SUBJECT_TYPE_UPDATE_ERROR("200303","更新题型失败"),
    BASE_DATA_SUBJECT_TYPE_QUERY_ERROR("200304","查询题型失败"),
    BASE_DATA_SUBJECT_TYPE_REPEAT_ERROR("200305","题型已存在"),
    BASE_DATA_SUBJECT_TYPE_DELETE_NOT_EXIST_ERROR("200306","删除的题型已经不存在"),
    BASE_DATA_SUBJECT_TYPE_START_ERROR("200307","启用题型失败"),
    BASE_DATA_SUBJECT_TYPE_STOP_ERROR("200308","停用题型失败"),
    BASE_DATA_SUBJECT_TYPE_INUSE_ERROR("200309","删除的题型正在使用"),

    /**
     * 基础数据服务 题目错误
     */
    BASE_DATA_SUBJECT_INSERT_ERROR("200401","新增题目失败"),
    BASE_DATA_SUBJECT_DELETE_ERROR("200402","删除题目失败"),
    BASE_DATA_SUBJECT_UPDATE_ERROR("200403","更新题目失败"),
    BASE_DATA_SUBJECT_QUERY_ERROR("200404","查询题目失败"),
    BASE_DATA_SUBJECT_REPEAT_ERROR("200405","题目已存在"),
    BASE_DATA_SUBJECT_DELETE_NOT_EXIST_ERROR("200306","删除的题目已经不存在"),
    BASE_DATA_SUBJECT_START_ERROR("200407","启用题目失败"),
    BASE_DATA_SUBJECT_STOP_ERROR("200408","停用题目失败"),
    BASE_DATA_SUBJECT_INUSE_ERROR("200409","删除的题目正在使用"),

    /**
     * 基础数据服务 组卷配置错误
     */
    BASE_DATA_COMB_INSERT_ERROR("200501","新增组卷配置失败"),
    BASE_DATA_COMB_DELETE_ERROR("200502","删除组卷配置失败"),
    BASE_DATA_COMB_UPDATE_ERROR("200503","更新组卷配置失败"),
    BASE_DATA_COMB_QUERY_ERROR("200504","查询组卷配置失败"),
    BASE_DATA_COMB_REPEAT_ERROR("200505","组卷配置已存在"),
    BASE_DATA_COMB_DELETE_NOT_EXIST_ERROR("200306","删除的组卷配置已经不存在"),
    BASE_DATA_COMB_START_ERROR("200507","启用组卷配置失败"),
    BASE_DATA_COMB_STOP_ERROR("200508","停用组卷配置失败"),
    BASE_DATA_COMB_INUSE_ERROR("200509","删除的组卷配置正在使用"),

    /**
     * 基础数据服务 数据字典错误
     */
    BASE_DATA_DICTIONARY_INSERT_ERROR("200601","新增数据字典失败"),
    BASE_DATA_DICTIONARY_DELETE_ERROR("200602","删除数据字典失败"),
    BASE_DATA_DICTIONARY_UPDATE_ERROR("200603","更新数据字典失败"),
    BASE_DATA_DICTIONARY_QUERY_ERROR("200604","查询数据字典失败"),
    BASE_DATA_DICTIONARY_REPEAT_ERROR("200605", "数据字典已存在"),
    BASE_DATA_DICTIONARY_INUSE_ERROR("200606", "删除的数据字典正在使用"),
    BASE_DATA_DICTIONARY_NOT_EXIST_ERROR("200605", "删除的数据字典已经不存在"),

    /**
     * 系统管理 用户模块异常码
     */
    SYSTEM_MANAGER_USER_REPEAT_ERROR("220501","用户已存在"),
    SYSTEM_MANAGER_USER_INSERT_ERROR("220502","新增用户失败"),
    SYSTEM_MANAGER_USER_DELETE_ERROR("220503","删除用户失败"),
    SYSTEM_MANAGER_USER_UPDATE_ERROR("220504","更新用户失败"),
    SYSTEM_MANAGER_USER_QUERY_ERROR("220505","查询用户失败"),

    /**
     * 系统管理 角色模块异常码
     */
    SYSTEM_MANAGER_ROLE_REPEAT_ERROR("220601","角色已存在"),
    SYSTEM_MANAGER_ROLE_INSERT_ERROR("220602","新增角色失败"),
    SYSTEM_MANAGER_ROLE_DELETE_ERROR("220603","删除角色失败"),
    SYSTEM_MANAGER_ROLE_UPDATE_ERROR("220604","更新角色失败"),
    SYSTEM_MANAGER_ROLE_QUERY_ERROR("220605","查询角色失败"),

    /**
     * 试卷 试卷服务错误
     */
    PAPER_PAPER_INSERT_ERROR("230101", "新增试卷失败"),
    PAPER_SUBJECT_INSERT_ERROR("230102","新增试卷试题失败"),
    PAPER_PAPER_ANSWER_INSERT_ERROR("230103","新增试题答案失败"),
    PAPER_SUBJECT_NOT_FOUND_ERROR("230104","未找到符合条件的题目"),
    PAPER_PAPER_DELETE_ERROR("230105","删除试卷失败"),
    PAPER_PAPER_UPDATE_ERROR("230106","试卷修改失败"),
    PAPER_SUBJECT_UPDATE_ERROR("230107","试卷试题修改失败"),
    PAPER_ANSWER_UPDATE_ERROR("230108","试题答案修改失败"),
    PAPER_QUICK_MAKE_PAPER_ERROR("230109", "快速组卷失败！"),

    /**
     * 试卷 试卷模板服务错误
     */
    PAPER_TEMPLATE_INSERT_ERROR("230201","新增模板记录失败"),
    PAPER_TEMPLATE_SUBJECT_INSERT_ERROR("230202","新增模板试题失败"),
    PAPER_TEMPLATE_ANSWER_INSERT_ERROR("230203","新增模板试题答案失败"),
    PAPER_TEMPLATE_NOT_FOUND_ERROR("230104","未找到符合条件的模板试题"),
    PAPER_TEMPLATE_REPEAT_ERROR("230205","模板名已存在"),

    /**
     * 考试服务
     */
    EXAM_PUBLISH_RECORD_INSERT_RECORD_ERROR("240301","添加考试发布记录失败"),
    EXAM_PUBLISH_RECORD_QUERY_RECORD_ERROR("240302","查询考试发布记录失败"),
    EXAM_PUBLISH_RECORD_UPDATE_RECORD_ERROR("240303","更新考试发布失败"),
    EXAM_PUBLISH_RECORD_DELETE_RECORD_ERROR("240304","删除考试发布记录失败"),
    EXAM_RECORD_INSERT_RECORD_ERROR("240305","新增考试记录失败"),
    EXAM_RECORD_UPDATE_RECORD_ERROR("240306","交卷更新考试记录失败"),
    PUBLISH_DELETE_IS_PUBLISHED("240307", "该场考试已经发布"),
    EXAM_PUBLISH_RECORD_GET_VERSION_FAIL("240308", "获取考试发布记录版本号错误"),
    VERSION_NOT_THE_SAME("240309", "数据版本号不一致"),
    EXAM_PUBLISH_FAIL("240310", "考试发布失败"),
    EXAM_PUBLISHED("240310", "重复发布"),
    PUBLISH_UPDATE_IS_PUBLISHED("240311","已发布"),
    PUBLISH_TABLE_UPDATE_FAILED("240312","发布记录更新失败"),
    EXAM_TMP_ANSWER_GET_FAIL("240313","获取缓存中作答数据失败"),


    EXAM_PEOPLE_REG_FAIL("250301","考生注册失败"),
    EXAM_PEOPLE_NOT_EXIT("250302","登录失败，考生不存在"),
    EXAM_PEOPLE_LOGIN_WITH_PASSWORD_FAIL("250302","考生通过账号密码登录失败"),
    EXAM_PEOPLE_LOGIN_WITH_MSG_SEND_SSM_FAIL("250303", "发送验证码失败"),
    EXAM_RECORD_INSERT_FAIL("250304","考试记录插入失败"),
    EXAM_MARK_PEOPLE_NOT_EXIT("240304", "该场考试没有阅卷官"),
    EXAM_ANSWER_SAVE_FAIL("240305", "考生作答题目记录保存失败"),
    EXAM_SUBMIT_FAIL("240306", "考试提交异常"),
    GET_TMP_ANSWER_FAIL("240307", "获取临时回答保存异常"),
    GET_EXAM_LIMIT_TIME_FAIL("240308","获取考试剩余时间失败"),
    SET_EXAM_LIMIT_TIME_FAIL("240309", "设置考试剩余时间失败"),
    EXAM_RECORD_QUERY_FAIL("240310", "获取考试记录失败"),
    MOBILE_PAPER_NOT_EXIST("250201","考试试卷不存在"),
    EXAM_REPORT_QUERY_FAIL("250202", "考试报表查询失败"),
    EXAM_REPORT_DETAIL_QUERY_FAIL("250203","考试报表详情查询失败"),
    EXAM_EVALUATE_QUERY_FAIL("260201","获取阅卷所需考试记录失败"),
    EXAM_EVALUATE_SET_TMP_MARKING_FAIL("260202","将阅卷的回传结果存储到redis失败"),
    EXAM_EVALUATE_GET_TMP_MARKING_FAIL("260203","从redis中获取阅卷的回传结果失败"),
    MARKING_ANSWER_TABLE_QUERY_FAILED("260204","阅卷状态更新失败")
    ;

    /**
     * 异常码
     */
    private String code;
    /**
     * 异常信息
     */
    private String message;
    BusinessError(String code, String message) {
        this.code = code;
        this.message = message;
    }

}
