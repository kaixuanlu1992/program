package algorithms;

import java.util.ArrayList;
import java.util.List;

public class SubsetSum {
    public static void main(String[] args) {
        int[] data = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        System.out.println(subsetSum(data, 250, data.length));
        System.out.println(subsetSumAndPrint(data, 100, data.length, null));

    }

    /**
     * 判断是否存在子数组和为target
     *
     * @param list
     * @param target
     * @param index
     * @return
     */
    private static Boolean subsetSum(int[] list, int target, int index) {
        if (target == 0) {
            return true;
        } else if (target < 0 || index <= 0) {
            return false;
        } else {
            int newIndex = index - 1;
            return subsetSum(list, target - list[index - 1], newIndex) || subsetSum(list, target, newIndex);
        }
    }

    /**
     * 判断是否存在子数组和为target，并打印
     *
     * @param list
     * @param target
     * @param index
     * @return
     */
    private static Boolean subsetSumAndPrint(int[] list, int target, int index, List<Integer> data) {
        if (target == 0) {
            System.out.println(data);
            return true;
        } else if (target < 0 || index <= 0) {
            return false;
        } else {
            int newIndex = index - 1;
            boolean without = subsetSumAndPrint(list, target, newIndex, data);
            List<Integer> data1=new ArrayList<Integer>();
            if (data != null) {
                data1.addAll(data);
            }
            data1.add(list[index - 1]);
            boolean with = subsetSumAndPrint(list, target - list[index - 1], newIndex, data1);
            return without || with;
        }
    }


}
