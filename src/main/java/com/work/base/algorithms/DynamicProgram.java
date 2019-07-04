package com.work.base.algorithms;

public class DynamicProgram {
    private static int[] data = {1, 2, 4, 5, 7, 67, 44, 34, 56, 78, 120, 23, 454, 666, 39, 52, 89, 69, 80, 121};

    public static void main(String[] args) {
        System.out.println(longestInstreasingSubsequence(data));
    }

    /**
     * 最长递增子序列
     * 递归：
     * LISUB(i,j)=
     * 0  for j>n
     * LIBSUB(i,j+1)  for A[i]>=A[j]
     * max(LIBSUB(i,j+1), LIBSUB(j,j+1)+1) for otherwise
     */
    static int longestInstreasingSubsequence(int[] data) {
        int length = data.length;
        int[] tempdata = new int[length + 1];
        tempdata[0] = Integer.MIN_VALUE;
        System.arraycopy(data, 0, tempdata, 1, length);
        length++;
        //存储递归子问题
        int[][] temp = new int[length + 1][length + 1];
        //初始值
        for (int i = 0; i <= length; i++) {
            temp[i][length] = 0;
        }
        //计算中间临时值,计算顺序和递归顺序相反
        for (int j = length - 1; j > 0; j--) {
            for (int i = 0; i < j; i++) {
                int keep = temp[j][j + 1] + 1;
                int skip = temp[i][j + 1];
                if (tempdata[i] >= tempdata[j]) {
                    temp[i][j] = skip;
                } else {
                    temp[i][j] = Math.max(skip, keep);
                }
            }
        }
        return temp[0][1];
    }

    static int editDistance(String src, String dest) {
        char[] srcChar = src.toCharArray();
        char[] destChar = dest.toCharArray();
        int m = srcChar.length;
        int n = destChar.length;
        //存储临时数据
        int[][] edit = new int[m+1][n+1];
        //初始值，edit(i,j)决定于edit(i,j-1),edit(i-1,j),edit(i-1,j-1)
        for (int i = 0; i <= n; i++) {
            edit[0][i] = i;
        }
        for (int i = 0; i <= m; i++) {
            edit[i][0] = i;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int insert = 0, delete = 0, rep = 0;
                if (srcChar[i-1] == destChar[j-1]) {
                    rep =edit[i-1][j-1];
                }else {
                    rep =edit[i-1][j-1]+1;
                }
                insert=edit[i-1][j];
                delete=edit[i][j-1];
                edit[i][j]=Math.min(Math.min(insert,delete),rep);
            }
        }
        return edit[m][n];
    }
}
