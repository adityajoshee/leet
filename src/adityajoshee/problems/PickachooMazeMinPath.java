package adityajoshee.problems;

import adityajoshee.dsa.matrix.PrintMatrix;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

/**
 * Created by aditya on 11/14/16.

B denotes starting point
C denotes pikachoo
. denotes valid cell
D deotes danger cell (invalid)
 */

public class PickachooMazeMinPath {
    public static void main(String args[]) throws  Exception{
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String[] inputSize = br.readLine().split(" ");
        int N = Integer.parseInt(inputSize[0]);
        int M = Integer.parseInt(inputSize[1]);
        char[][] maze = new char[N][M];
        Coordinate B = null;

        for (int i = 0; i < N; i++) {
            String mstring = br.readLine();
            char[] mchars = mstring.toCharArray();
            maze[i] = mchars;
            int bj = mstring.indexOf('B');
            if (bj>=0){
                B = new Coordinate(i,bj,0);
            }
        }
        PrintMatrix.printc(maze);
        System.out.println("B:"+B.toString());
        //System.out.println("C:"+C.toString());
        System.out.println(findMinDistanceToDestination(maze,B));
    }
    private static int findMinDistanceToDestination(char[][] maze, Coordinate B){
        boolean visited[][] = new boolean[maze.length][maze[0].length];
        LinkedList<Coordinate> queue = new LinkedList<>();
        queue.add(B); // appends
        int sum = 0;
        visited[B.x][B.y] = true;
        while (!queue.isEmpty()){
            Coordinate currPos = queue.pop();
            if (maze[currPos.x][currPos.y]=='C'){
                // destination.
                return currPos.distanceFromSource;
            }
            // moves in all possible ways that are not visited..and mark them as visited
            // so that we don't come back there and avoid infinite looping

            if (currPos.x-1>=0 && maze[currPos.x-1][currPos.y]!='D' && !visited[currPos.x-1][currPos.y]){
                visited[currPos.x-1][currPos.y] = true;
                queue.add(new Coordinate(currPos.x-1,currPos.y,currPos.distanceFromSource+1));
            }
            if (currPos.x+1<maze.length && maze[currPos.x+1][currPos.y]!='D'  && !visited[currPos.x+1][currPos.y]){
                visited[currPos.x+1][currPos.y]=true;
                queue.add(new Coordinate(currPos.x+1,currPos.y,currPos.distanceFromSource+1));
            }
            if (currPos.y-1>=0 && maze[currPos.x][currPos.y-1]!='D'  && !visited[currPos.x][currPos.y-1]){
                visited[currPos.x][currPos.y-1] = true;
                queue.add(new Coordinate(currPos.x,currPos.y-1,currPos.distanceFromSource+1));
            }
            if (currPos.y+1<maze[0].length && maze[currPos.x][currPos.y+1]!='D'  && !visited[currPos.x][currPos.y+1]){
                visited[currPos.x][currPos.y+1] = true;
                queue.add(new Coordinate(currPos.x,currPos.y+1,currPos.distanceFromSource+1));
            }
        }
        return -1; // no way to reach destn.
    }

    // incorrect...results in infinite loop
    private static int findMinRec(char[][] maze, Coordinate B, Coordinate currPos, int currDis){
        System.out.println(currPos);
        // check for base cases...
        if (currPos.x>=maze.length || currPos.y>=maze[0].length || currPos.x<0 || currPos.y<0){
            //invalid position...
            return Integer.MAX_VALUE;
        }
        if (currPos.x==B.x && currPos.y==B.y && currDis>0){
            //loop formed...
            return Integer.MAX_VALUE;
        }
        if (maze[currPos.x][currPos.y]=='D'){
            // danger cell.
            return Integer.MAX_VALUE;
        }
        if (maze[currPos.x][currPos.y]=='C'){
            // destination reached...
            return currDis;
        }
        // recurse for moving to all possible directions...up, down, right, left...
        Coordinate up = new Coordinate(currPos.x-1,currPos.y,-1);
        Coordinate down = new Coordinate(currPos.x+1,currPos.y,-1);
        Coordinate left = new Coordinate(currPos.x,currPos.y-1,-1);
        Coordinate right = new Coordinate(currPos.x,currPos.y+1,-1);
        return min(
                findMinRec(maze,B,up,currDis+1),
                findMinRec(maze,B,down,currDis+1),
                findMinRec(maze,B,left,currDis+1),
                findMinRec(maze,B,right,currDis+1)
        );
    }

    private static int min(int x, int y, int z, int a){
        int[] arr = {x,y,z,a};
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            min = min>x?x:min;
        }
        return min;
    }

    private static class Coordinate{
        int x,y;
        Integer distanceFromSource;
        public Coordinate(int x, int y, Integer distanceFromSource){
            this.x = x;
            this.y = y;
            this.distanceFromSource = distanceFromSource;
        }
        public String toString(){
            return "x: "+x+", y: "+y + ", dis: "+ distanceFromSource;
        }
        public boolean equals(Object A){
            if (A==null){
                return false;
            }
            if (A instanceof Coordinate){
                return ((Coordinate)A).x==this.x && ((Coordinate)A).y==this.y;
            }
            return false;
        }
    }
}
