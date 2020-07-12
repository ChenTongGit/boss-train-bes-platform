package com.boss.xtrain.permission.api;

import com.boss.xtrain.common.core.http.CommonResponse;
import com.boss.xtrain.common.core.web.controller.CommonCRUDApi;
import com.boss.xtrain.permission.pojo.dto.UserDTO;
import com.boss.xtrain.permission.pojo.query.UserQueryDTO;
import com.boss.xtrain.permission.pojo.vo.UserListVO;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/*
 * @Author  :yushiqian
 * @Date    :15:54 2020/07/09
 * @Description :userapi 接口设计
 * @Version: 1.0
 */
@RequestMapping("/education/bes/v1/user")
public interface UserApi extends CommonCRUDApi<UserDTO,UserQueryDTO,UserListVO> {
    /**
     * 列出所有
     *
     * @param
     * @return CommonResponse<List<PositionListVO>>
     *
     */
    @RequestMapping("/selectAll")
    CommonResponse<List<UserListVO>> selectAllUser();
}
