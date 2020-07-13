package com.boss.xtrain.basedata.controller;

import com.boss.xtrain.common.core.constant.CommonConstant;
import com.boss.xtrain.common.log.annotation.ApiLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@CrossOrigin
public class LoginController {

    @ApiLog(msg = "test")
    @PostMapping("/login")
    public Map<String,Object> login(){
        Map<String, Object> login = new HashMap<>();
        Map<String, String> data = new HashMap<>();
        data.put("token","admin-token");
        login.put("code",0);
        login.put("data",data);
        return login;
    }

    @ApiLog(msg = "test")
    @GetMapping("/getInfo")
    public Map<String,Object> getInfo(String token){
        log.info(token);
        Map<String,Object> res = new HashMap<>();
        Map<String,Object> role = new HashMap<>();

        role.put("introduction","I am a super administrator");
        role.put("avatar","https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        role.put("name","Super Admin");
        List<String> roles = new ArrayList<>();
        roles.add("admin");
        role.put("roles", roles);

        res.put("code",0);
        res.put("data",role);
        return res;
    }
}
