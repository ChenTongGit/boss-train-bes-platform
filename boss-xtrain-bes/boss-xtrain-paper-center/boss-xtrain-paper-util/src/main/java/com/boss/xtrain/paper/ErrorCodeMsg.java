package com.boss.xtrain.paper;

/**
 * @author lenovo
 */

public enum ErrorCodeMsg {
    /**
     * 异常信息定义
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
    COMBEXAM_TEMPLATE_NAMEEXIST_ERROR("230609","模板名已存在(code:230609)");
    private String code;
    private String msg;
    ErrorCodeMsg(String code,String msg) {
        this.code=code;
        this.msg=msg;
    }
    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}


