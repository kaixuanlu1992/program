package com.work.framework.biz.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.work.framework.biz.common.exception.BizException;
import com.work.framework.biz.model.TSysUser;

public interface UserService {
    int insert(TSysUser user) throws BizException;

    void testRedis();

    void testMongodb() throws JsonProcessingException;
}
