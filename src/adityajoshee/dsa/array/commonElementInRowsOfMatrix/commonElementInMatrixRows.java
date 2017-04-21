package adityajoshee.dsa.array.commonElementInRowsOfMatrix;

import adityajoshee.dsa.matrix.PrintMatrix;

import java.util.Arrays;

/**
 * Created by aditya.j on 3/29/17.
 */
// find single common element if present
//http://www.geeksforgeeks.org/find-common-element-rows-row-wise-sorted-matrix/

public class commonElementInMatrixRows {
    public static void main(String args[]){
        int[][] matrix = {
                {6,2,3,1},
                {6,3,4,5},
                {3,4,5,6},
                {7,0,6,1}
                        };
        System.out.println(find(matrix));
    }
    private static int find(int[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            Arrays.sort(matrix[i]);
        }
        PrintMatrix.print(matrix);
        int[] lastCol = new int[matrix.length];
        Arrays.fill(lastCol, matrix[0].length-1);

        int row = 0; // init
        int col = matrix[0].length-1;
        boolean allRowsHaveSameValue = true;
        while (col>=0){
            for (int i = 0; i < matrix.length; i++) {
                if (matrix[i][lastCol[i]]>matrix[row][col]){
                    if (lastCol[i]==0){
                        return -1;
                    }
                    lastCol[i]--;
                    allRowsHaveSameValue = false;
                }
                else if (matrix[i][lastCol[i]]<matrix[row][col]){
                    row=i;
                    col=lastCol[i];
                    allRowsHaveSameValue = false;
                }
            }
            if (allRowsHaveSameValue){
                break;
            }
            allRowsHaveSameValue = true;
        }
        if(allRowsHaveSameValue){
            return matrix[row][col];
        }
        return -1;
    }
}
