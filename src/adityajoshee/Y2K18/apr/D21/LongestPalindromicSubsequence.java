package adityajoshee.Y2K18.apr.D21;

import adityajoshee.dsa.matrix.PrintMatrix;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by aditya.joshee on 4/22/18.
 */
public class LongestPalindromicSubsequence {
    public static void main(String[] args) {
        String s = "aaaa";
        System.out.println("longest length ="+find(s.toCharArray()));
    }

    private static int find(char[] chars) {
        int[][] dp = new int[chars.length][chars.length];
        for (int i = 0; i < chars.length; i++) {
            dp[i][i]=1;
        }
        for (int len = 2; len <= chars.length; len++) {
            for (int i = 0; i < chars.length-len+1; i++) {
                int j = i + len - 1; // j is the last index of current substring
                if (chars[i]==chars[j]){
                    dp[i][j] = 2 + dp[i+1][j-1];
                }
                else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i+1][j]);
                }
            }
        }
        PrintMatrix.print(dp);
//        printSubseq(dp[0], chars, dp[0][chars.length-1]);
        return dp[0][chars.length-1];
    }

//    private static void printSubseq(int[] arr, char[] chars, int longestSize) {
//        int middleCharIndex = -1;
//        Stack<Integer> stack = new Stack<>();
//        List<Integer> list = new LinkedList<>();
//        for (int i  = arr.length-2; i >= 0; i--) {
//            if (arr[i]!=arr[i+1]){
//                middleCharIndex = i;
//                stack.push(i+1);
//                list.add(i+1);
//            }
//        }
//        if (longestSize%2!=0){
//            stack.push(middleCharIndex);
//        }
//        for (Integer i: list){
//            System.out.print(chars[i]+" ");
//        }
//        while (!stack.empty()){
//            System.out.print(chars[stack.pop()]+" ");
//        }
//        System.out.println();
//    }
}
