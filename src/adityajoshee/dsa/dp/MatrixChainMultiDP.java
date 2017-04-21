package adityajoshee.dsa.dp;

/**
 * Created by aditya.j on 4/2/17.
 */
public class MatrixChainMultiDP {
    public static void main(String args[]){
        int[] arr = {10, 20, 30, 40, 30}  ;
        System.out.println(findMinCalc(arr));
    }
    private static int findMinCalc(int[] arr){
        int[][] dp = new int[arr.length][arr.length]; // number of matrices will be 1 less than array len
        // for a single matrix, i.e. diagonal cells the value will be 0;

        for (int len = 2; len < arr.length; len++) {
            for (int i = 1; i < arr.length-len+1; i++) {
                int j = i+len-1;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int q = dp[i][k] + dp[k+1][j] + arr[i-1]*arr[k]*arr[j];
                    if (q<dp[i][j]){
                        dp[i][j] = q;
                    }
                }
            }
        }
        return dp[1][arr.length-1];
    }
}
