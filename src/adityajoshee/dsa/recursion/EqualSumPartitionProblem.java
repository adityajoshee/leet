package adityajoshee.dsa.recursion;

import adityajoshee.dsa.matrix.PrintMatrix;

/**
 * Created by aditya on 11/13/16.
 */
// find if partioning is possible or not.
// The resulting two subsets can be of unequal size, but not empty
// This solution uses subset sum finding as subroutine.
public class EqualSumPartitionProblem {
    public static void main(String args[]){
        int[] arr = {4,2,8,7,9};
        System.out.println(find(arr));
    }
    private static boolean find(int[] arr){
        /* if sum of all elements is odd then the
        array cannot be divided into subsets of equal sum.
        */
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        if (sum%2!=0){
            System.out.println("Sum of elements is odd, so not possible.");
            return false;
        }
        return findIfSubsetWithSumExists(arr,sum/2);
    }
    private static boolean findIfSubsetWithSumExists(int[] arr, int sum){
        boolean[][] dp = new boolean[arr.length][sum+1];;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j <= sum; j++) {
                //boolean valA = i-1>=0 ? dp[i-1][j] : (j-arr[i]==0?true:false);
                //boolean valB = i-1>=0 && j-arr[i]>=0 ? dp[i-1][j-arr[i]] : false;
                //dp[i][j] =  valA || valB;
                if (i-1>=0){
                    boolean a = j-arr[i] == 0 || (j-arr[i]>=0 && dp[i-1][j-arr[i]]) ? true : false;
                    boolean b = dp[i-1][j];
                    dp[i][j] = a || b;

                }
                else{
                    dp[i][j] = j-arr[i] == 0 ? true : false;
                }
            }
        }
        PrintMatrix.printb(dp);
        return dp[arr.length-1][sum];
    }
}
