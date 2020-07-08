package com.boss.xtrain.permission.pojo.query;

import com.boss.xtrain.common.core.pojo.BaseQuery;
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
public class UserOnlineInfoQuery extends BaseQuery {
    private String code;
    private String name;
    private Date onlinTime;
    private Date offlineTime;
}
