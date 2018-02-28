package adityajoshee.Y2K18.feb.D04;

/**
 * Created by aditya.joshee on 2/4/18.
 */

//Given an array arr[], find the maximum j – i such that arr[j] > arr[i]

public class MaxDistance {
    public static void main(String[] args) {
        int[] arr = {9, 2, 3, 4, 5, 6, 7, 18, 8, 0};
        System.out.println(solve(arr));
        System.out.println(max(arr));
    }

    private static int solve(int[] arr) {
        int[] lmin = new int[arr.length];
        int[] rmax = new int[arr.length];
        construct(arr, lmin, rmax);
        int j = 0;
        int i = 0;
        int maxDiff = -1;
        while (i<arr.length && j<arr.length){
            if (arr[lmin[i]] < arr[rmax[j]]){
                if (maxDiff < j-i){
                    maxDiff = j-i;
                }
                j++;
            }
            else {
                i++;
            }
        }
        return maxDiff;
    }

    private static void construct(int[] arr, int[] lmin, int[] rmax) {
        int x = 0;
        lmin[x] = x;
        for (int i = 1; i < lmin.length; i++) {
            if (arr[i]<arr[x]){
                lmin[i] = i;
                x = i;
            }
            else{
                lmin[i] = x;
            }
        }

        x = rmax.length-1;
        rmax[x] = x;
        for (int i = rmax.length-2; i >= 0; i--) {
            if (arr[i]>arr[x]){
                rmax[i] = i;
                x = i;
            }
            else {
                rmax[i] = x;
            }
        }
    }



    //O(n2) solution
    private static int max(int[] arr){
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 1; j < arr.length; j++) {
                if (arr[j]>arr[i] && j-i>max){
                    max = j-i;
                }
            }
        }
        return max;
    }
}
