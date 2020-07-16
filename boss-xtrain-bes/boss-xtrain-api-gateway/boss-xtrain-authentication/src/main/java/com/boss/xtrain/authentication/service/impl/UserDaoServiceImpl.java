package com.boss.xtrain.authentication.service.impl;

import com.boss.xtrain.authentication.feign.PermissonServiceClient;
import com.boss.xtrain.authentication.service.UserDaoService;
import com.boss.xtrain.common.core.http.CommonRequest;
import com.boss.xtrain.common.core.http.CommonResponse;
import com.boss.xtrain.permission.pojo.dto.ResourceDTO;
import com.boss.xtrain.permission.pojo.dto.RoleDTO;
import com.boss.xtrain.permission.pojo.dto.UserDTO;
import com.boss.xtrain.permission.pojo.entity.Resource;
import com.boss.xtrain.permission.pojo.query.ResourceQueryDTO;
import com.boss.xtrain.permission.pojo.query.RoleQueryDTO;
import com.boss.xtrain.permission.pojo.query.UserQueryDTO;
import com.boss.xtrain.permission.pojo.vo.ResourceListVO;
import com.boss.xtrain.permission.pojo.vo.RoleListVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

        /*CommonRequest<RoleQueryDTO> roleQuery = new CommonRequest<>();
        RoleQueryDTO roleQueryDTO = new RoleQueryDTO();
        roleQueryDTO.setName(userName);
        roleQuery.setBody(roleQueryDTO);
        CommonResponse<List<RoleListVO>> roles = permissonServiceClient.findRoleByName(roleQuery);*/

        RoleDTO roleDTO = new RoleDTO();
        roleDTO.setName("admin");
        userDTO.setRoleList(new ArrayList<>());
        userDTO.getRoleList().add(roleDTO);

        ResourceDTO resourceDTO = new ResourceDTO();
        resourceDTO.setName("request_url1");
        userDTO.getRoleList().get(0).setResourceList(new ArrayList<>());
        userDTO.getRoleList().get(0).getResourceList().add(resourceDTO);
        /*
        roles.getData().forEach(roleListVO -> {
            CommonRequest<ResourceQueryDTO> resourceQuery = new CommonRequest<>();
            ResourceQueryDTO resourceQueryDTO = new ResourceQueryDTO();
            resourceQueryDTO.setName(roleListVO.getName());
            resourceQuery.setBody(resourceQueryDTO);

            CommonResponse<List<ResourceListVO>> resources = permissonServiceClient.findResourceByName(resourceQuery);
            resources.getData().forEach(resourceListVO -> {
                if (resourceListVO.getResourceType() == 1)
                    roleListVO.getResourceList().add(resourceListVO);
            });
        });
*/
        log.info(userDTO.toString());
        return userDTO;
    }
}
