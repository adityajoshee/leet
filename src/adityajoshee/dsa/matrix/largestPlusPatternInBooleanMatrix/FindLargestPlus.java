package adityajoshee.dsa.matrix.largestPlusPatternInBooleanMatrix;

import adityajoshee.dsa.matrix.PrintMatrix;

/**
 * Created by aditya on 11/20/16.
 */
/*
http://www.geeksforgeeks.org/find-size-of-the-largest-formed-by-all-ones-in-a-binary-matrix/
 */
public class FindLargestPlus {
    public static void main(String args[]){
        int[][] matrix =     {
                { 1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
                { 1, 0, 1, 0, 1, 1, 1, 0, 1, 1 },
                { 1, 1, 1, 0, 1, 1, 0, 1, 0, 1 },
                { 0, 0, 0, 0, 1, 0, 0, 1, 0, 0 },
                { 1, 1, 1, 0, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 0 },
                { 1, 0, 0, 0, 1, 0, 0, 1, 0, 1 },
                { 1, 0, 1, 1, 1, 1, 0, 0, 1, 1 },
                { 1, 1, 0, 0, 1, 0, 1, 0, 0, 1 },
                { 1, 0, 1, 1, 1, 1, 0, 1, 0, 0 }
        };
        System.out.println(find(matrix));
    }
    private static int find(int[][] matrix){
        int[][] upCountOfOnes = new int[matrix.length][matrix[0].length];
        int[][] downCountOfOnes = new int[matrix.length][matrix[0].length];
        int[][] leftCountOfOnes = new int[matrix.length][matrix[0].length];
        int[][] rightCountOfOnes = new int[matrix.length][matrix[0].length];
        buildAuxMatrices(matrix,upCountOfOnes,downCountOfOnes,leftCountOfOnes,rightCountOfOnes);
        int maxLen = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j]==1){
                    int mi = minOf(upCountOfOnes[i][j], downCountOfOnes[i][j], rightCountOfOnes[i][j], leftCountOfOnes[i][j]);
                    maxLen = maxLen<mi ? mi : maxLen;
                }
            }
        }
        return maxLen;

    }

    private static int minOf(int a, int b, int c, int d){
        int[] arr = {a,b,c,d};
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            min = arr[i]<min ? arr[i] : min;
        }
        return min;
    }
    private static void buildAuxMatrices(int[][] matrix,int[][] upCountOfOnes, int[][] leftCountOfOnes, int[][] rightCountOfOnes, int[][] downCountOfOnes){

        for (int i = 0; i < matrix.length; i++) {
            leftCountOfOnes[i][0] = 0;
        }
        for (int i = 0; i < matrix.length; i++) {
            rightCountOfOnes[i][matrix[0].length-1] = 0;
        }
        for (int i = 0; i < matrix[0].length; i++) {
            upCountOfOnes[0][i] = 0;
        }
        for (int i = 0; i < matrix[0].length; i++) {
            downCountOfOnes[matrix.length-1][i] = 0;
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                leftCountOfOnes[i][j] = matrix[i][j-1]==0?0:matrix[i][j-1] + leftCountOfOnes[i][j-1];
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = matrix[0].length-2; j >= 0; j--) {
                rightCountOfOnes[i][j] = matrix[i][j+1]==0?0:matrix[i][j+1] + rightCountOfOnes[i][j+1];
            }
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                upCountOfOnes[i][j] = matrix[i-1][j]==0?0:matrix[i-1][j] + upCountOfOnes[i-1][j];
            }
        }
        for (int i = matrix.length-2; i >= 0; i--) {
            for (int j = 0; j < matrix[0].length; j++) {
                downCountOfOnes[i][j] = matrix[i+1][j]==0?0:matrix[i+1][j] + downCountOfOnes[i+1][j];
            }
        }
        PrintMatrix.print(leftCountOfOnes);
        PrintMatrix.print(rightCountOfOnes);
        PrintMatrix.print(upCountOfOnes);
        PrintMatrix.print(downCountOfOnes);

    }

}
