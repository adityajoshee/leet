package adityajoshee.Y2K18.mar.D18;

import java.util.Scanner;


/**
 * Created by aditya.joshee on 3/18/18.
 */
public class LIS {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(findLIS(arr));
    }

    private static int findLIS(int[] arr) {
        int[] dp = new int[arr.length];
        // dp[i] is length of LIS till ith element and containing ith element.
        dp[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = i-1; j >=0; j--) {
                if (arr[j]<arr[i]){
                    max = Math.max(dp[j], max);
                    dp[i] = max;
                }
            }
            if (dp[i]==0){
                dp[i] = 1; // no smaller element found so len will be 1 which includes only ith element.
            }
            else {
                dp[i]++; // otherwise incr by 1 since adding ith element.
            }
        }
        // now findMethod1 the max value of LISs ending at among all elements.
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
