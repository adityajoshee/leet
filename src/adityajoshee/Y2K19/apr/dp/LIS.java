package adityajoshee.Y2K19.apr.dp;

import java.util.Arrays;

/**
 * @author Aditya Joshee
 */
public class LIS {
    public static void main(String[] args) {
        int[] input = {50, 3, 10, 7, 40, 80};
        System.out.println(lenOfLIS(input, 0, Integer.MIN_VALUE));
        System.out.println(lenOfLisDp(input));
    }

    private static int lenOfLIS(int[] input, int p, int prev) {
        if (p==input.length){
            return 0;
        }
        if (input[p]>prev){
            return Math.max(1+lenOfLIS(input, p+1, input[p]),  lenOfLIS(input, p+1, prev));
        }
        return lenOfLIS(input, p+1, prev);
    }

    private static int lenOfLisDp(int[] input){
        int[] dp = new int[input.length];
//        dp[0]=1;
        for (int i=0; i<dp.length; i++){
            dp[i]=1; // need to init all to 1
        }
        for (int i=1; i<input.length; i++){
            for (int j=0; j<i; j++){
                if (input[j]<input[i]){
                    dp[i] = dp[i] < 1+dp[j] ? 1 + dp[j] : dp[i];
                }
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }

}
