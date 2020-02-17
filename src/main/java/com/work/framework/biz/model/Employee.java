package com.work.framework.biz.model;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel
public class Employee {
    private Integer id;
    private String name;
    private Integer age;
    private Company company;

    public String toString(){
        return name + ":" + age;
    }
}
