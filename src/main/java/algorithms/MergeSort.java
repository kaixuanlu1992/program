package algorithms;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] data = {111, 2, 4, 64, 3, 6, 7, 8, 9, 12, 34, 55, 66, 73, 98, 58};
        mergeSort(data, 0, data.length - 1);
        System.out.println(Arrays.toString(data));
    }

    /**
     * 归并排序：分两步1，拆分，2合并
     * @param data
     * @param start
     * @param end
     */
    private static void mergeSort(int[] data, int start, int end) {
        if (data == null || data.length <= 1 || start >= end) {
            return;
        }
        int m = start + (end - start) / 2;
        mergeSort(data, start, m);
        mergeSort(data, m + 1, end);
        merge(data, start, m, end);

    }

    private static void merge(int[] data, int start, int middle, int end) {
        int[] temp = new int[end - start + 1];
        int index = 0;
        int newStart = start;
        int newMiddle = middle + 1;
        while (newStart <= middle || newMiddle <= end) {
            if (newStart > middle) {
                temp[index++] = data[newMiddle++];
            } else if (newMiddle > end) {
                temp[index++] = data[newStart++];
            } else if (data[newStart] > data[newMiddle]) {
                temp[index++] = data[newMiddle++];
            } else {
                temp[index++] = data[newStart++];
            }
        }
        for (int i = start; i <= end; i++) {
            data[i] = temp[i - start];
        }
    }
}
