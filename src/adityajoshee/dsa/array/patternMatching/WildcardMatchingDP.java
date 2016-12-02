package adityajoshee.dsa.array.patternMatching;

import adityajoshee.dsa.matrix.PrintMatrix;

/**
 * Created by aditya on 10/25/16.
 */
public class WildcardMatchingDP {
    public static void main(String args[]){

        char[] input = "asmd".toCharArray();
        char[] wildcard = "*as?d*".toCharArray();

        System.out.println(match(input,wildcard));
    }
    private static boolean match(char[] input, char[] wildcard){
        boolean dp[][] = new  boolean[input.length+1][wildcard.length+1];
        dp[0][0] = true;
        for (int j = 1; j <= wildcard.length; j++) {
            if (wildcard[j-1]=='*')
            dp[0][j] = dp[0][j-1];
        }
        for (int i = 1; i <= input.length; i++) {
            dp[i][0] = false;
        }

        for (int i = 1; i <= input.length; i++) {
            for (int j = 1; j <= wildcard.length; j++) {
                if (wildcard[j-1] == '*'){
                    dp[i][j] = dp[i][j-1] || dp[i-1][j];
                }
                else if (wildcard[j-1] == '?'){
                    dp[i][j] = dp[i-1][j-1];
                }
                else{
                    dp[i][j] = dp[i-1][j-1] && input[i-1]==wildcard[j-1];
                }
            }
        }
        PrintMatrix.printb(dp);
        return dp[input.length][wildcard.length];
    }

}
