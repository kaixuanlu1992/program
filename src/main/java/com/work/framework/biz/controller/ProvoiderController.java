package com.work.framework.biz.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProvoiderController {
    @GetMapping("/hello")
   public String test(){
        return "hello study";
    }
}
