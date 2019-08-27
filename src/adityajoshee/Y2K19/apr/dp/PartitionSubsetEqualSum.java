package adityajoshee.Y2K19.apr.dp;

import java.util.Arrays;

/**
 * @author Aditya Joshee
 */
public class PartitionSubsetEqualSum {
    public static void main(String[] args) {
        int[] arr = {3, 1, 1, 2, 2, 1};
        int n = Arrays.stream(arr).sum();
        if (n%2!=0){
            System.out.println(false);
            return;
        }

        System.out.println(determine(arr, arr.length-1, n/2));
    }

    private static boolean determine(int[] arr, int i, int n) {
        if (n<0){
            return false;
        }
        if (i<0){
            if (n==0) return true;
            return false;
        }
        return determine(arr, i-1, n-arr[i]) || determine(arr, i-1, n);
    }
}
