package com.boss.xtrain.authentication.controller;


import com.boss.xtrain.common.core.http.CommonRequest;
import com.boss.xtrain.common.util.JwtUtils;
import org.springframework.web.bind.annotation.*;

/**
 * 包含一些用户信息查询的接口
 *
 * @author lzx
 * @version 1.0.0
 */
@RestController
@RequestMapping("/api")
public class UserInfoController {
    /**
     * 解析token数据并返回
     *
     * @param token jwt
     * @return 解析后的数据
     */
    @GetMapping("/token_parse")
    public String user(@RequestParam CommonRequest<String> token) {
        return JwtUtils.getParseToken(token.getBody());
    }
}
