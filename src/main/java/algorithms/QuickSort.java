package algorithms;

import java.util.Arrays;

/**
 * 快速排序，选择数组的一个元素，将数组分为三部分：小于，等于，大于；然后递归
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] data = {1, 2, 3, 4, 9, 8, 7, 6, 5, 11, 23, 55, 33, 21, 77, 68, 88, 94, 12, 13, 17, 81, 82, 83};
        quickSort(data, 0,data.length - 1);
        System.out.println(Arrays.toString(data));
    }

    private static void quickSort(int[] data, int start, int end) {
        if (data == null || start >= end) {
            return;
        } else {
            int r = partion(data, start, end);
            quickSort(data, start, r - 1);
            quickSort(data, r + 1, end);
        }
    }

    private static int partion(int[] data, int start, int end) {
    }
}
