package algorithms.dp;

import algorithms.matrix.PrintMatrix;

/**
 * Created by aditya on 9/29/16.
 */

// only get length, O(n*n) time and space DP
public class LongestPalindromicSubsequence {
    public static void main(String args[]){
        String s = "GEEKS FOR GEEKS";//"BBCB";//"ADPIQFIDTYA";
        System.out.println(lengthOfMax(s.toCharArray()));
    }
    private static int lengthOfMax(char[] arr){
        int[][] dp = new int[arr.length][arr.length];
        for (int l = 1; l <=  arr.length; l++) {  // i represents current length
            for (int i = 0; i < arr.length; i++) {
                if(l==1){
                    dp[i][i+l-1] = 1;
                }
                else{
                    if(i+l-1<arr.length){
                        dp[i][i+l-1] = arr[i]==arr[i+l-1] ? 2+dp[i+1][i+l-2] : Math.max(dp[i][i+l-2],dp[i+1][i+l-1]);
                    }
                }
            }
        }
        PrintMatrix.print(dp);
        return dp[0][arr.length-1];
    }
}
