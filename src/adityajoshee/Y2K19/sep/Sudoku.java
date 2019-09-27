package adityajoshee.Y2K19.sep;

import adityajoshee.dsa.matrix.PrintMatrix;

/**
 * Created by aditya.joshee on 2019-09-23.
 */
public class Sudoku {
    public static void main(String[] args) {
        char[][]c = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        solveSudoku(c);
    }

    public static void solveSudoku(char[][] board) {
    /*
    Strategy : Try to make a move under constraints. If move is possible then
    make the move and recurse for the new sub problem. If previous move led to
    overall success then return the board else undo the last move and try another move by putting         some other number.
    */

        solve(0, 0, board);
    }
    private static boolean solve(int i, int c, char[][] board){
        PrintMatrix.printc(board);
        if(i==9 || (i==8 && c==9)){
            // finished
            return true;
        }
        if(c==9){
            System.out.println("incr row to "+ (i+1));
            c=0;i++;
        }

        for(int j=c; j<9; j++){
            if(board[i][j]=='.'){
                for(char k='1'; k<='9'; k++){
                    if(valid(i, j, k, board)){
                        board[i][j]=k;
                        if (solve(i, j+1, board)){
                            return true;
                        }
                        board[i][j]='.';
                    }
                }
                return false;
            }
        }
        return solve(i+1, 0, board);
    }
    private static boolean valid(int x, int y, char k, char[][] board){
        for(int j=0; j<9; j++){
            if(board[x][j]==k) return false;
        }
        for(int i=0; i<9; i++){
            if(board[i][y]==k) return false;
        }
        for(int i=3*(x/3); i<3*(x/3)+3; i++){
            for(int j=3*(y/3); j<3*(y/3)+3; j++){
                if(board[i][j]==k) return false;
            }
        }
        return true;
    }

}
