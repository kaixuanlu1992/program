package com.work.framework.biz.service.impl;

import com.work.framework.biz.dao.PermissionMapper;
import com.work.framework.biz.dao.RoleMapper;
import com.work.framework.biz.dao.RolePermissionMapper;
import com.work.framework.biz.model.RolePermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

@Service
public class MyInvocationSecurityMetadataSourceService implements FilterInvocationSecurityMetadataSource {
    @Autowired
    private PermissionMapper permissionMapper;
    @Autowired
    private RolePermissionMapper rolePermissionMapper;
    @Autowired
    private RoleMapper roleMapper;

    private static HashMap<String, List<ConfigAttribute>> map;

    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        if (null == map){
            loadResourceDefine();
        }
        HttpServletRequest request = ((FilterInvocation) object).getHttpRequest();
        for (String url : map.keySet()){
            if (new AntPathRequestMatcher( url ).matches( request )) {
                return map.get( url );
            }
        }
        return null;
    }

    private void loadResourceDefine() {
        map = new HashMap<>(16);
        List<RolePermission> rolePermissions = rolePermissionMapper.selectAll();
        for (RolePermission rolePermission : rolePermissions) {
            String url = permissionMapper.selectByPrimaryKey(rolePermission.getPermissionId()).getUrl();
            String roleName = roleMapper.selectByPrimaryKey(rolePermission.getRoleId()).getName();
            ConfigAttribute role = new SecurityConfig(roleName);
            if(map.containsKey(url)){
                map.get(url).add(role);
            }else{
                List<ConfigAttribute> list =  new ArrayList<>();
                list.add( role );
                map.put( url , list );
            }
        }
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }
}
