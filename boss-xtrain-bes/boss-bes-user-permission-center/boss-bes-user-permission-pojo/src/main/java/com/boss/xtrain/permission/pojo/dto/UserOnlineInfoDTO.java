package com.boss.xtrain.permission.pojo.dto;

import com.boss.xtrain.common.core.pojo.BaseDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.util.Date;

/**
 * @author 53534秦昀清
 * @date 2020.07.06
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserOnlineInfoDTO extends BaseDTO {
    private Long id;
    private Long userId;
    private String code;
    private String name;
    private String ip;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date onlineTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date offlineTime;
    private Integer stopTime;
    private Integer status;
    private Long version;
}
