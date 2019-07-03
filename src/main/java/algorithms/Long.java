package algorithms;

public class Long {
    private static int [] data={12,45,4,56,78,96,14,3,6,9,7,747,529,864,326,459,101,123,129,44,49};
    public static void main(String[] args){

        System.out.println(getLongIncresingSubquence(data));
    }
    static int  getLongIncresingSubquence(int[] data){
        if (data==null||data.length<1){
            return 0;
        }

        int length=data.length;
        int[] tempData=new int[length+1];
        tempData[0]=Integer.MIN_VALUE;
        System.arraycopy(data,0,tempData,1,length);
        length++;
        int[][] temp=new int[length+1][length+1];
        /**
         * lis(i,j)决定于lis(i,j+1) lis(j,j+1)
         */
        //初始化
        for (int i=0;i<=length-1;i++){
            temp[i][length]=0;
        }
        //填充递归中间值,自底向上遍历所有情况
        for (int j=length-1;j>=0;j--){
            for (int i=0;i<j;i++){
                int keep=temp[j][j+1]+1;
                int skip=temp[i][j+1];
                if (tempData[i]>=tempData[j]){
                    temp[i][j]=skip;
                }else {
                    temp[i][j]=Math.max(skip,keep);
                }
            }
        }
        return temp[0][1];
    }
}
