package com.work.base.model;

import com.work.base.annotation.MyAnnotation;
import lombok.Data;

@Data
public class Student {
    @MyAnnotation(name = "kaixuan",value = 27)
    private String name;
}
