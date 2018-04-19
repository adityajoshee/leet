package adityajoshee.Y2K18.jan.D15;

/**
 * Created by aditya.joshee on 1/15/18.
 * https://leetcode.com/articles/climbing-stairs/
 */
public class ClimbStairs {
    public static void main(String[] args){
        System.out.println(bestSol(20));
        System.out.println(solveDP(20));
        System.out.println(solve(20));
    }

    // plain recursive, complexity will be 2^n
    private static int solve(int n) {
        if (n==1){
            return 1;
        }
        if (n==2){
            return 2;
        }
        return solve(n-1) + solve(n-2);
    }

    // using On space, On time
    private static int solveDP(int n){
        int[] dp = new int[n+1];
        dp[1]=1;
        dp[2]=2;
        // we can reach step j from either j-1 or j-2. So ways to reach jth step
        // will sum of ways to reach j-1)th and j-2)th step.
        for (int j=3; j<=n; j++){
            dp[j] = dp[j-1] + dp[j-2];
        }
        return dp[n];
    }

    // using constant space, On time
    private static int bestSol(int n){
        if (n==1){
            return 1;
        }
        int x = 1; // ways to reach 1st step
        int y = 2; // ways to reach 2nd step
        int k = 2; // current step.

        while (k<n){
            int t = y;
            y = x + y;
            x = t;
            k++;
        }
        return y;
    }
}
