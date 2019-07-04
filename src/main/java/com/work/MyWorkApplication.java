package com.work;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(scanBasePackages = "com.work.framework.biz")
@EnableSwagger2
public class MyWorkApplication {
    public static void main(String[] args){
        SpringApplication.run(MyWorkApplication.class,args);
    }
}
