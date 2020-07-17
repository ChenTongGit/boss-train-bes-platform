package com.boss.xtrain.authentication.service;

import com.boss.xtrain.common.core.http.CommonResponse;
import com.boss.xtrain.permission.pojo.dto.UserDTO;

public interface UserDaoService {
    UserDTO getUserAllInfo(String userName);
}
