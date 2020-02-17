package com.work.framework.biz.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.work.framework.biz.common.exception.BizException;
import com.work.framework.biz.model.TSysUser;
import com.work.framework.biz.model.User;
import com.work.framework.biz.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/user")
    @ApiOperation("insert")
    public void insert(User user) throws BizException {
        userService.insert(user);
    }

    @PostMapping("test/redis")
    @ApiOperation("iiii")
    public void testRedis(){
        userService.testRedis();
    }

    @GetMapping("test/mongodb")
    @ApiOperation("iiii")
    public int testMongo() throws JsonProcessingException {
//        userService.testMongodb();
        return 0;
    }
}
