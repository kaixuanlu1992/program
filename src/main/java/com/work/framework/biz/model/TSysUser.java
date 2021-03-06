package com.work.framework.biz.model;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@ApiModel
@NoArgsConstructor
@AllArgsConstructor
public class TSysUser  {
    private Integer id;
    private String userName;
    private String phone;

    List<TSysRole> roleList;

}