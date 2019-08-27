package adityajoshee.Y2K19.apr.dp;

import adityajoshee.dsa.matrix.PrintMatrix;

/**
 * @author Aditya Joshee
 */
public class LCS {
    public static void main(String[] args) {
        String s1 = "ABCBDABABCBDABABCBDABABCBDABABCBDABABCBDABABCBDABABCBDABABCBDABABCBDABABCBDABABCBDABABCBDABABCBDABABCBDABABCBDAB";
        String s2 = "BDCABABDCABABDCABABDCABABDCABABDCABA";
        long t1 = System.currentTimeMillis();
        System.out.println(findLengthOfLCS(s1.toCharArray(), s1.length()-1, s2.toCharArray(), s2.length()-1));
        long t2 = System.currentTimeMillis();
        System.out.println(t2-t1);
        System.out.println(findUsingDP(s1.toCharArray(), s2.toCharArray()));
        long t3 = System.currentTimeMillis();
        System.out.println(t3-t2);

    }

    private static int findLengthOfLCS(char[] s1, int i, char[] s2, int j) {
        if (i<0 || j<0){ // no chars left in at least 1 of s1 or s2
            return 0;
        }
        if (s1[i]==s2[j]){
            return 1+findLengthOfLCS(s1,i-1,s2,j-1);
        }
        else {
            return Math.max(findLengthOfLCS(s1,i-1,s2,j), findLengthOfLCS(s1,i,s2,j-1));
        }
    }

    private static int findUsingDP(char[] s1, char[] s2){
        int[][] matrix = new int[s1.length+1][s2.length+1];
        for (int a = 0; a<matrix[0].length; a++){
            matrix[0][a] = 0;
        }
        for (int a = 0; a<matrix.length; a++){
            matrix[a][0] = 0;
        }

        for (int i = 1; i < matrix.length; i++){
            for (int j = 1; j < matrix[0].length; j++){
                if (s1[i-1]==s2[j-1]){
                    matrix[i][j] = 1 + matrix[i-1][j-1];
                }
                else {
                    matrix[i][j] = Math.max(matrix[i-1][j], matrix[i][j-1]);
                }
            }
        }

//        PrintMatrix.print(matrix);
        return matrix[matrix.length-1][matrix[0].length-1];
    }
}
