package com.work.framework.biz.service.impl;

import com.work.framework.biz.common.exception.BizException;
import com.work.framework.biz.dao.TSysUserMapper;
import com.work.framework.biz.model.TSysUser;
import com.work.framework.biz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.TimeUnit;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private TSysUserMapper userMapper;
    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    @Transactional(rollbackFor = BizException.class)
    public int insert(TSysUser user) throws BizException {
         userMapper.insert(user);
         throw new BizException("222");
    }

    @Override
    public void testRedis() {
        redisTemplate.opsForValue().set("key1","value1",10l, TimeUnit.SECONDS);
        if(redisTemplate.hasKey("key1")){
            System.out.println(redisTemplate.opsForValue().get("key1"));
        }
    }
}
