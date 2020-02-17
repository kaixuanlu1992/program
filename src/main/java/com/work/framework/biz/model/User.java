package com.work.framework.biz.model;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel
public class User {
    private Long id;

    private String username;

    private String password;


}