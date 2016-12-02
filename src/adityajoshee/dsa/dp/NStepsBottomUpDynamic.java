package adityajoshee.dsa.dp;

/**
 * Created by adityajoshee on 28/04/16.
 */
public class NStepsBottomUpDynamic {
    public static void main(String args[]){
        System.out.println(stepUp(5));
    }

    private static int stepUp(int noOfSteps){
        int[] dp = new int[noOfSteps+1];
        dp[0]=1;
        dp[1]=1;

        for(int i=2; i<=noOfSteps; i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[noOfSteps];
    }
}