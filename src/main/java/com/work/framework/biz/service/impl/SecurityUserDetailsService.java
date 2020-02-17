package com.work.framework.biz.service.impl;

import com.work.framework.biz.controller.vo.SecurityRole;
import com.work.framework.biz.controller.vo.SecurityUser;
import com.work.framework.biz.dao.RoleMapper;
import com.work.framework.biz.dao.UserMapper;
import com.work.framework.biz.dao.UserRoleMapper;
import com.work.framework.biz.model.Role;
import com.work.framework.biz.model.User;
import com.work.framework.biz.model.UserRole;
import com.work.framework.biz.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SecurityUserDetailsService implements UserDetailsService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserRoleMapper userRoleMapper;
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Example example = new Example(User.class);
        example.createCriteria().andEqualTo("username", username);
        User user = userMapper.selectOneByExample(example);
        SecurityUser securityUser =new SecurityUser();
        if (null !=user){
            BeanUtils.copyProperties(user,securityUser);
            Example userRoleExample = new Example(UserRole.class);
            userRoleExample.createCriteria().andEqualTo("userId", user.getId());
            List<UserRole> userRoles = userRoleMapper.selectByExample(userRoleExample);
            if (!CollectionUtils.isEmpty(userRoles)){
                Example roleExample = new Example(Role.class);
                roleExample.createCriteria().andIn("id", userRoles.stream().map(UserRole::getRoleId).collect(Collectors.toList()));
                List<Role> roles = roleMapper.selectByExample(roleExample);
                List<SecurityRole> securityRoles=roles.stream().map(item->new SecurityRole(item.getId(),item.getName())).collect(Collectors.toList());
                securityUser.setAuthoritiesInfo(securityRoles);
            }
        }
        return securityUser;
    }
}
