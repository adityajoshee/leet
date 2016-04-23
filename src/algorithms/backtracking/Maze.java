package algorithms.backtracking;

/**
 * Created by adityajoshee on 23/04/16.
 */
public class Maze {
    public static void main(String args[]){
        int[][] maze = initBoard(4);
        maze[0][1] = maze[0][2] = maze[0][3] = maze[1][2]=maze[2][0]=maze[2][3]=0; // blocks
        printCurrentBoard(maze);
        generateWayOut(maze,0,0,"0,0"); // 0,0 is starting position
    }

    private static void generateWayOut(int[][] maze,int i,int j,String moves){
        if(i==maze.length-1 && j==maze.length-1 && maze[i][j]==1){
            // out of maze
            System.out.println(" OUT! ");
            System.out.println(moves);
            return;
        }
        if(i+1<maze.length){
            if(maze[i+1][j]==1){
                generateWayOut(maze,i+1,j,moves+" -> "+(i+1)+","+(j));
            }
        }

        if(j+1<maze.length){
            if(maze[i][j+1]==1){
                generateWayOut(maze,i,j+1,moves+" -> "+(i)+","+(j+1));
            }
        }

        return;

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
