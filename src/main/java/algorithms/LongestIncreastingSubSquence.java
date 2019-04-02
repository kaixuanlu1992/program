package algorithms;

public class LongestIncreastingSubSquence {
    public static void main(String[] args) {
        int[] data = {1, 2, 33, 4, 21, 22};
        System.out.println(getLongestIncreastingSubsquence(data, 0, 0));
        System.out.println(getMaxIncreastingSubsquence(data, 0, 0, 0));
    }

    /**
     * 获取最大递增子序列长度
     *
     * @param data
     * @param index
     * @param prev
     * @return
     */
    private static int getLongestIncreastingSubsquence(int[] data, int index, int prev) {
        //结束条件：已经遍历完数组
        if (data.length <= index) {
            return 0;
        } else if (prev >= data[index]) {
//            当前值小于等于子序列值
            return getLongestIncreastingSubsquence(data, ++index, prev);
        } else {
            int nextIndex = index + 1;
            /**
             如果当前值大于prev,存在两种情况
             1、将当前值包含在子序列中
             2、当前值不包含在序列中
             */
            return Math.max(getLongestIncreastingSubsquence(data, nextIndex, data[index]) + 1, getLongestIncreastingSubsquence(data, nextIndex, prev));
        }
    }

    /**
     * 获取最大递增子序列和
     * @param data
     * @param index
     * @param prev
     * @param prevSum
     * @return
     */
    private static int getMaxIncreastingSubsquence(int[] data, int index, int prev, int prevSum) {
        //结束条件：已经遍历完数组
        if (data.length <= index) {
            return prevSum;
        } else if (prev >= data[index]) {
//            当前值小于等于子序列值不是递增子序列
            return getMaxIncreastingSubsquence(data, ++index, prev, prevSum);
        } else {
            int nextIndex = index + 1;
            /**
             如果当前值大于prev,存在两种情况
             1、将当前值包含在子序列中
             2、当前值不包含在序列中
             */
            return Math.max(getMaxIncreastingSubsquence(data, nextIndex, data[index], prevSum + data[index]),
                    getMaxIncreastingSubsquence(data, nextIndex, prev, prevSum));
        }
    }
}
