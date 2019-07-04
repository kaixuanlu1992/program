package com.work.framework.biz.service.impl;

import com.work.framework.biz.dao.TSysUserMapper;
import com.work.framework.biz.model.TSysUser;
import com.work.framework.biz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private TSysUserMapper userMapper;

    @Override
    public int insert(TSysUser user) {
        return userMapper.insert(user);
    }
}
