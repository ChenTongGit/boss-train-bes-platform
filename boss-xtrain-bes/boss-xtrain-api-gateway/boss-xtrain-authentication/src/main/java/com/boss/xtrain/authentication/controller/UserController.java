package com.boss.xtrain.authentication.controller;


import com.boss.xtrain.authentication.feign.PermissonServiceClient;
import com.boss.xtrain.authentication.service.BesUserDetailService;
import com.boss.xtrain.common.core.http.CommonResponse;
import com.boss.xtrain.permission.pojo.vo.CompanyVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    PermissonServiceClient client;

    @Autowired
    private BesUserDetailService userDetailService;
    @Autowired
    private ConsumerTokenServices consumerTokenServices;

    @GetMapping("/testFeign")
    public List<CompanyVO> testFeigin(){
        return client.testFeign().getData();
    }

    @GetMapping("/userinfo")
    public UserDetails user(String userName) {
        return userDetailService.loadUserByUsername(userName);
    }

    @DeleteMapping(value = "/exit")
    public CommonResponse<String> revokeToken(String access_token) {
        CommonResponse<String> result = new CommonResponse();
        if (consumerTokenServices.revokeToken(access_token)) {
            result.setData("注销成功");
        } else {
            result.setData("注销失败");
        }
        return result;
    }
}
