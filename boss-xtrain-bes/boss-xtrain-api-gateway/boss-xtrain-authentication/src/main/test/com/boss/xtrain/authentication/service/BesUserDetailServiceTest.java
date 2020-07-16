package com.boss.xtrain.authentication.service;

import com.boss.xtrain.authentication.feign.PermissonServiceClient;
import com.boss.xtrain.common.core.http.CommonRequest;
import com.boss.xtrain.common.core.http.CommonResponse;
import com.boss.xtrain.permission.pojo.dto.UserDTO;
import com.boss.xtrain.permission.pojo.query.UserQueryDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
class BesUserDetailServiceTest {

    @Autowired
    PermissonServiceClient permissonServiceClient;

    @Test
    void loadUserByUsername() {
        CommonRequest<UserQueryDTO> userQuery = new CommonRequest<>();
        UserQueryDTO userQueryDTO = new UserQueryDTO();
        userQueryDTO.setName("1111");
        userQuery.setBody(userQueryDTO);

        CommonResponse<UserDTO> result = permissonServiceClient.findUserByName(userQuery);
        log.info(result.toString());
    }
}