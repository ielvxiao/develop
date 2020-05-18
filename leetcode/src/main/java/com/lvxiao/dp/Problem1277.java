package com.lvxiao.dp;

/**
 * @author lvxiao
 * @date 2020/5/18
 */
public class Problem1277 {
    public static void main(String[] args) {
        System.out.println(new Problem1277().countSquares(new int[][]
                {{0, 1, 1, 1}, {1, 1, 1, 1}, {0, 1, 1, 1}}));
    }
    public int countSquares(int[][] matrix) {
        if(matrix.length==0)    return 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        int res=0;
        //计算以dp[i][j]为右下角的正方形个数
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(i==0||j==0||matrix[i][j]==0){
                    dp[i][j]=matrix[i][j];
                }else{
                    int len = Math.min(dp[i-1][j],dp[i][j-1]);
                    dp[i][j]=len+(matrix[i-len][j-len]>0?1:0);
                }
                res+=dp[i][j];
            }
        }
        return res;
    }
}
