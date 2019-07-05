package com.work.framework.biz.controller;

import com.work.framework.biz.common.exception.BizException;
import com.work.framework.biz.model.TSysUser;
import com.work.framework.biz.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/user")
    @ApiOperation("iiii")
    public void insert() throws BizException {
        TSysUser tSysUser=new TSysUser();
        tSysUser.setUserName("kjk");
        tSysUser.setPhone("12456");
        userService.insert(tSysUser);
        throw new BizException("biz exception");
    }
}
