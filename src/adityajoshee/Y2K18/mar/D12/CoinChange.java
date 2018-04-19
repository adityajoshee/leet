package adityajoshee.Y2K18.mar.D12;

import java.util.Scanner;

/**
 * Created by aditya.joshee on 3/12/18.
 */
public class CoinChange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int S = scanner.nextInt();
        int[] coins = new int[S];
        for (int i = 0; i < S; i++) {
            coins[i] = scanner.nextInt();
        }
        System.out.println(System.nanoTime());

        System.out.println(findWays(coins, N, 0));
        System.out.println(System.nanoTime());

        System.out.println(findWaysDP(coins, N));
        System.out.println(System.nanoTime());

        System.out.println(findWaysDPOptmised(coins, N));
        System.out.println(System.nanoTime());

    }

    private static int findWays(int[] coins, int N,  int currCoin) {
        if (N==0){
            return 1;
        }
        if (N<0){
            return 0;
        }
        if (currCoin>=coins.length){
            return 0;
        }
        return findWays(coins, N-coins[currCoin], currCoin) + findWays(coins, N, currCoin+1);
    }

    //space complexity is On2
    private static int findWaysDP(int[] coins, int N){
        int[][] dp = new int[coins.length+1][N+1];
        for (int j = 0; j < dp.length; j++) {
            dp[j][0] = 1;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (j<coins[i-1]){
                    dp[i][j] = dp[i-1][j];
                }
                else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                }
            }
        }
        return dp[coins.length][N];
    }

    //space complexity is On
    private static int findWaysDPOptmised(int[] coins, int N){
        int[] dp = new int[N+1];
        for (int j = 0; j < dp.length; j++) {
            dp[0] = 1;
        }

        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j < dp.length; j++) {
                dp[j] = dp[j] + dp[j-coins[i]];
            }
        }
        return dp[N];
    }
}
