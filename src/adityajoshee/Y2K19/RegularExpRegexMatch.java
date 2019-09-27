package adityajoshee.Y2K19;

import adityajoshee.dsa.matrix.PrintMatrix;

import java.util.Arrays;

/**
 * Created by aditya.joshee on 2019-09-09.
 */
public class RegularExpRegexMatch {
    public static void main(String[] args) {
        System.out.println(match("abc", "*c*"));
    }

    private static boolean match(String input, String pat) {
        return iterativeConstantSpace(input, pat); // Only O(n) space
//        return matchDP(input, pat);
//        return matchInefficientRecursionDFS(0, 0, input, pat);
    }

    private static boolean matchDPSpaceOpt(String input, String pat) {
        boolean[] dp = new boolean[input.length()+1];
        dp[0] = true;

        for(int i=1; i<dp.length; i++){
            dp[i] = false;
        }


        for (int i=1; i<dp.length; i++){
            for (int j=0; j<pat.length(); j++){
                System.out.println(Arrays.toString(dp));
                if((input.charAt(i-1)==pat.charAt(j)) || pat.charAt(j)=='?'){
                    dp[i] = dp[i-1];
                }
                else if(pat.charAt(j)!='*' && input.charAt(i-1)!=pat.charAt(j)){
                    dp[i] = false;
                }
                else{
                    dp[i] = dp[i] || dp[i-1];
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[dp.length-1];
    }

    private static boolean matchDP(String input, String pat) {
        boolean[][] dp = new boolean[input.length()+1][pat.length()+1];
        dp[0][0] = true;

        for(int i=1; i<dp.length; i++){
            dp[i][0]=false;
        }
        for(int j=1; j<dp[0].length; j++){
            dp[0][j]=pat.charAt(j-1)=='*' ? dp[0][j-1] : false;
        }
        PrintMatrix.printb(dp);

        for (int i=1; i<dp.length; i++){
            for (int j=1; j<dp[0].length; j++){
                if((input.charAt(i-1)==pat.charAt(j-1)) || pat.charAt(j-1)=='?'){
                    dp[i][j] = dp[i-1][j-1];
                }
                else if(pat.charAt(j-1)!='*' && input.charAt(i-1)!=pat.charAt(j-1)){
                    dp[i][j] = false;
                }
                else{
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
                }
            }
        }
        PrintMatrix.printb(dp);

        return dp[dp.length-1][dp[0].length-1];
    }

    private static boolean matchInefficientRecursionDFS(int i, int p, String input, String pat) {
        System.out.println(i+", "+p);
        while(p<pat.length()-1 && pat.charAt(p)=='*' && pat.charAt(p+1)=='*'){
            //move ahead of consecutive *s
            p++;
        }
        if(i==input.length()) {
            if (p == pat.length()) return true;
            if (p == pat.length() - 1 && pat.charAt(p) == '*') return true;
            if (p < pat.length()) return false;
        }

        if(i<input.length() && p==pat.length()){
            // pattern ends but input remains
            return false;
        }
        if (pat.charAt(p)=='?' || (i<input.length() && input.charAt(i)==pat.charAt(p))){
            //ignore input char and move both input and pattern ahead by 1 or the exact char matches with pattern
            return matchInefficientRecursionDFS(i+1, p+1, input, pat);
        }
        if (pat.charAt(p)=='*'){
            // 2 possibilities
            return  matchInefficientRecursionDFS(i, p+1, input, pat) || matchInefficientRecursionDFS(i+1, p, input, pat) ;
        }
        return false;
    }

    static boolean iterativeConstantSpace(String str, String pattern) {
        int s = 0, p = 0, match = 0, starIdx = -1;
        while (s < str.length()){
            // advancing both pointers
            if (p < pattern.length()  && (pattern.charAt(p) == '?' || str.charAt(s) == pattern.charAt(p))){
                s++;
                p++;
            }
            // * found, only advancing pattern pointer
            else if (p < pattern.length() && pattern.charAt(p) == '*'){
                starIdx = p;
                match = s;
                p++;
            }
            // last pattern pointer was *, advancing string pointer
            else if (starIdx != -1){
                System.out.println();
                p = starIdx + 1;
                match++;
                s = match;
            }
            //current pattern pointer is not star, last patter pointer was not *
            //characters do not match
            else return false;
        }

        //check for remaining characters in pattern
        while (p < pattern.length() && pattern.charAt(p) == '*')
            p++;

        return p == pattern.length();
    }
}
