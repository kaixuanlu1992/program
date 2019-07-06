package com.work.framework.biz.common.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice

public class MyControllerAdvice {
    /**
     * 全局异常捕捉处理,可以指定包，指定异常类型
     * @param ex
     * @return
     */
//    @ResponseBody
//    @ExceptionHandler(value = Exception.class)
//    public Map exceptionHandler(Exception ex){
//        Map map=new HashMap();
//        map.put("code",1003);
//        map.put("msg",ex.getMessage());
//        return map;
//    }

    /**
     * 把值绑定到Model中，使全局@RequestMapping可以获取到该值
     * @param model
     */
    @ModelAttribute
    public void addAttribute(Model model){
        model.addAttribute("msg","额外信息");
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder){
        webDataBinder.setDisallowedFields("id");
    }
}
