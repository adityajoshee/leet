package adityajoshee.dsa.dp;

/**
 * Created by aditya on 9/12/16.
 */

// On2 approach (best is nlogn)
public class LongestIncreasingSubsequence {
    public static void main(String args[]){
        int[] arr = {33, 0, 4, 1, 5, 9};//{ 10, 22, 9, 33, 21, 50, 41, 60, 80};
        System.out.println(LIS(arr));
    }
    private static int LIS(int[] arr){
        int[] LIS = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            LIS[i] = 1; // since lenght of LIS which ends at i and includes arr[i] will be min 1.
        }
        for (int i = 1; i < arr.length; i++) { // start from 1 as LIS[0] will be 1 everytime.
            for (int j = 0; j < i; j++) {
                if(arr[j] < arr[i] && LIS[i] < 1 + LIS[j]){
                    LIS[i] = 1 + LIS[j];
                }
            }
        }
        return maxElement(LIS);
    }
    // find max element from an array
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
