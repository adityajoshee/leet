package adityajoshee.dsa.backtracking;

import java.util.Arrays;

/**
 * Created by aditya on 10/27/16.
 */
// http://www.geeksforgeeks.org/fill-two-instances-numbers-1-n-specific-way/
public class ArrayFillDistance {
    public static void main(String args[]) {
        int n = 3; // 1....n
        int[] arr = new int[2 * n];
        fill(arr,1,n);
    }
    private static boolean fill(int[] arr, int n, int N){
        if (n==N+1){
            System.out.println(Arrays.toString(arr));
            return true;
        }
        for (int j = 0; j < arr.length; j++) {
            if (arr[j]==0 && (j+n+1) < arr.length && arr[j+n+1]==0){
                arr[j]=n;
                arr[j+n+1]=n;
                boolean res = fill(arr, n+1, N);
                if (!res){
                    arr[j]=0;
                    arr[j+n+1]=0;
                }
            }
        }
        return false;
    }
}
