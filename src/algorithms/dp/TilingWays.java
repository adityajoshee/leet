package algorithms.dp;

/**
 * Created by aditya on 9/13/16.
 */
//http://www.geeksforgeeks.org/tiling-problem/
public class TilingWays {
    public static void main(String args[]){
        int h = 4;
        System.out.println(findWays(h));
    }
    private static int findWays(int h){
        int[] dp = new int[h+1];
        dp[0]=1;
        dp[1]=1;
        dp[2]=2;
        for (int i = 3; i <= h; i++) {
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[h];
    }
}
