package adityajoshee.dsa.dp;

/**
 * Created by adityajoshee on 28/04/16.
 *
 * // Solution using DP
 * O(n*n) time & O(n*n) space
 */

public class LongestPalindromeSubstring {
    public static void main(String[] a) {
        String input = "XXSAFASAXXFFXX";
        char[] ip = input.toCharArray();
        //System.out.print(isPalindrome(ip,0,ip.length-1));
        if (ip.length > 1) {
            System.out.println(getLength(ip));
        }
    }

    private static int getLength(char[] input) {
        boolean[][] dp = new boolean[input.length][input.length];
        int maxlen = 1; // by default single char is a palindr
        for (int l = 1; l <= input.length ; l++) {
            for (int i = 0; i < input.length; i++) {
                if(l==1){
                    dp[i][i] = true; // single char string
                }
                else if(l==2 && i+1<input.length){
                    if(input[i] == input[i+1]){
                        dp[i][i+l-1] = true;
                        maxlen = maxlen < l ? l : maxlen;
                    }
                }
                else {
                    if(i+l-1 < input.length){
                        if(input[i] == input[i+l-1] && dp[i+1][i+l-2]){
                            dp[i][i+l-1] = true;
                            maxlen = maxlen < l ? l : maxlen;
                        }
                        else {
                            dp[i][i+l-1] = false;
                        }
                    }
                }
            }

        }
        return maxlen;
    }
}
