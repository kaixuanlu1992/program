package com.work.base.leetcode;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import java.util.*;

public class Group {
    public static void main(String[] args) {
        List<Integer> l1 = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> l2 = Arrays.asList(4, 5, 6, 7, 8, 9);
        List<Integer> l3 = Arrays.asList(11, 12, 13, 14, 15, 16);
        List<Integer> l4 = Arrays.asList(11, 12, 23, 24, 25, 26);
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(l1);
        lists.add(l2);
        lists.add(l3);
        lists.add(l4);

        Set<Set<Integer>> rs = getGroup(lists);
        List<List<Integer>> lists1 = new ArrayList<>();
        for (Set<Integer> set : rs) {
            List<Integer> item = new ArrayList<>();
            for (Integer index : set) {
                item.addAll(lists.get(index));
            }
            lists1.add(item);
        }
        System.out.println(lists1);
    }

    private static Set<Set<Integer>> getGroup(List<List<Integer>> lists) {
        Set<Set<Integer>> rs = new HashSet<>();
        int len = lists.size();
        int[][] temp = new int[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                temp[i][j] = existMixed(lists.get(i), lists.get(j));
            }
        }
        changeTemp(temp);
        Set<Integer> allData = new HashSet<>();
        for (int i = 0; i < len; i++) {
            Set<Integer> list = new HashSet<>();
            if (allData.contains(i)) {
                continue;
            }
            Set<Integer> s = new HashSet<>();
            s.add(i);
            getAllMixed(i, temp, s);
            allData.addAll(s);
            list.addAll(s);
            rs.add(list);
        }
        return rs;
    }

    private static void changeTemp(int[][] temp) {
        int len = temp.length;
        for (int i = len - 2; i > 1; i--) {
            for (int j = i + 1; j > i; j--) {
                if (temp[i][j]==1){

                }
            }
        }
    }

    private static void getAllMixed(int index, int[][] temp, Set<Integer> rs) {
        int len = temp.length;
        for (int i = index; i < len; i++) {
            if (temp[index][i] == 1) {
                rs.add(i);
            }
        }
    }

    /**
     * 判断是否存在交集
     *
     * @param integers
     * @param integers1
     * @return
     */
    private static int existMixed(List<Integer> integers, List<Integer> integers1) {
        Set<Integer> rs = new HashSet<>();
        rs.addAll(integers);
        rs.addAll(integers1);
        return rs.size() == integers.size() + integers1.size() ? 0 : 1;
    }


}
