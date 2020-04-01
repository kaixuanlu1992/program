package com.work.base.se.thread;

import java.util.*;

public class WTT {
    public static void main(String[] args) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        map.put(0, Arrays.asList(1, 2, 3));
        map.put(1, Arrays.asList(3, 4, 18));
        map.put(2, Arrays.asList(5, 6, 7));
        map.put(3, Arrays.asList(8, 9, 10));
        map.put(4, Arrays.asList(18, 19, 110));
        map.put(5, Arrays.asList(18, 129, 1120));
        int[][] data = dataChange(map);
        List<List<Integer>> rs = getGroup(data);
        System.out.println(rs);
    }

    private static int[][] dataChange(Map<Integer, List<Integer>> map) {
        int len = map.size();
        int[][] rs = new int[len][len];
        for (Integer i : map.keySet()) {
            for (Integer j : map.keySet()) {
                if (i == j) {
                    rs[i][i] = 1;
                    continue;
                }
                boolean isMixed = existed(map.get(i), map.get(j));
                rs[i][j] = isMixed ? 1 : 0;
                rs[j][i] = isMixed ? 1 : 0;
            }
        }
        return rs;

    }

    private static boolean existed(List<Integer> integers, List<Integer> integers1) {
        Set<Integer> tt = new HashSet<>();
        tt.addAll(integers);
        tt.addAll(integers1);
        return tt.size() != (integers.size() + integers1.size());
    }

    static List<List<Integer>> getGroup(int[][] data) {
        List<List<Integer>> rs = new ArrayList<>();
//        int[][] data = {{1, 1, 0, 0},
//                {1, 1, 1, 0},
//                {0, 1, 1, 0},
//                {0, 0, 0, 1}};
        List<Integer> grouped = new ArrayList<>();
        for (int i = 0; i < data.length; i++) {
            if (grouped.contains(i)) {
                continue;
            }
            List<Integer> group = new ArrayList<>();
            Set<Integer> set = new HashSet<>();
            getAllGroup(i, data, set);
            group.addAll(set);
            grouped.addAll(set);
            rs.add(group);
        }
        return rs;
    }

    private static void getAllGroup(int index, int[][] data, Set<Integer> rs) {
        rs.add(index);
        for (int i = 0; i < data.length; i++) {
            if (data[index][i] == 1) {
                if (rs.add(i)) {
                    getAllGroup(i, data, rs);
                }
            }
        }
    }
}
