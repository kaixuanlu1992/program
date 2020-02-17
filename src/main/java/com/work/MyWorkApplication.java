package com.work;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableConfigurationProperties
public class MyWorkApplication {
    public static void main(String[] args){
        args= new String[]{"111","111"};
        SpringApplication app = new SpringApplication(MyWorkApplication.class);
        app.run(args);
    }
}
