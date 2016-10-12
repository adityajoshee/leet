package algorithms.backtracking;

/**
 * Created by adityajoshee on 23/04/16.
 */
public class NQueens {
    public static void main(String args[]){
        nqueens(initBoard(8),8,0);
    }

    private static void nqueens(int[][] currentBoard,int boardSize,int row){

        if(row==boardSize){
            // done
            System.out.println("A solution found...");
            printCurrentBoard(currentBoard);
            return;
        }
        for(int j=0;j<=boardSize-1;j++){
            if(isValidPosition(currentBoard,row,j,boardSize)){
                currentBoard[row][j]=1;
                //printCurrentBoard(currentBoard);
                nqueens(currentBoard, boardSize, row + 1);
                currentBoard[row][j]=0;
            }
            else{
                if(j==boardSize-1)
                    return;
            }
        }


    }


    private static boolean isValidPosition(int[][] currentBoard,int i, int j,int boardSize){
        for(int k=0;k<=i;k++){
            if(currentBoard[k][j]==1){
                return false;
            }
            for(int l=0;l<boardSize;l++){

                if(Math.abs(i-k)==Math.abs(j-l) && currentBoard[k][l]==1){
                    return false;
                }

                if(k==i && currentBoard[i][l]==1){
                    return false;
                }
            }
        }
        return true;
    }

    private static int[][] initBoard(int n){
        int[][] newboard =new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                newboard[i][j]=0;
            }
        }
        return newboard;
    }

    private static void printCurrentBoard(int[][] c){
        for (int i=0;i<c.length;i++){
            for(int j=0;j<c.length;j++){
                System.out.print(" "+c[i][j]);
            }
            System.out.println();
        }
    }

}
