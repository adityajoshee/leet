package adityajoshee.dsa.dp;

/**
 * Created by aditya.joshee on 07/09/14.
 */
public class NStepsUsingDP {
    public static void main(String args[]){
        System.out.println("No. of ways = "+stepdown(5));

    }
    private static int stepdown(int n){
        int[] dp = new int[n+1];
        dp[0]=1; // no. of ways of covering 0 steps
        dp[1]=1;
        dp[2]=2; // (1,1) or (2) steps , so no. of ways =2
        for(int i=3;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2]+dp[i-3];
        }
        return dp[n];
    }
}
