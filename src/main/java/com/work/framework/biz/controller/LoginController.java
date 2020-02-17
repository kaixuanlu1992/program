package com.work.framework.biz.controller;

import com.work.framework.biz.model.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.kafka.common.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@RestController
@Slf4j
public class LoginController {
    @Autowired
    private AuthenticationManager authenticationManager;

    /**
     * 登录接口
     */
//    @PostMapping(value = "/login")
    public String login(@RequestBody User user, HttpServletRequest request) throws IOException {
        String username = user.getUsername();
        String password = user.getPassword();
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(username, password);
        try {
            //使用SpringSecurity拦截登陆请求 进行认证和授权
            Authentication authenticate = authenticationManager.authenticate(usernamePasswordAuthenticationToken);

            SecurityContextHolder.getContext().setAuthentication(authenticate);
            //使用redis session共享
            HttpSession session = request.getSession();
            session.setAttribute("SPRING_SECURITY_CONTEXT", SecurityContextHolder.getContext()); // 这个非常重要，否则验证后将无法登陆
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:login-error?error=2";
        }
        return "登录成功";
    }



}
