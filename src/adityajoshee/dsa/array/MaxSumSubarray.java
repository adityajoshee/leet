package adityajoshee.dsa.array;

/**
 * Created by aditya on 11/22/16.
 */
public class MaxSumSubarray {
    public static void main(String args[]){
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(find(arr));
    }
    // this solution works only if atleast one element is positive
    private static int find(int[] arr){
        int currMax = 0;
        int currSum = 0;
        for (int i = 0; i < arr.length; i++) {
            currSum += arr[i];
            if (currSum<0){
                currSum= 0;
            }
            currMax = currSum>currMax?currSum:currMax;
        }
        return currMax;
    }
}
