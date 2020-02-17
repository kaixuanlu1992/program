package com.work;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class RunAfterApplication implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("---------程序启动之后执行-------------");
        System.out.println(Arrays.toString(args));
    }
}
