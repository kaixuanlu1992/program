package com.work.framework.biz.model;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel
public class RolePermission {

    private Long roleId;


    private Long permissionId;
}