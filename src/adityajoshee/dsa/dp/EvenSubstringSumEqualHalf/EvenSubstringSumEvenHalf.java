package adityajoshee.dsa.dp.EvenSubstringSumEqualHalf;

import adityajoshee.dsa.matrix.PrintMatrix;

/**
 * Created by aditya on 11/12/16.
 */
//http://www.geeksforgeeks.org/longest-even-length-substring-sum-first-second-half/
    
public class EvenSubstringSumEvenHalf {
    
    public static void main(String args[]){
        int[] arr = {1,5,3,8,0,2,3};//{1,0,0,1,3,0,4,0};
        System.out.println(longestLength(arr));
    }
    private static int longestLength(int[] arr){
        int sumsDp[][] = new int[arr.length][arr.length];
        int maxLen = 0;
        for (int len = 1; len <= arr.length; len++) {
            for (int i = 0; i <= arr.length-len; i++) {
                int j = i+len-1;

                if (j-1>=0){
                    sumsDp[i][j] = arr[j]+sumsDp[i][j-1];
                }
                else{
                    sumsDp[i][j] = arr[j]; // since no element on left.
                }

                if (len%2==0){
                    // check and update maxLen
                    int k = len/2;
                    int lsum = sumsDp[i][j-k];
                    int rsum = sumsDp[j-k+1][j];
                    if (lsum==rsum){
                        maxLen = Math.max(maxLen,len);
                    }
                }
            }
        }
        PrintMatrix.print(sumsDp);
        return maxLen;
    }
}