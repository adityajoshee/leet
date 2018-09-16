package adityajoshee.Y2K18.mar.D09;

import java.util.Scanner;

/**
 * Created by aditya.joshee on 3/9/18.
 */
//Let us say that you are given a number N, you've to findMethod1 the
// number of different ways to write it as the sum of 1, 3 and 4.

public class SumVariationsDP {
    public static void main(String[] args) {
        int N = new Scanner(System.in).nextInt();
        int[] arr = new int[N+1];
        arr[1] = 1;
        arr[2] = 1;
        arr[3] = 2;
        arr[4] = 4;
        System.out.println(findWays(N, arr));
        System.out.println(findWays2(N));
    }

    private static int findWays(int N, int[] DP) {
        if (N==0){
            return 0;
        }
        if (DP[N]!=0){
            return DP[N];
        }
        return findWays(N-1, DP) + findWays(N-3, DP) + findWays(N-4, DP);
    }

    private static int findWays2(int N){
        int[] dp = new int[N+1];
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 2;
        dp[4] = 4;
        for (int i = 5; i < N+1; i++) {
            dp[i] = dp[i-1] + dp [i-3] + dp[i-4];
        }
        return dp[N];
    }
}