package com.work.framework.biz.config;

import com.work.framework.biz.controller.vo.SecurityUser;
import com.work.framework.biz.model.User;
import com.work.framework.biz.service.UserService;
import com.work.framework.biz.service.impl.SecurityUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class LoginValidateAuthenticationProvider implements AuthenticationProvider
{
    @Autowired
    private SecurityUserDetailsService userService;

    //解密用的
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        //获取输入的用户名
        String username = authentication.getName();
        //获取输入的明文
        String rawPassword = (String) authentication.getCredentials();

        //查询用户是否存在
        SecurityUser user = (SecurityUser) userService.loadUserByUsername(username);


        //验证密码
        if (!passwordEncoder.matches(rawPassword, user.getPassword())) {
            throw new BadCredentialsException("输入密码错误!");
        }

        return new UsernamePasswordAuthenticationToken(user, rawPassword, user.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        //确保authentication能转成该类
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
