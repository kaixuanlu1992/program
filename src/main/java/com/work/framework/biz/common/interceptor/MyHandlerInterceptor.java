package com.work.framework.biz.common.interceptor;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

public class MyHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
//        System.out.println("开始时间"+DateFormatUtils.format(new Date(),"yyyy-MM-dd HH:mm:ss"));
        httpServletRequest.setAttribute("startTime",System.currentTimeMillis());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
//       / System.out.println("结束时间"+DateFormatUtils.format(new Date(),"yyyy-MM-dd HH:mm:ss"));
        Long time=System.currentTimeMillis()-(Long)httpServletRequest.getAttribute("startTime");
//        System.out.println("处理时间"+time);
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
