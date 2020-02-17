package com.work.framework.biz.model;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel
public class Company {
    private Integer id;
    private String name;
    private String phone;
    private String address;
    private Date openDay;
}
