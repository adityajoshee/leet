package adityajoshee.Y2K18.may.D12;

import adityajoshee.dsa.matrix.PrintMatrix;

/**
 * Created by aditya.joshee on 5/12/18.
 */
public class Sudoku {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        int[][] arr = {{3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0}};
        solve(arr);
    }

    private static boolean solve(int[][] arr) {
        boolean finished = true;
        int i=0,j=0;
        for ( int m = 0; m < arr.length; m++) {
            for ( int n = 0; n < arr.length; n++) {
                if (arr[m][n]==0){
                    i = m;
                    j = n;
                    finished = false;
                    break;
                }
            }
        }
        if (finished){
            //sudoku cracked
            PrintMatrix.print(arr);
            return true;
        }
        if (arr[i][j]==0){
            for (int k = 1 ; k <= 9; k++) {
                if(isValid(arr, i, j, k)){
                    arr[i][j] = k;
                    if (solve(arr)){
                        return true;
                    }
                    arr[i][j] = 0;
                }
            }
        }
        return false;
    }

    private static boolean isValid(int arr[][], int x, int y, int num){
        return validPutSubmatrix(arr, x, y, num) &&
                validPutRow(arr, x, y, num) &&
                validPutCol(arr, x, y, num);
    }

    private static boolean validPutRow(int[][] arr, int x, int y, int num) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[x][i]==num){
                return false;
            }
        }
        return true;
    }

    private static boolean validPutCol(int[][] arr, int x, int y, int num) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i][y]==num){
                return false;
            }
        }
        return true;
    }

    private static boolean validPutSubmatrix(int arr[][], int x, int y, int num){
        int m = 3*(x/3);
        int n = 3*(x/3 + 1);
        int p = 3*(y/3);
        int r = 3*(y/3 + 1);

        for (int i = m; i < n; i++) {
            for (int j = p; j < r; j++) {
                if (arr[i][j]==num){
                    return false;
                }
            }
        }
        return true;
    }
}
