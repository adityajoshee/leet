package adityajoshee.Y2K18.mar.D13;

import java.util.Scanner;

/**
 * Created by aditya.joshee on 3/13/18.
 */
public class Knapsack01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int W = scanner.nextInt();
        int N = scanner.nextInt();
        int[] weights = new int[N];
        int[] values = new int[N];
        for (int i = 0; i < N; i++) {
            values[i] = scanner.nextInt();

        }
        for (int i = 0; i < N; i++) {
            weights[i] = scanner.nextInt();

        }
        Max max = new Max();
        maximizeValue(W, 0, values, weights, 0, max);
        System.out.println(max.val);
        System.out.println(maximizeDP(W, values, weights));
    }

    private static void maximizeValue(int w, int v, int[] values, int[] weights, int currIndex, Max currMax) {
        if (w>=0){
            currMax.val = currMax.val < v ? v : currMax.val;
        }
        else {
            return;
        }
        if (currIndex<weights.length){
            maximizeValue(w, v, values, weights, currIndex+1, currMax);
            maximizeValue(w-weights[currIndex], v+values[currIndex], values, weights, currIndex+1, currMax);
        }

    }
    private static class Max {
        int val;
    }

    private static int maximizeDP(int W, int[] values, int[] weights){
        int[][] dp = new int[values.length+1][W+1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j <= W; j++) {
                if (weights[i-1] <= j){
                    //max of (max excluding current coin for current weight j) and (incl currect coin value + max of j-rem.wt till previous item)
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weights[i-1]]+values[i-1]);
                }
                else {
                    //max for currect weight j which is excluding current item
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        return dp[dp.length-1][dp[0].length-1];
    }
}
