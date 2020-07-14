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
     * 系统管理 资源模块异常码
     * 系统管理 组织机构异常码
     */
    SYSTEM_MANAGER_ORGANIZATION_REPEAT_ERROR("220101","组织机构已存在"),
    SYSTEM_MANAGER_ORGANIZATION_INSERT_ERROR("220102","新增组织机构失败"),
    SYSTEM_MANAGER_ORGANIZATION_DELETE_ERROR("220103","删除组织机构失败"),
    SYSTEM_MANAGER_ORGANIZATION_UPDATE_ERROR("220104","更新组织机构失败"),
    SYSTEM_MANAGER_ORGANIZATION_QUERY_ERROR("220105","查询组织机构失败"),
    SYSTEM_MANAGER_ORGANIZATION_USED_ERROR("220106","组织机构已被使用"),
    SYSTEM_MANAGER_ORGANIZATION_NOTIN_ERROR("220107","组织机构不存在"),

    /**
     * 系统管理 公司 异常码
     */
    SYSTEM_MANAGER_RESOURCE_IN_USE("220406","该资源正在使用，无法编辑"),
    SYSTEM_MANAGER_RESOURCE_NOT_EXIST_ERROR("220407","该资源不存在"),
    SYSTEM_MANAGER_RESOURCE_LOAD_RESOURCE_ERROR("220408","获取角色资源表失败"),
    SYSTEM_MANAGER_COMPANY_REPEAT_ERROR("220201","公司已存在"),
    SYSTEM_MANAGER_COMPANY_INSERT_ERROR("220202","新增公司失败"),
    SYSTEM_MANAGER_COMPANY_DELETE_ERROR("220203","删除公司失败"),
    SYSTEM_MANAGER_COMPANY_UPDATE_ERROR("220204","更新公司失败"),
    SYSTEM_MANAGER_COMPANY_QUERY_ERROR("220205","查询公司失败"),
    SYSTEM_MANAGER_COMPANY_USED_ERROR("220206","公司已被使用"),
    SYSTEM_MANAGER_COMPANY_NOTIN_ERROR("220207","公司不存在"),

    /**
     * 系统管理 部门 异常码
     */
    SYSTEM_MANAGER_DEPARTMENT_REPEAT_ERROR("220301","部门已存在"),
    SYSTEM_MANAGER_DEPARTMENT_INSERT_ERROR("220302","新增部门失败"),
    SYSTEM_MANAGER_DEPARTMENT_DELETE_ERROR("220303","删除部门失败"),
    SYSTEM_MANAGER_DEPARTMENT_UPDATE_ERROR("220304","更新部门失败"),
    SYSTEM_MANAGER_DEPARTMENT_QUERY_ERROR("220305","查询部门失败"),
    SYSTEM_MANAGER_DEPARTMENT_USED_ERROR("220306","部门已被使用"),
    SYSTEM_MANAGER_DEPARTMENT_NOTIN_ERROR("220307","部门不存在用"),

    /**
     * 系统管理 资源模块异常码
     */
    SYSTEM_MANAGER_RESOURCE_REPEAT_ERROR("220401","资源已存在"),
    SYSTEM_MANAGER_RESOURCE_INSERT_ERROR("220402","新增资源失败"),
    SYSTEM_MANAGER_RESOURCE_DELETE_ERROR("220403","删除资源失败"),
    SYSTEM_MANAGER_RESOURCE_UPDATE_ERROR("220404","更新资源失败"),
    SYSTEM_MANAGER_RESOURCE_QUERY_ERROR("220405","查询资源失败"),

    /**
     * 系统管理 角色模块异常码
     */
    SYSTEM_MANAGER_ROLE_REPEAT_ERROR("220501","角色已存在"),
    SYSTEM_MANAGER_ROLE_INSERT_ERROR("220502","新增角色失败"),
    SYSTEM_MANAGER_ROLE_DELETE_ERROR("220503","删除角色失败"),
    SYSTEM_MANAGER_ROLE_UPDATE_ERROR("220504","更新角色失败"),
    SYSTEM_MANAGER_ROLE_QUERY_ERROR("220505","查询角色失败"),
    SYSTEM_MANAGER_ROLE_IN_USE("220506","该角色正在使用，无法编辑"),
    SYSTEM_MANAGER_ROLE_NOT_EXIST_ERROR("220507","该角色不存在"),
    SYSTEM_MANAGER_ROLE_ALLOCATE_RESOURCE_ERROR("220508","角色分配资源失败"),
    SYSTEM_MANAGER_ROLE_ALLOCATE_USER_ERROR("220507","角色分配用户失败"),

    /**
     * 系统管理 职位模块异常码
     */
    SYSTEM_MANAGER_POSITION_REPEAT_ERROR("220601","职位已存在"),
    SYSTEM_MANAGER_POSITION_INSERT_ERROR("220602","新增职位失败"),
    SYSTEM_MANAGER_POSITION_DELETE_ERROR("220603","删除职位失败"),
    SYSTEM_MANAGER_POSITION_UPDATE_ERROR("220604","更新职位失败"),
    SYSTEM_MANAGER_POSITION_QUERY_ERROR("220605","查询职位失败"),
    SYSTEM_MANAGER_POSITION_IN_USE("220606","该职位正在使用，无法编辑"),
    SYSTEM_MANAGER_POSITION_NOT_EXIST_ERROR("220607","该职位不存在"),

    /**
     * 系统管理 用户模块异常码
     */
    SYSTEM_MANAGER_USER_REPEAT_ERROR("220701","用户已存在"),
    SYSTEM_MANAGER_USER_INSERT_ERROR("220702","新增用户失败"),
    SYSTEM_MANAGER_USER_DELETE_ERROR("220703","删除用户失败"),
    SYSTEM_MANAGER_USER_UPDATE_ERROR("220704","更新用户失败"),
    SYSTEM_MANAGER_USER_QUERY_ERROR("220705","查询用户失败"),
    SYSTEM_MANAGER_USER_IN_USE("220706","该用户正在使用，无法编辑"),
    SYSTEM_MANAGER_USER_NOT_EXIST_ERROR("220707","该用户不存在"),

    /**
     * 系统管理 系统参数模块异常码
     */
    SYSTEM_MANAGER_PARAM_REPEAT_ERROR("220801","系统参数已存在"),
    SYSTEM_MANAGER_PARAM_INSERT_ERROR("220802","新增系统参数失败"),
    SYSTEM_MANAGER_PARAM_DELETE_ERROR("220803","删除系统参数失败"),
    SYSTEM_MANAGER_PARAM_UPDATE_ERROR("220804","更新系统参数失败"),
    SYSTEM_MANAGER_PARAM_QUERY_ERROR("220805","查询系统参数失败"),
    SYSTEM_MANAGER_PARAM_NOTIN_ERROR("220806","系统参数不存在"),
    SYSTEM_MANAGER_PARAM_USED_ERROR("220807","系统参数是启用状态，不可删除"),

    /**
     * 系统管理 在线用户管理模块异常码
     */
    SYSTEM_MANAGER_ONLINE_REPEAT_ERROR("220901","在线用户信息已存在"),
    SYSTEM_MANAGER_ONLINE_INSERT_ERROR("220902","新增在线用户信息失败"),
    SYSTEM_MANAGER_ONLINE_DELETE_ERROR("220903","删除在线用户信息失败"),
    SYSTEM_MANAGER_ONLINE_UPDATE_ERROR("220904","更新在线用户信息失败"),
    SYSTEM_MANAGER_ONLINE_QUERY_ERROR("220905","查询在线用户信息失败"),
    SYSTEM_MANAGER_ONLINE_ISOFFLINE_ERROR("220906","用户已经不在线上"),
    SYSTEM_MANAGER_ONLINE_ISONLINE_ERROR("220907","用户还在线上，数据不能删除"),


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
    EXAM_RECORD_QUERY_FAIL("240310", "获取考试记录失败");

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
