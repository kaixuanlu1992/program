package com.work.framework.biz.model;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel
public class Role {

    private Long id;

    private String name;
}