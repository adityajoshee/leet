package adityajoshee.dsa.array.kthLargest;

import java.util.Arrays;

/**
 * Created by aditya on 10/19/16.
 */
// average performance : O(n)
// worst case : O(n*n)
// used for finding kth largest/smallest number.
// Also for finding k largests numbers in average O(n) time.

public class QuickSelect {
    public static void main(String args[]){
        int[] arr = {2,5,1,6,4,3};//{-1,2,1,6,3,2,0,5,11,4,102,100};
        System.out.println(findKthSmallest(arr,2));
    }
    private static int findKthSmallest(int[] arr, int k){
        return helper(arr, 0, arr.length-1, k);
    }
    private static int helper(int[] arr, int start, int end, int k){
        int correctPivIndex = getPivIndex(arr, start, end);
        System.out.println(Arrays.toString(arr));
        if(k>correctPivIndex){
            return helper(arr, correctPivIndex+1, end, k);
        }
        else if(k<correctPivIndex){
            return helper(arr, start, correctPivIndex-1, k);
        }
        return arr[correctPivIndex];
    }
    private static int getPivIndex(int[] arr, int start, int end){
        int pivIndex = end;
        int i=start;
        int j=end-1;
        while(i<j){
            while(i<j && arr[i]<=arr[pivIndex]){
                i++;
            }
            while(j>i && arr[j]>arr[pivIndex]){
                j--;
            }
            swap(arr, i, j);
        }
        if(arr[i]>arr[pivIndex]){
            swap(arr, i, pivIndex);
        }
        return i;
    }

    private static void swap(int[] arr, int x, int y){
        int t = arr[x];
        arr[x] = arr[y];
        arr[y] = t;
    }
}
