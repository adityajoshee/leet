package adityajoshee.Y2K18.mar.D18;

import java.util.Scanner;

/**
 * Created by aditya.joshee on 3/18/18.
 */
public class LCS {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();
        System.out.println( findLCS(s1.length()-1, s1.toCharArray(), s2.length()-1, s2.toCharArray()));
        System.out.println(findLCSDynProg(s1.toCharArray(), s2.toCharArray()));
    }

    private static int findLCS(int ai, char[] a, int bi, char[] b) {
        if (ai<0 || bi<0){
            return 0;
        }
        return a[ai]==b[bi] ? 1+findLCS(ai-1, a, bi-1, b) :
                Math.max(findLCS(ai-1, a, bi, b),
                         findLCS(ai, a, bi-1, b));
    }
    private static int findLCSDynProg(char[] a, char[] b){
        int[][] dp = new int[a.length+1][b.length+1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (a[i-1]==b[j-1]){
                    dp[i][j] = dp[i-1][j-1]+1;
                }
                else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }

    private static int findLCSSpaceOpt(char[] a, char[] b){
        // TODO
        return 0;
    }
}
