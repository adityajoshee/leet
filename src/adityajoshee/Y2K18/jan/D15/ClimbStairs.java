package adityajoshee.Y2K18.jan.D15;

/**
 * Created by aditya.joshee on 1/15/18.
 */
public class ClimbStairs {
    public static void main(String[] args){
        System.out.println(bestSol(20));
        System.out.println(solveDP(20));
        System.out.println(solve(20));
    }

    private static int solve(int i) {
        if (i==1){
            return 1;
        }
        if (i==2){
            return 2;
        }
        return solve(i-1) + solve(i-2);
    }

    private static int solveDP(int n){
        int[] dp = new int[n+1];
        dp[1]=1;
        dp[2]=2;
        for (int j=3; j<=n; j++){
            dp[j] = dp[j-1] + dp[j-2];
        }
        return dp[n];
    }

    private static int bestSol(int n){
        if (n==1){
            return 1;
        }
        int x = 1;
        int y = 2;
        int k = 2;

        while (k<n){
            int t = y;
            y = x + y;
            x = t;
            k++;
        }
        return y;
    }
}
