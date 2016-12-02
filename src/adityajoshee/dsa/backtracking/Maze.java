package adityajoshee.dsa.backtracking;

/**
 * Created by adityajoshee on 23/04/16.
 */
public class Maze {
    public static void main(String args[]){
        int[][] maze = initBoard(4);
        maze[0][1] = maze[0][2] = maze[0][3]=maze[2][3]=0; // blocks
        printCurrentBoard(maze);
        int[][] sol = new int[4][4];
        sol[0][0]=1;
        generateWayOut(maze,0,0,"0,0",sol); // 0,0 is starting position

    }

    private static void generateWayOut(int[][] maze,int i,int j,String moves,int[][] sol){
        if(i==maze.length-1 && j==maze.length-1 && maze[i][j]==1){
            // out of maze
            System.out.println(" OUT! ");
            System.out.println(moves);
            printCurrentBoard(sol);

            return;
        }
        if(validMove(i+1,j,maze)){
            sol[i+1][j]=1;
            generateWayOut(maze,i+1,j,moves+" -> "+(i+1)+","+(j),sol);
            sol[i+1][j]=0;
        }


        if(validMove(i,j+1,maze)){
            sol[i][j+1]=1;
            generateWayOut(maze,i,j+1,moves+" -> "+(i)+","+(j+1),sol);

        }
        return;
    }

    private static boolean validMove(int x, int y, int[][] maze){
        if(x<maze.length && y<maze.length && maze[x][y]==1)
            return true;
        return false;
    }

    private static int[][] initBoard(int n){
        int[][] newboard =new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                newboard[i][j]=1;
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