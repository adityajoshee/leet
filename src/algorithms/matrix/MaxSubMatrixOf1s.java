package algorithms.matrix;

/**
 * Created by aditya on 8/28/16.
 */

//http://www.geeksforgeeks.org/maximum-size-sub-matrix-with-all-1s-in-a-binary-matrix/
public class MaxSubMatrixOf1s {
    public static void main(String args []){
        int[][] matrix = new int[][] {
                {0,1,1,0,1},
                {1,1,0,1,0},
                {0,1,1,1,0},
                {1,1,1,1,0},
                {1,1,1,1,1},
                {0,0,0,0,0}};
        int[][] aux = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix[0].length; i++) {
            aux[0][i] = matrix[0][i];
        }
        for (int i = 0; i < matrix.length; i++) {
            aux[i][0] = matrix[i][0];
        }
        find(matrix, aux);
    }
    private static void find(int[][] matrix, int[][] aux){
        int min=0;
        for(int i=1; i<aux.length; i++){
            for(int j=1; j<aux[0].length; j++){
                if(matrix[i][j]==1){
                    int l = aux[i][j-1];
                    int d = aux[i-1][j-1];
                    int u = aux[i-1][j];
                    min = Math.min(Math.min(l,u),d);
                    aux[i][j] = matrix[i][j] + min;
                }
                else{
                    // do nothing for 0 cell value
                }
            }
        }
        PrintMatrix.print(aux);
    }
}