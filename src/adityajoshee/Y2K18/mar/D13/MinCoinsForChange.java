package adityajoshee.Y2K18.mar.D13;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by aditya.joshee on 3/13/18.
 */
public class MinCoinsForChange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int[] coins = new int[M];
        for (int i = 0; i < M; i++) {
            coins[i] = scanner.nextInt();
        }
        System.out.println(findMinWays(N, coins));
    }

    private static int findMinWays(int N, int[] coins) {
        int[] dp = new int[N+1];

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= N; j++) {
                if (dp[j-coins[i]]!=Integer.MAX_VALUE){
                    dp[j] = Math.min(dp[j], dp[j-coins[i]]+1);
                }
            }
        }
        return dp[N];
    }
}
