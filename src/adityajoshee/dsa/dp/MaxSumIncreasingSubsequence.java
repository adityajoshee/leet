package adityajoshee.dsa.dp;

import java.util.Arrays;

/**
 * Created by aditya on 11/23/16.
 */
public class MaxSumIncreasingSubsequence {
    public static void main(String args[]){
        int[] arr = {9,7,15,0,1,2,3,4,5,6,7,8,4};//{1, 101, 2, 3, 100, 4, 5};
        System.out.println(find(arr));
    }
    private static int find(int[] arr){
        /* findMethod1 max sum for every subseq.
        which contains ith element and store
        at dpSums[i]
         */
        int[] dpSums = new int[arr.length];
        dpSums[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            int tempMaxSum = 0;
            for (int j = 0; j < i; j++) {
                if (arr[j]<arr[i] && dpSums[j]>tempMaxSum){
                    tempMaxSum = dpSums[j];
                }
            }
            dpSums[i] = arr[i]+tempMaxSum;
        }
        System.out.println(Arrays.toString(dpSums));
        return maxElement(dpSums);
    }
    // findMethod1 max element from an array
    private static int maxElement(int[] arr){
        int maxOfAll=arr[0];
        for(int i=1;i<arr.length;i++){
            if(arr[i]>maxOfAll){
                maxOfAll=arr[i];
            }
        }
        return maxOfAll;
    }
}
