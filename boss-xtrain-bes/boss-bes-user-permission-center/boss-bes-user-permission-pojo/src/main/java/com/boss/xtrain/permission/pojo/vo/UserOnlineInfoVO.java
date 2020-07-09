package com.boss.xtrain.permission.pojo.vo;

import com.boss.xtrain.common.core.pojo.BaseVO;
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
public class UserOnlineInfoVO extends BaseVO {
    private Long id;
    private Long userId;
    private String code;
    private String name;
    private String ip;
    private Date onlineTime;
    private Date offlineTime;
    private Integer stopTime;
    private Integer status;
}
