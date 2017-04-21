package adityajoshee.dsa.dp;

import java.util.Scanner;

/**
 * Created by aditya.joshee on 31/07/14.
 */
public class MatrixMovesDP {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter row,column:");
        int c = in.nextInt();
        int r = in.nextInt();
        System.out.println("No. of ways: " + countMoves(r, c));
    }

    private static int countMoves(int r, int c) {
        int[][] dp = new int[r][c];
        for (int i = 0; i < r; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < c; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < r; i++) {
            for (int j = 1; j < c; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[r-1][c-1];
    }
}