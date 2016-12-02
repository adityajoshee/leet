package adityajoshee.dsa.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by aditya on 9/13/16.
 */
public class StaircaseStepsWays {
    public static void main(String args[]) throws IOException{
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        int n = Integer.parseInt(bufferedReader.readLine());
        int m = Integer.parseInt(bufferedReader.readLine());

        System.out.print(findWays(n,m));
    }
    private static int findWays(int n, int m){
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        if(m>=2)
            dp[2] = 2;

        for (int i = m; i <= n; i++) {
            int t = i<m?i:m;
            dp[i] = 0;
            for (int j = 1; j <= t; j++) {
                dp[i] += dp[i-j];
            }
        }
        return dp[n];
    }
}
