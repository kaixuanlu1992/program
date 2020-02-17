package com.work.framework.biz.controller;

import com.work.framework.biz.common.exception.BizException;
import com.work.framework.biz.config.ConfiProperty;
import com.work.framework.biz.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping(value = "/mvc/test")
public class MvcController {
    @Autowired
    private ApplicationArguments applicationArguments;
    @Autowired
    private ConfiProperty confiProperty;
    @GetMapping("")
    public String test(){
        return "test";
    }
    @GetMapping("/exception")
    public String throwException() throws BizException {
        throw new BizException("exception occur");
    }

    @PutMapping("/converter")
    public String converter(@RequestBody Employee employee){
        return employee.toString();
    }

    @PutMapping("/converter1")
    public String converter1(Date date){
        System.out.println(applicationArguments.getNonOptionArgs());
        System.out.println(confiProperty.getServers());
        return "tt";
    }
}
