package adityajoshee.Y2K19.apr.dp;


import adityajoshee.dsa.matrix.PrintMatrix;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Aditya Joshee
 */
public class Wordbreak {
    public static void main(String[] args) {
        String s = "Wordbreakproblem";
        String[] dict = {"this", "th", "is", "famous", "Word", "break", "b",
"r", "e", "a", "k", "br", "bre", "brea", "ak", "problem"};
        System.out.println(determine(s,dict));
        HashSet<String>  dictset = new HashSet<>(Arrays.asList(dict));
        System.out.println(determineDP(s, dictset));
    }

    private static boolean determine(String s, String[] dict) {
        if (s.length()==0){
            return true;
        }
        for (int i=1; i<=s.length(); i++){
            for (int j=0; j<dict.length; j++) {
                if(dict[j].equals(s.substring(0,i))){
                    if(determine(s.substring(i), dict)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean determineDP(String s, Set<String> dict){
        boolean[][] dp = new boolean[s.length()][s.length()];

        for (int i=0; i<dp.length; i++) {
            if (dict.contains(s.substring(i,i+1))){
                dp[i][i]=true;
            }
        }


        for (int size=2; size<=dp.length; size++){
            for (int j=0; j<dp[0].length-size+1; j++){
                if (dict.contains(s.substring(j,j+size))){
                    dp[j][j+size-1]=true;
                    continue;
                }
                for (int k=j; k<j+size-1; k++){
                    if (dp[j][k] && dp[k+1][j+size-1]){
                        dp[j][j+size-1] = true;
                        continue;
                    }
                }
            }
        }
        PrintMatrix.printb(dp);

        return dp[0][dp[0].length-1];
    }
}
