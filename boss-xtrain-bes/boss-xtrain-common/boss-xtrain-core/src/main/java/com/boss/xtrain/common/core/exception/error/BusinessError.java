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
    UPLOAD_PAPER_ERROR("230201","上传试卷失败，请稍后重试(code:230201)"),
    UPLOAD_NAMEEXIST_ERROR("230202","模板名已存在(code:230202)"),
    UPLOAD_UPDATE_PAPERSTATUS_ERROR("230203","上传试卷失败：更新试卷状态失败(code:230203)"),
    DOWNLOAD_TEMPLATE_ERROR("230301","下载模板失败，请稍后重试(code:230301)"),
    DOWNLOAD_NAMEEXIST_ERROR("230302","试卷名已存在(code:230302)"),
    DOWNLOAD_PUBLISHTIMES_ERROR("230303","下载模板失败：更新模板下载次数失败(code:230303)"),
    MAINTAIN_PAPER_DELETE_ERROR("230401","删除试卷失败(code:230401)"),
    MAINTAIN_PAPER_BATCHDELETE_ERROR("230402","批量删除试卷失败(code:230402)"),
    MAINTAIN_PAPER_UPDATEVERSION_ERROR("230403","更新试卷失败：更新version失败(code:230403)"),
    MAINTAIN_PAPER_UPDATESUBJECTLIST_ERROR("230404","更新试卷失败：更新试卷题目集合失败(code:230404)"),
    MAINTAIN_PAPER_UPDATE_ERROR("230405","更新试卷失败：该试卷已被修改(code:230405)"),
    MAINTAIN_PAPER_UPDATEINFO_ERROR("230406","更新试卷失败：更新试卷信息失败(code:230406)"),
    MAINTAIN_PAPER_UPDATEANSWERLIST_ERROR("230408","更新试卷失败：更新试卷答案集合失败(code:230408)"),
    MAINTAIN_PAPER_DELETEFAIL_ERROR("230409","删除失败：试卷正在被使用(code:230409)"),
    MAINTAIN_PAPER_EDITFAIL_ERROR("2304010","修改失败：试卷正在被使用(code:230410)"),
    MAINTAIN_TEMPLATE_DELETE_ERROR("230501","删除模板失败(code:230501)"),
    MAINTAIN_TEMPLATE_BATCHDELETE_ERROR("230502","批量删除模板失败(code:230502)"),
    MAINTAIN_TEMPLATE_UPDATEVERSION_ERROR("230503","更新模板失败：更新version失败(code:230503)"),
    MAINTAIN_TEMPLATE_UPDATESUBJECTLIST_ERROR("230504","更新模板失败：更新模板题目集合失败(code:230504)"),
    MAINTAIN_TEMPLATE_UPDATE_ERROR("230505","更新模板失败：该模板已被修改(code:230505)"),
    MAINTAIN_TEMPLATE_UPDATEINFO_ERROR("230506","更新模板失败：更新模板信息失败(code:230506)"),
    MAINTAIN_TEMPLATE_UPDATEANSWERLIST_ERROR("230508","更新模板失败：更新模板答案集合失败(code:230508)"),
    COMBEXAM_DOWNLOADTEMPLATE_ERROR("230602","下载模板失败(code:230602)"),
    COMBEXAM_UPDATE_PUBLISHTIMES_ERROR("230603","下载模板失败：更新模板下载次数失败(code:230603)"),
    COMBEXAM_SUBJECT_TOOMUCH_ERROR("230605","组卷失败：设置题数大于题库题数(code:230605)"),
    COMBEXAM_ERROR("230606","组卷失败，请稍后重试(code:230606)"),
    COMBEXAM_KEEPITEMS_ERROR("230607","保存配置明细失败，请重试(code:230607)"),
    COMBEXAM_PAPER_NAMEEXIST_ERROR("230608","试卷名已存在(code:230608)"),
    COMBEXAM_TEMPLATE_NAMEEXIST_ERROR("230609","模板名已存在(code:230609)"),


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
    VERSION_NOT_THE_SAME("240309", "数据版本号不一致")
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
