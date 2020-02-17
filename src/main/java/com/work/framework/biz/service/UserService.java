package com.work.framework.biz.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.work.framework.biz.common.exception.BizException;
import com.work.framework.biz.model.TSysUser;
import com.work.framework.biz.model.User;

public interface UserService {
    int insert(User user) throws BizException;

    void testRedis();

//    void testMongodb() throws JsonProcessingException;
    TSysUser getUserByName(String userName);

}
