package com.boss.xtrain.authentication.controller;


import com.boss.xtrain.authentication.feign.PermissonServiceClient;
import com.boss.xtrain.authentication.service.BesUserDetailService;
import com.boss.xtrain.common.core.aspect.EntityFields;
import com.boss.xtrain.common.core.http.CommonResponse;
import com.boss.xtrain.common.util.JwtUtils;
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

    @GetMapping("/testJwtUtils")
    public EntityFields testJwtUtils(){
        EntityFields result = JwtUtils.getInfoFromToken("eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJkZXBhcnRtZW50TmFtZSI6InJlbnppIiwidXNlcl9uYW1lIjoibGlsZWkiLCJjb21wYW55TmFtZSI6InRyeTExMSIsImRlcGFydG1lbnRJZCI6MSwiYXV0aG9yaXRpZXMiOlt7ImF1dGhvcml0eSI6IlJPTEVfQURNSU4ifSx7ImF1dGhvcml0eSI6IuaMiemSrui1hOa6kCJ9XSwiY2xpZW50X2lkIjoiYmVzIiwib3JnYW5pemF0aW9uSWQiOjEyODI1MDg2NzI3MzU0OTQxNDQsImNvbXBhbnlJZCI6MTI4MzIwNTg5NjE0MjQ0NjU5Miwic2NvcGUiOlsicmVhZCJdLCJpZCI6MTExMSwiZXhwIjoxNTk1MTQ3Njg4LCJqdGkiOiI4ZDA4NDEyYy03YzRiLTQ5YTMtYTExNy1iNzI0YWE3NjBlMjMiLCJ1c2VybmFtZSI6ImxpbGVpIn0.i3ZzWAtGi3hkwKGPG-4ZqetBt3FzLeljQ32ANzpszqBNW_e6gV6x_Lvd3eDnyurjEgDRha-wFN3SskGurIAzgGgwowIdR4YJInE-djAOQ9K0F1Tu5hNa5XO9SajPYPBRZZS7FiY81obxqTmS6CLArdN3zBUCnvSi4EFDBABTBsHGyKZ7myhflVhIGW3l-_6c7oDTVUX6V0lUhwvijdeC4ZMVc2y8wbHp9VpG2K0qZpq_-WGEvUMPIHDHljrjPVSZS3JbzPq0pRyOXKJ22nBQtxKyZmjdIevhKSQNQ2Jotf23zPU-0kQMjchWekXf5JoJsASqZLmtXzhodGpzfv7l4Q");
        return result;
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
