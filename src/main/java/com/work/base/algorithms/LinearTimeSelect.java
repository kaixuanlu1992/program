package com.work.base.algorithms;

public class LinearTimeSelect {
    public static void main(String[] args) {
        int[] data = {1, 2, 3, 4, 9, 8, 7, 6, 5, 11, 23, 55, 33, 21, 77, 68, 88, 94, 12, 13, 17, 81, 82, 83};
        int rs = quickSelect(data, 0, data.length - 1, data.length - 1);
        System.out.println(rs);
    }

    private static int quickSelect(int[] data, int start, int end, int target) {
        if (data.length == 1) {
            return data[0];
        } else {
            int r = partion(data, start, end);
            if (r > target) {
                return quickSelect(data, start, r - 1, target);
            } else if (r < target) {
                return quickSelect(data, r + 1, end, target);
            } else {
                return data[r];
            }
        }
    }

        /**
         * 分割数组
         *
         * @param data
         * @param start
         * @param end
         * @return
         */

    private static int partion(int[] data, int start, int end) {
        int j = start;
        for (int i = start; i < end; i++) {
            if (data[i] < data[end]) {
                swap(data, i, j);
                j++;
            }
        }
        swap(data, end, j);
        return j;
    }

    /**
     * 交换数组位置
     *
     * @param data
     * @param i
     * @param j
     */
    private static void swap(int[] data, int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }
}

