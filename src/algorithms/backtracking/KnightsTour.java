package algorithms.backtracking;

/**
 * Created by adityajoshee on 28/04/16.
 */
public class KnightsTour {
    public static void main(String args[]){
        int[][] board =  initBoard(6);
        board[0][0]=1;  // value of the boxes will be the no. of moves taken for reaching current box
        knightsTour(board,0,0,1); // knight has taken 1st step as 0,0
    }

    private static void knightsTour(int[][] currentBoard,int x, int y, int steps){
        //printCurrentBoard(currentBoard);

        if(steps==currentBoard.length*currentBoard.length){
            // tour complete
            printCurrentBoard(currentBoard);
            System.exit(0);
            return;
        }

        // We can also consolidate the code below by using a pair of array for x and y moves each and looping over it.

        if(isValidMove(currentBoard,x-2,y-1)){
            currentBoard[x-2][y-1] = steps+1;
            knightsTour(currentBoard,x-2,y-1,steps+1);
            currentBoard[x-2][y-1] = -1;

        }

        if(isValidMove(currentBoard,x-2,y+1)){
            currentBoard[x-2][y+1] = steps+1;
            knightsTour(currentBoard,x-2,y+1,steps+1);
            currentBoard[x-2][y+1] = -1;

        }
        if(isValidMove(currentBoard,x+2,y-1)){
            currentBoard[x+2][y-1] = steps+1;
            knightsTour(currentBoard,x+2,y-1,steps+1);
            currentBoard[x+2][y-1] = -1;

        }
        if(isValidMove(currentBoard,x+2,y+1)) {
            currentBoard[x+2][y+1] = steps + 1;
            knightsTour(currentBoard, x+2, y+1, steps + 1);
            currentBoard[x+2][y+1] = -1;
        }


        if(isValidMove(currentBoard,x-1,y-2)){
            currentBoard[x-1][y-2] = steps+1;
            knightsTour(currentBoard,x-1,y-2,steps+1);
            currentBoard[x-1][y-2] = -1;

        }

        if(isValidMove(currentBoard,x+1,y-2)){
            currentBoard[x+1][y-2] = steps+1;
            knightsTour(currentBoard,x+1,y-2,steps+1);
            currentBoard[x+1][y-2] = -1;

        }
        if(isValidMove(currentBoard,x-1,y+2)){
            currentBoard[x-1][y+2] = steps+1;
            knightsTour(currentBoard,x-1,y+2,steps+1);
            currentBoard[x-1][y+2] = -1;

        }
        if(isValidMove(currentBoard,x+1,y+2)) {
            currentBoard[x+1][y+2] = steps + 1;
            knightsTour(currentBoard, x+1, y+2, steps + 1);
            currentBoard[x+1][y+2] = -1;
        }
    }

    private static boolean isValidMove(int[][] boardState, int x, int y ){
        if(x<0 || y<0 || x>=boardState.length || y>= boardState[0].length){
            return false;
        }
        if(boardState[x][y]==-1)
            return true;
        return false;
    }


    private static int[][] initBoard(int n){
        int[][] newboard =new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                newboard[i][j]=-1;
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
        System.out.println("*************");

    }

}
