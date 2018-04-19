package adityajoshee.Y2K18.apr.D09;

/**
 * Created by aditya.joshee on 4/9/18.
 */
public class MaxSubarraySum {
    public static void main(String[] args) {
        int[] arr = { -2, -3, 4, -1, -2, 1, 5, -3 };//{-4, -2, -8 , -1};
        System.out.println(findMaxSubarraySum(arr));
        findSubArray(arr);
    }

    //kadane
    private static int findMaxSubarraySum(int[] arr) {
        int curMax = arr[0];
        int sum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            sum = sum < 0 ? arr[i] : sum+arr[i];
            curMax = Math.max(sum, curMax);
        }
        return curMax;
    }

    private static int findSubArray(int[] arr) {
        int curMax = arr[0];
        int sum = arr[0];
        int a = 0;
        int b = 0;
        for (int i = 1; i < arr.length; i++) {
            if (sum<0){
                sum = arr[i];
                a = i;
            }
            else{
                sum = sum + arr[i];
            }
            if (curMax< sum){
                curMax = sum;
                b = i;
            }
        }
        System.out.println(a+","+b);
        return curMax;
    }
}
