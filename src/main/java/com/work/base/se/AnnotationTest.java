package com.work.base.se;

import com.work.base.se.annotation.MyAnnotation;
import com.work.base.model.Student;

import java.lang.reflect.Field;

public class AnnotationTest {
    public static void main(String[] args){
        basicTest();
    }
    private static void basicTest(){
        Student student=new Student();
        Class<?> clazz= student.getClass();
        Field[] fields=clazz.getDeclaredFields();
        for (Field field:fields){
            MyAnnotation myAnnotation=field.getAnnotation(MyAnnotation.class);
            if (myAnnotation!=null){
                System.out.println(myAnnotation.name()+"       "+myAnnotation.value());
            }
        }
    }
}
