package adityajoshee.dsa.strings;

import adityajoshee.dsa.matrix.PrintMatrix;

import java.util.Arrays;

/**
 * Created by aditya.joshee on 2019-09-21.
 */
public class Regex {
    public static void main(String[] args) {
        System.out.println(match("aaa", "ab*a*c*a"));
    }
    private static boolean match(String s, String p) {
        boolean dp[][] = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true; // empty str matches empty pattern
        for(int j=1; j<dp[0].length; j++){
            if(p.charAt(j-1)=='*'){
                dp[0][j] = dp[0][j-2];
            }
            else {
                dp[0][j] = false;
            }

        }
        System.out.println(Arrays.toString(dp[0]));
        for(int i=1; i < dp.length; i++){
            for (int j = 1; j < dp[i].length; j++) {

                if (s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='.'){
                    //match 1 char of string to 1 char of pattern
                    dp[i][j] = dp[i-1][j-1];
                }
                else if(p.charAt(j-1)=='*' && p.charAt(j-2)=='.'){
                    // match 0 times the char previous to *
                    dp[i][j] = dp[i][j-2] || dp[i-1][j-1] || dp[i-1][j];
                }
                else if(p.charAt(j-1)=='*' && p.charAt(j-2)!='.'){
                    if(s.charAt(i-1)==p.charAt(j-2)){
                        dp[i][j] = dp[i-1][j-1] || dp[i-1][j] || dp[i][j-2];
                    }
                    else {
                        dp[i][j] = dp[i][j-2];
                    }
                }

            }
            System.out.println(Arrays.toString(dp[i]));
        }
        return dp[dp.length-1][dp[0].length-1];
    }
}
