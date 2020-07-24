package com.boss.xtrain.authentication.service;

import com.boss.xtrain.authentication.jwt.UserJwt;
import com.boss.xtrain.permission.pojo.dto.RoleDTO;
import com.boss.xtrain.permission.pojo.dto.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 自定义UserDetailsService，以实现业务
 *
 * @author lzx
 * @date 2020.07.15
 */
@Slf4j
@Service("userDetailService")
public class BesUserDetailService implements UserDetailsService {

    @Autowired
    ClientDetailsService clientDetailsService;

    @Qualifier("userDaoService")
    @Autowired
    UserDaoService userDaoService;
/**
 * 定义异常类型，拒绝访问异常
 *
 * @author lzx
 * @version 1.0.0
 */
    /**
     * 通过用户名加载信息
     * @param userName 用户名
     * @return 返回查找到的 UserDetails
     * @throws UsernameNotFoundException 返回找不到用户错误
     */
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        log.info("save user info name: " + userName);
        if (StringUtils.isEmpty(userName)) {
            return null;
        }
        UserDTO userDTO = userDaoService.getUserAllInfo(userName);
        log.info(userDTO.toString());

        List<String> permission = new ArrayList<>();
        List<RoleDTO> roles = userDTO.getRoleList();
        if (roles != null) {
            roles.forEach(roleDTO -> {
                permission.add("ROLE_" + roleDTO.getName());
                if (roleDTO.getResourceList() != null) {
                    roleDTO.getResourceList().forEach(resourceDTO -> permission.add(resourceDTO.getName()));
                }
            });
        }

        String userPermissionStr  = StringUtils.join(permission.toArray(), ",");
        userPermissionStr += ", ";
        UserJwt userDetails = new UserJwt(userName,
            userDTO.getPassword(),
            AuthorityUtils.commaSeparatedStringToAuthorityList(userPermissionStr));
        userDetails.setId(userDTO.getId());
        userDetails.setCompanyName(userDTO.getCompanyName());
        userDetails.setDepartmentName(userDTO.getDepartmentName());
        userDetails.setPositionName(userDTO.getPositionName());
        userDetails.setCompanyId(userDTO.getCompanyId());
        userDetails.setDepartmentId(userDTO.getDepartmentId());
        userDetails.setOrganizationId(userDTO.getOrganizationId());
        log.info(userDetails.getPassword());
        return userDetails;
    }
}