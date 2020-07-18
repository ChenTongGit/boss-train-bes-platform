package com.boss.xtrain.authentication.service;

import com.boss.xtrain.authentication.feign.PermissonServiceClient;
import com.boss.xtrain.common.core.http.CommonRequest;
import com.boss.xtrain.common.core.http.CommonResponse;
import com.boss.xtrain.permission.pojo.dto.UserDTO;
import com.boss.xtrain.permission.pojo.query.UserQueryDTO;
import com.boss.xtrain.permission.pojo.vo.ResourceListVO;
import com.boss.xtrain.permission.pojo.vo.RoleListVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
class BesUserDetailServiceTest {

    @Autowired
    PermissonServiceClient permissonServiceClient;

    @Test
    void loadRoleByUsername() {
        CommonRequest<UserQueryDTO> userQuery = new CommonRequest<>();
        UserQueryDTO userQueryDTO = new UserQueryDTO();
        userQueryDTO.setName("1111");
        userQuery.setBody(userQueryDTO);

        List<RoleListVO> result = permissonServiceClient.findRoleByName(userQuery).getData();
        log.info(result.toString());
    }

    @Test
    void loadUserByUsername() {
        CommonRequest<UserQueryDTO> userQuery = new CommonRequest<>();
        UserQueryDTO userQueryDTO = new UserQueryDTO();
        userQueryDTO.setName("1111");
        userQuery.setBody(userQueryDTO);

        UserDTO result = permissonServiceClient.findUserByName(userQuery).getData();
        log.info(result.toString());
    }

    /*@Test
    void loadResourceByUsername() {
        CommonRequest<UserQueryDTO> userQuery = new CommonRequest<>();
        UserQueryDTO userQueryDTO = new UserQueryDTO();
        userQueryDTO.setName("1111");
        userQuery.setBody(userQueryDTO);

        List<ResourceListVO> result = permissonServiceClient.findResourceByName(userQuery).getData();
        log.info(result.toString());
    }*/
}