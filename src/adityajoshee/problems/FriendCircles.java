package adityajoshee.problems;

/**
 * Created by aditya on 10/12/16.
 */
//https://www.youtube.com/watch?v=1XuCGYE56T0&index=27&list=PLamzFoFxwoNjPfxzaWqs7cZGsPYy0x_gI

public class FriendCircles {
    public static void main(String args[]){
        int[][] friends = {
                {1,1,0,0},
                {1,1,1,0},
                {0,1,1,0},
                {0,0,0,1}
        };
        System.out.println(findNumberOfCircles(friends));
    }
    private static int findNumberOfCircles(int[][] fr){
        boolean[] visited = new boolean[fr.length];
        int circles = 0;
        for (int i = 0; i < fr.length; i++) {
            if (!visited[i]){
                circles++;
                discoverCircle(fr, i, visited);
            }
        }
        return circles;
    }
    private static void discoverCircle(int[][] fr, int i, boolean[] visited){
        visited[i] = true;
        for (int j = 0; j < fr.length; j++) {
            if (fr[i][j]==1 && !visited[j]){
                discoverCircle(fr, j, visited);
            }
        }
    }
    /*
    Basically, we have to findMethod1 the number of strongly connected components
    in the friends graph, using DFS.
     */
}
