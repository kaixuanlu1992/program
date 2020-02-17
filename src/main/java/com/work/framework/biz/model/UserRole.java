package com.work.framework.biz.model;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@ApiModel
@Data
public class UserRole {

    private Long userId;


    private Long roleId;

}