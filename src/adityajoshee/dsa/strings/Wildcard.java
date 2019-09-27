package adityajoshee.dsa.strings;

/**
 * Created by aditya.joshee on 2019-09-22.
 */
public class Wildcard {
    public static void main(String[] args) {
        System.out.println(match("aditya", "*?"));
    }

    private static boolean match(String s, String p) {
        boolean dp[][] = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;
        for(int j=1; j<dp[0].length; j++){ // for empty string, match subpattern in pattern (0,j)
            if (p.charAt(j-1)!='*'){
                break;
            }
            else {
                dp[0][j] = true; // since all remaining iterations will be false, as the len of str is 0
            }
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if(s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='?'){
                    dp[i][j] = dp[i-1][j-1];
                }
                else if(p.charAt(j-1)=='*'){
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
                }
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }
}
