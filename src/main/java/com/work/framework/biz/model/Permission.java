package com.work.framework.biz.model;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel
public class Permission  {

    private Long id;


    private String url;


    private String name;


    private String description;


    private Long pid;


}