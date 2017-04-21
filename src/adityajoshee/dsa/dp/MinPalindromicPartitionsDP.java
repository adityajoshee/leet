package adityajoshee.dsa.dp;

/**
 * Created by aditya.j on 4/2/17.
 */
public class MinPalindromicPartitionsDP {
    public static void main(String args[]) {
        int[] arr = {1, 2, 1, 2, 2, 2, 1, 2, 2, 1, 2, 1, 2, 1};
        System.out.println(minPartitions(arr));
    }

    private static int minPartitions(int[] arr) {
        int[][] dp = new int[arr.length][arr.length]; // store subproblem resutls, will be fill half vacant in the end
        for (int len = 2; len <= arr.length; len++) {
            for (int i = 0; i < arr.length-len+1; i++) {
                int j = i+len-1;

                if (isPalindrome(arr, i, j)){
                    dp[i][j] = 0;
                }
                else{
                    int min = Integer.MAX_VALUE;
                    for (int k = i; k < j; k++) {
                        int q = dp[i][k] + 1 + dp[k+1][j];
                        if (q<min){
                            min = q;
                        }
                    }
                    dp[i][j] = min;
                }
            }
        }
        return dp[0][arr.length-1];
    }
    private static boolean isPalindrome(int[] arr, int i, int j){
        while (i<j){
            if (arr[i++]!=arr[j--]){
                return false;
            }
        }
        return true;
    }
    private static int min(int a, int b, int c){
        return a>b?(a>c?a:c):(b>c?b:c);
    }
}