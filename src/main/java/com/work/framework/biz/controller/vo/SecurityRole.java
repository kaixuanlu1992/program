package com.work.framework.biz.controller.vo;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

@ApiModel
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SecurityRole implements GrantedAuthority {

    private Long id;

    private String name;

    @Override
    public String getAuthority() {
        return name;
    }
}
