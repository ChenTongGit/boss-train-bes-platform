package com.boss.xtrain.authentication.controller;


import com.boss.xtrain.authentication.feign.PermissonServiceClient;
import com.boss.xtrain.authentication.service.BesUserDetailService;
import com.boss.xtrain.common.core.http.CommonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class UserInfoController {

    @Autowired
    PermissonServiceClient client;
    @Autowired
    private BesUserDetailService userDetailService;
    @Autowired
    private ConsumerTokenServices consumerTokenServices;

    @GetMapping("/userinfo")
    public UserDetails user(String userName) {
        return userDetailService.loadUserByUsername(userName);
    }
}
