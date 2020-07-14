package com.boss.xtrain.common.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MailBean implements Serializable {
    private static final long serialVersionUID = -9067235624884880600L;
    private String recipient;//邮件接收人
    private String subject; //邮件主题
    private String content;

}
