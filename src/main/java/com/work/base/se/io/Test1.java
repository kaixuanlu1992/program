package com.work.base.se.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String line = br.readLine();
        String line = "7 5 9 4 2 6 8 3 5 4 3 9";
        String[] in = line.split(" ");
        int[] arr = new int[in.length];
        int i = 0;
        for (String s : in) {
            arr[i++] = Integer.valueOf(s);
        }
        System.out.println(getRs(0, -1, arr));
    }

    private static int getRs(int start, int step, int[] arr) {
        if (start != 0) {
            if (arr[start] + start > arr.length-1) {
                return -1;
            } else if (arr[start] + start == arr.length-1) {
                return step + 1;
            } else {
                return getRs(start + arr[start], step + 1, arr);
            }
        }
        int rs = -1;
        for (int index = 1; index < arr.length / 2; index++) {
            int r = getRs(index, 1, arr);
            if (r == -1) {
                continue;
            }
            if (rs == -1 || (rs != -1 && rs > r)) {
                rs = r;
            }
        }

        return rs;
    }
}
