package com.boss.xtrain.authentication.service.impl;

import com.boss.xtrain.authentication.feign.PermissonServiceClient;
import com.boss.xtrain.authentication.service.UserDaoService;
import com.boss.xtrain.common.core.http.CommonRequest;
import com.boss.xtrain.common.core.http.CommonResponse;
import com.boss.xtrain.common.util.PojoUtils;
import com.boss.xtrain.permission.pojo.dto.ResourceDTO;
import com.boss.xtrain.permission.pojo.dto.RoleDTO;
import com.boss.xtrain.permission.pojo.dto.UserDTO;
import com.boss.xtrain.permission.pojo.query.RoleQueryDTO;
import com.boss.xtrain.permission.pojo.query.UserQueryDTO;
import com.boss.xtrain.permission.pojo.vo.ResourceListVO;
import com.boss.xtrain.permission.pojo.vo.RoleListVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * 远程调用系统管理服务
 *
 * @author lzx
 * @version 1.0.0
 */
@Slf4j
@Service("userDaoService")
public class UserDaoServiceImpl implements UserDaoService {

    @Autowired
    PermissonServiceClient permissonServiceClient;

    /**
     * 获取所有的用户信息
     * @param userName 用户名
     * @return 返回结果
     */
    @Override
    public UserDTO getUserAllInfo(String userName) {
        CommonRequest<UserQueryDTO> userQuery = new CommonRequest<>();
        UserQueryDTO userQueryDTO = new UserQueryDTO();
        userQueryDTO.setName(userName);
        userQuery.setBody(userQueryDTO);
        log.info(userQueryDTO.toString());
        CommonResponse<UserDTO> user = permissonServiceClient.findUserByName(userQuery);
        log.info(user.toString());
        UserDTO userDTO = user.getData();

        CommonResponse<List<RoleListVO>> roles = permissonServiceClient.findRoleByName(userQuery);
        List<RoleDTO> roleDTOs = PojoUtils.copyListProperties(roles.getData(), RoleDTO::new);

        userDTO.setRoleList(roleDTOs);
        userDTO.getRoleList().forEach(roleDTO -> {
            CommonRequest<RoleQueryDTO> roleQuery = new CommonRequest<>();
            RoleQueryDTO roleQueryDTO = new RoleQueryDTO();
            roleQueryDTO.setId(roleDTO.getId());
            roleQuery.setBody(roleQueryDTO);
            List<ResourceListVO> resources = permissonServiceClient.findResourceByName(roleQuery).getData();

            List<ResourceDTO> resourceDTOs = PojoUtils.copyListProperties(resources, ResourceDTO::new);
            roleDTO.setResourceList(resourceDTOs);
        });
        return userDTO;
    }
}
