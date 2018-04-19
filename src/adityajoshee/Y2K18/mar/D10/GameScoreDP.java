package adityajoshee.Y2K18.mar.D10;

import java.util.Scanner;

/**
 * Created by aditya.joshee on 3/10/18.
 */
//Count number of ways to reach a given score in a game

public class GameScoreDP {
    public static void main(String[] args) {
        int x= new Scanner(System.in).nextInt();
        System.out.println(findInclPermutations(x));
        System.out.println(findExclPermutations(x));
        int[] scores = {3,5,10};
        System.out.println(findExclPerms(x, scores));
    }

    private static int findInclPermutations(int N) {
        if (N==0){
            return 1;
        }
        if (N<3){
            return 0;
        }
        return findInclPermutations(N-3) + findInclPermutations(N-5) + findInclPermutations(N-10);
    }

    private static int findExclPermutations(int N){
        int[] dp = new int[N+1];
        dp[0] = 1; //init
        for (int i = 3; i <= N ; i++) {
            dp[i] = dp[i] + dp[i-3];
        }
        for (int i = 5; i <= N ; i++) {
            dp[i] = dp[i] + dp[i-5];
        }
        for (int i = 10; i <= N ; i++) {
            dp[i] = dp[i] + dp[i-10];
        }
        return dp[N];
    }

    private static int findExclPerms(int N, int[] scores){
        int[] dp = new int[N+1];
        dp[0] = 1; //init

        for (int i = 0; i < scores.length; i++) {
            for (int j = scores[i]; j <= N; j++) {
                dp[j] = dp[j] + dp[j-scores[i]];
            }
        }
        return dp[N];
    }
}
