package com.boss.xtrain.authentication.service;

import com.boss.xtrain.authentication.dao.TRoleMapper;
import com.boss.xtrain.authentication.dao.TUserMapper;
import com.boss.xtrain.authentication.dao.TUserRoleMapper;
import com.boss.xtrain.authentication.entity.TRole;
import com.boss.xtrain.authentication.entity.TUser;
import com.boss.xtrain.authentication.entity.TUserRole;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Slf4j
@Service("userDetailService")
public class BesUserDetailService implements UserDetailsService {
    @Resource
    private TUserMapper tUserMapper;
    @Resource
    private TUserRoleMapper tUserRoleMapper;
    @Resource
    private TRoleMapper tRoleMapper;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        log.info("save user info name: " + userName);
        Example userExample = new Example(TUser.class);
        userExample.createCriteria().andEqualTo("name", userName);
        List<TUser> tUsers = tUserMapper.selectByExample(userExample);

        tUsers.forEach(tUser -> log.info("name " + tUser.getName() + "pass " + tUser.getPassword()));
        if (tUsers == null || (tUsers != null && tUsers.isEmpty())) {
            log.info("not found user by name");
            throw new UsernameNotFoundException(userName);
        }
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        // 可用性 :true:可用 false:不可用
        boolean enabled = true;
        // 过期性 :true:没过期 false:过期
        boolean accountNonExpired = true;
        // 有效性 :true:凭证有效 false:凭证无效
        boolean credentialsNonExpired = true;
        // 锁定性 :true:未锁定 false:已锁定
        boolean accountNonLocked = true;

        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_ADMIN");
        grantedAuthorities.add(grantedAuthority);
            /*
            Example tUserRoleExample = new Example(TUserRole.class);
            tUserRoleExample.createCriteria().andEqualTo("id", tUsers.get(0).getId());
            List<TUserRole> tUserRoles = tUserRoleMapper.selectByExample(tUsers.get(0).getId());

            for (TUserRole tUserRole : tUserRoles) {
                //角色必须是ROLE_开头，可以在数据库中设置
                TRole tRole = tRoleMapper.selectByPrimaryKey(tUserRole.gettRId());
                GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(tRole.getName());
                grantedAuthorities.add(grantedAuthority);
            }*/
        User user = new User(tUsers.get(0).getName(), tUsers.get(0).getPassword(),
            enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, grantedAuthorities);
        log.info("save user: name->" + user.getUsername() + " pass->" + user.getPassword());
        return user;
    }
}
