package adityajoshee.dsa.dp.EvenSubstringSumEqualHalf;

import adityajoshee.dsa.matrix.PrintMatrix;

/**
 * Created by aditya.j on 3/23/17.
 */
public class Try1 {
    public static void main(String args[]){
        int[] arr = {1,5,3,8,0,2,3};
        System.out.println(find(arr));
    }
    private static int find(int[] arr){
        int[][] dp = new int[arr.length][arr.length];
        int maxlen = 0;
        for (int len = 1; len <= arr.length; len++) {
            for (int i = 0; i <= arr.length-len; i++) {
                int j = i+len-1;
                if (i==j){
                    dp[i][j] = arr[i];
                }
                else{
                    dp[i][j] = arr[j] + dp[i][j-1];
                }
                if (len%2==0){
                    int lsum = dp[i][i+len/2-1];
                    int rsum = dp[i+len/2][j];
                    if (lsum==rsum){
                        maxlen = len;
                    }
                }
            }
        }
        PrintMatrix.print(dp);

        return maxlen;
    }
}
