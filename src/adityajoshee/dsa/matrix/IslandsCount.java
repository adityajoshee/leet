package adityajoshee.dsa.matrix;

/**
 * Created by aditya on 11/19/16.
 */
// dfs based solution.
public class IslandsCount {
    public static void main(String args[]){
        int[][] world = {
                {1, 1, 0, 0, 0},
                {0, 1, 0, 0, 1},
                {1, 0, 0, 1, 1},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1}
        };
        System.out.println(find(world));
    }
    private static int find(int[][] world){
        int count=0;
        boolean[][] visited = new boolean[world.length][world[0].length];
        for (int i = 0; i < world.length; i++) {
            for (int j = 0; j < world[0].length; j++) {
                if (world[i][j]==1 && !visited[i][j]){
                    count++;
                    dfs(world,i,j,visited);
                }
            }
        }
        return count;
    }
    private static void dfs(int[][] world, int i, int j, boolean[][] visited){
        if (i>=0 && i<world.length && j>=0 && j<world[0].length){
            if (world[i][j]==1 && !visited[i][j]){
                visited[i][j] = true;
                dfs(world,i+1,j,visited);
                dfs(world,i-1,j,visited);
                dfs(world,i,j+1,visited);
                dfs(world,i,j-1,visited);
                dfs(world,i+1,j+1,visited);
                dfs(world,i-1,j-1,visited);
                dfs(world,i+1,j-1,visited);
                dfs(world,i-1,j+1,visited);
            }
        }
    }


}
