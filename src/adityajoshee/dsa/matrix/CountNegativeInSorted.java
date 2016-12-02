package adityajoshee.dsa.matrix;

/**
 * Created by aditya on 10/8/16.
 */
//http://www.geeksforgeeks.org/count-negative-numbers-in-a-column-wise-row-wise-sorted-matrix/
// assuming square matrix

public class CountNegativeInSorted {
    public static void main(String args[]){
        int[][] matrix = {
                {-6,-4,-2,-1},
                {-3,-2, -1, 5},
                {-2, 2, 5, 6},
                {0, 4, 8, 9}
        };
        System.out.println(get(matrix));
    }

    private static int get(int[][] matrix){
        int i=0;
        int j=matrix.length-1;
        // start with top right corner element

        int count = 0;

        while (i<matrix.length && j>=0){
            //get the first -ve element in the current row
            while (j>=0 && !isNeg(matrix[i][j])) {
                j--;
            }
            if(j>=0){
                count += j+1; // all elements from 0...j will be -ve
                i++;
            }
        }
        return count;
    }

    private static boolean isNeg(int x){
        return x<0 ? true : false;
    }
}
