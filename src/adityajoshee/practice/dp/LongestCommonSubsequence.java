package adityajoshee.practice.dp;

/**
 * Created by aditya on 9/12/16.
 */
// Longest Common Subsequence
public class LongestCommonSubsequence {
    public static void main(String args[]) {
        char[] s1 = "asd".toCharArray();
        char[] s2 = "akd".toCharArray();
        System.out.println(findLCS(s1, s2));
    }
    private static int findLCS(char[] a, char[] b){
        int[][] aux = new int[a.length+1][b.length+1];
        for (int i = 0; i <= a.length; i++) {
            aux[i][0] = 0; // since size of string b will be 0 here...LCS will be 0
        }
        for (int i = 0; i <= b.length; i++) {
            aux[0][i] = 0; // since size of string a will be 0 here...LCS will be 0
        }
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                if(a[i]==b[j]){
                    aux[i+1][j+1] = 1 + aux[i][j];
                }
                else {
                    aux[i+1][j+1] = Math.max(aux[i][j+1],aux[i+1][j]);
                }
            }
        }
        return aux[a.length][b.length];
    }

}
