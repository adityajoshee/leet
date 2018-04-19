package adityajoshee.Y2K18.mar.D09;

import java.util.Scanner;

/**
 * Created by aditya.joshee on 3/9/18.
 */
//Ways to write n as sum of two or more positive integers https://www.geeksforgeeks.org/ways-to-write-n-as-sum-of-two-or-more-positive-integers/

public class SumRepresentationDP {
    public static void main(String[] args) {
        int N = new Scanner(System.in).nextInt();
        System.out.println(findWays(N));
        System.out.println(find(N));
    }

    private static int findWays(int N) {
        if (N <= 2){
            return 0;
        }

        int[] dp = new int[N+1];
        dp[1] = 0;
        dp[2] = 0;
        dp[3] = 2;
        dp[4] = 4;
        for (int i = 5; i <= N; i++) {
            int s = 0;
            for (int j = 1; j < i; j++) {
                s = s + dp[j];
            }
            dp[i] = s;
        }
        return dp[N];
    }

    private static int find (int n){
        int table[] = new int[n+1];

        // Base case (If given value is 0)
        table[0] = 1;

        // Pick all integer one by one and update the
        // table[] values after the index greater
        // than or equal to n
        for (int i=1; i<n; i++)
            for (int j=i; j<=n; j++)
                table[j] += table[j-i];

        for (int i = 0; i <= n; i++) {
            System.out.println(table[i]);
        }
        return table[n];
    }
}
