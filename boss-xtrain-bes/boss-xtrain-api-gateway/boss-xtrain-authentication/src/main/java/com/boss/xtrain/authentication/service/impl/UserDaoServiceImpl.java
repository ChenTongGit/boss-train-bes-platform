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

@Slf4j
@Service("userDaoService")
public class UserDaoServiceImpl implements UserDaoService {

    @Autowired
    PermissonServiceClient permissonServiceClient;

    @Override
    public UserDTO getUserAllInfo(String userName) {
        CommonRequest<UserQueryDTO> userQuery = new CommonRequest<>();
        UserQueryDTO userQueryDTO = new UserQueryDTO();
        userQueryDTO.setName(userName);
        userQuery.setBody(userQueryDTO);
        CommonResponse<UserDTO> user = permissonServiceClient.findUserByName(userQuery);
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
