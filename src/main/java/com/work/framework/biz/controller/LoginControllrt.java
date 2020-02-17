package com.work.framework.biz.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginControllrt {
    @RequestMapping("/login")
    public boolean login(){
        return false;
    }
}
