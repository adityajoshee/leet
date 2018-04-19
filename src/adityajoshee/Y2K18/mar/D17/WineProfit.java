package adityajoshee.Y2K18.mar.D17;

import java.util.Scanner;

/**
 * Created by aditya.joshee on 3/17/18.
 */
public class WineProfit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] prices = new int[N];
        for (int i = 0; i < N; i++) {
            prices[i] = scanner.nextInt();
        }
        System.out.println(maximizeProfitRecr(prices, 1, 0, prices.length-1));

        int[][] liriDP = new int[prices.length][prices.length];
        for (int i = 0; i < prices.length; i++) {
            for (int j = 0; j < prices.length; j++) {
                liriDP[i][j] = -1;
            }
        }
        System.out.println(maxProfitDP(liriDP, prices, 0, prices.length-1));
    }

    private static int maximizeProfitRecr(int[] prices, int year, int li, int ri) {
        if (year>prices.length){
            return 0;
        }
        return Math.max(prices[li]*year + maximizeProfitRecr(prices, year+1, li+1, ri),
                prices[ri]*year + maximizeProfitRecr(prices, year+1, li, ri-1));
    }

    private static int maxProfitDP(int[][]dp, int[] prices, int li, int ri){
        if (li>ri){
            return 0;
        }
        if (dp[li][ri]!=-1){
            return dp[li][ri];
        }
        int year = 1 + prices.length - (ri-li+1);
        dp[li][ri] = Math.max(prices[li]*year  + maxProfitDP(dp, prices, li+1, ri),
                                prices[ri]*year + maxProfitDP(dp, prices, li, ri-1));
        return dp[li][ri];
    }
}
