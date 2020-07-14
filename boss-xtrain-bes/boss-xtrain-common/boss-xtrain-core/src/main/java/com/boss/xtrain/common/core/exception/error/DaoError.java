package com.boss.xtrain.common.core.exception.error;

import lombok.Getter;

/**
 * dao层操作错误码
 * @author ChenTong
 * @version 1.0
 * @date 2020/7/9 7:58
 * @copyright
 * @modified
 * @see
 * @since
 **/
@Getter
public enum DaoError {
    INSERT_WITH_VERSION_ERROR("320001", "带版本添加失败"),
    DELETE_WITH_VERSION_ERROR("320002", "带版本删除失败"),
    UPDATE_WITH_VERSION_ERROR("320003", "带版本更新失败");

    private String code;
    private String message;
    DaoError(String code, String msg){
        this.code= code;
        this.message = msg;
    }
}
