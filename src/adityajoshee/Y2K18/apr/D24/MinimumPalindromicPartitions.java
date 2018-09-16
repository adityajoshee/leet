package adityajoshee.Y2K18.apr.D24;

import adityajoshee.dsa.matrix.PrintMatrix;

/**
 * Created by aditya.joshee on 4/22/18.
 */
public class MinimumPalindromicPartitions {
    public static void main(String[] args) {
        String s = "ababbbabbababa";
        System.out.println(find(s.toCharArray()));
        System.out.println(optimal(s.toCharArray()));
    }

    // On*n*n solution
    private static int find(char[] str) {
        int[][] dp = new int[str.length][str.length];
        for (int len = 1; len <= str.length; len++) {
            for (int i = 0; i < str.length-len+1; i++) {
                int j = i+len-1;

                if (len==1){
                    dp[i][j] = 0; // since single char is palindrome itself
                }
                else if (len==2){
                    if (str[i]==str[j]){
                        dp[i][j] = 0;
                    }
                    else {
                        dp[i][j] = 1;
                    }
                }
                else {
                    if (str[i]!=str[j]){
                        int min = Integer.MAX_VALUE;
                        for (int split = i; split < j; split++) {
                            min = Math.min(min, dp[i][split] + dp[split+1][j]);
                        }
                        dp[i][j] = 1 + min;
                    }
                    else if(dp[i+1][j-1]==0){ // means str(i,j) is palindrome
                        dp[i][j] = 0;
                    }
                    else {
                        dp[i][j] = 1+Math.min(dp[i][j-1], dp[i+1][j]);
                    }
                }
            }
        }
        PrintMatrix.print(dp);
        return dp[0][dp[0].length-1];
    }

    // On*n solution
    private static int optimal(char[] str){
        boolean[][] isPalindrome = new boolean[str.length][str.length];
        int[] minPartition = new int[str.length];
        for (int len = 1; len <= str.length; len++) {
            for (int i = 0; i < str.length-len+1; i++) {
                int j = i+len-1;
                if (len==1){
                    isPalindrome[i][j] = true;
                }
                else if(len==2){
                    isPalindrome[i][j] = str[i]==str[j];
                }
                else{
                    isPalindrome[i][j] = str[i]==str[j] && isPalindrome[i+1][j-1];
                }
            }
        }
        for (int i = 0; i < str.length; i++) {
            if (isPalindrome[0][i]){
                minPartition[i] = 0;
            }
            else {
                minPartition[i] = Integer.MAX_VALUE;
                for (int j = 0; j < i; j++) {
                    if (isPalindrome[j+1][i] && minPartition[j]+1<minPartition[i])
                    minPartition[i] = minPartition[j]+1;
                }
            }
        }
        return minPartition[str.length-1];
    }
}
