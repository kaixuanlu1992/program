package com.work.framework.biz.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.work.framework.biz.common.exception.BizException;
import com.work.framework.biz.dao.TSysUserMapper;
import com.work.framework.biz.dao.UserMapper;
import com.work.framework.biz.model.TSysRole;
import com.work.framework.biz.model.TSysUser;
import com.work.framework.biz.model.User;
import com.work.framework.biz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;



@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private UserMapper userMapper;

    @Override
    @Transactional(rollbackFor = BizException.class)
    public int insert(User user) throws BizException {
        return userMapper.insert(user);
    }

    @Override
    public void testRedis() {
        redisTemplate.opsForValue().set("key1", "value1", 10l, TimeUnit.SECONDS);
        if (redisTemplate.hasKey("key1")) {
            System.out.println(redisTemplate.opsForValue().get("key1"));
        }
    }

    @Override
    public TSysUser getUserByName(String userName) {
        List<TSysUser> list = new ArrayList<>();
        list.add(new TSysUser(1, "kaixuan", "15611111111", Arrays.asList(new TSysRole(1, "admin"))));
        list.add(new TSysUser(1, "tingting", "15611111112", Arrays.asList(new TSysRole(1, "admin"))));
        list.add(new TSysUser(1, "tony", "15611111113", Arrays.asList(new TSysRole(1, "admin"))));
        list.add(new TSysUser(1, "jack", "15611111114", Arrays.asList(new TSysRole(1, "admin"))));
        Map<String, TSysUser> map = list.stream().collect(Collectors.toMap(TSysUser::getUserName, t -> t));
        return map.get(userName);
    }

}
