package adityajoshee.Y2K18.jan.D25;

/**
 * Created by aditya.joshee on 1/25/18.
 *
 * Given a matrix with each cell containing each number of candies,
 * and a constraint that you can move only right or down, from the top
 * left corner to the bottom right corner, findMethod1 the path that gets you
 * maximum candies.
 */
public class MaxCandiesMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {1,2,99},
                {5,3,2},
                {3,3,2},
                {3,3,2},
                {3,1000,2},
                {3,3,2},
                {310101,3,2},

                };
        int[][] dp = new int[matrix.length][matrix[0].length];
        long t1 = System.nanoTime();
        System.out.println(getMaxCandies(matrix, 0, 0)+" time:"+(System.nanoTime()-t1));
        long t2 = System.nanoTime();
        System.out.println(getMaxCandiesDP(matrix, 0, 0, dp)+" time:"+(System.nanoTime()-t2));

    }

    private static int getMaxCandies(int[][] matrix, int x, int y) {
        if (x==matrix.length || y==matrix[0].length){
            return 0;
        }
        return matrix[x][y] + Math.max(getMaxCandies(matrix, x+1, y), getMaxCandies(matrix, x, y+1));
    }

    private static int getMaxCandiesDP(int[][] matrix, int x, int y, int[][] dp) {
        if (x==matrix.length || y==matrix[0].length){
            return 0;
        }
        if (dp[x][y]!=0){
            return dp[x][y];
        }
        return matrix[x][y] + Math.max(getMaxCandies(matrix, x+1, y), getMaxCandies(matrix, x, y+1));
    }
}