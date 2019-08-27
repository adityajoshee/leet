package adityajoshee.dsa.dp;

/**
 * Created by aditya.joshee on 2019-08-17.
 */
public class LongestPalindromicSubstringSpaceOpt {
    public static void main(String[] args){
        System.out.println(longestPalindrome("abaebc"));
    }

    private static String longestPalindrome(String str) {
        char[] s = str.toCharArray();
        int max = 0;
        String maxPalin = "";
        for(int i=0; i<s.length-1; i++){
            int oddLen = expand(s, i, i);
            int evenLen = expand(s, i, i+1);
            int m = Math.max(oddLen, evenLen);
            if(max<m){
                max = m;
                int start = i - (m-1)/2;
                maxPalin = str.substring(start, start+m);
            }
        }
        System.out.println(max);
        return maxPalin;
    }

    private static int expand(char[] s, int l, int r) {
        while(l>=0 && r<s.length && s[l]==s[r]){
            l--;
            r++;
        }
        return r-l-1;
    }


    // On*n space solution
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
