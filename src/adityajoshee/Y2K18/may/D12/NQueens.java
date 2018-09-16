package adityajoshee.Y2K18.may.D12;

import adityajoshee.dsa.matrix.PrintMatrix;

/**
 * Created by aditya.joshee on 5/12/18.
 */
public class NQueens {
    public static void main(String[] args) {
        int N = 8;
        displayPlacing(N);
    }

    private static void displayPlacing(int n) {
        boolean[][] arr = new boolean[n][n];
        exe(arr, 0);
    }

    private static void exe(boolean[][] arr, int q) {
        if (arr.length==q){
            PrintMatrix.printb(arr);
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = q; j < arr.length; j++) {
                if (!canAttack(arr, i, j)){
                    arr[i][j] = true;
                    exe(arr, q+1);
                    arr[i][j] = false; //backtrack .. if prev doesn't work or for finding other solutions
                }
            }
        }

    }

    private static boolean canAttack(boolean[][] arr, int x, int y){
        if (arr[x][y]){
            return true;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[x][i]){
                return true;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i][y]){
                return true;
            }
        }
        int m = x, n = y;
        while (m < arr.length && n < arr.length){
            if (arr[m++][n++]){
                return true;
            }
        }
        m = x; n = y;
        while (m >=0 && n >=0){
            if (arr[m--][n--]){
                return true;
            }
        }
        m = x; n = y;
        while (m >=0 && n < arr.length){
            if (arr[m--][n++]){
                return true;
            }
        }
        m = x; n = y;
        while (m < arr.length && n >=0){
            if (arr[m++][n--]){
                return true;
            }
        }
        return false;
    }
}
