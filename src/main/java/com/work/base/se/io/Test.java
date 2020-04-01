package com.work.base.se.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String pre = line.split(",")[0];
        String sur = line.split(",")[1];
        if (!pre.startsWith("/")) {
            pre = "/" + pre;
        }
        if (pre.endsWith("/") && sur.startsWith("/")) {
            System.out.println(pre + sur.substring(1, sur.length()));
        } else if (!pre.endsWith("/") && !sur.startsWith("/")) {
            System.out.println(pre + "/" + sur);
        } else {
            System.out.println(pre + sur);
        }


    }
}
