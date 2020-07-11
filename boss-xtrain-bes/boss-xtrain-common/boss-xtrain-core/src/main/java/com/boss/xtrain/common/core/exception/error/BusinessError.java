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
    BASE_DATA_DICTIONARY_ID_NOT_EXIST_ERROR("200606", "删除的数据字典ID不存在"),

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
     * 考试服务 答题记录异常
     */
    EXAM_RECORD_INSERT_RECORD_ERROR("240301","新增考试记录失败"),
    EXAM_RECORD_UPDATE_RECORD_ERROR("240302","交卷更新考试记录失败");

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
