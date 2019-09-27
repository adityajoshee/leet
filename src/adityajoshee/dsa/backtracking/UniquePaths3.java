package adityajoshee.dsa.backtracking;

/**
 * Created by aditya.joshee on 2019-09-02.
 */

class UniquePaths3 {
    public static void main(String[] args) {
        int[][] matrix = {{0,1},{0,0},{2,0}};
        System.out.println(uniquePathsIII(matrix));
    }
    public static int uniquePathsIII(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        //find initial position which has cell val 1
        int si=-1,sj=-1, no=0;
        for(int i=0; i<grid.length; i++){
            for (int j=0; j<grid[0].length; j++){
                if(grid[i][j]==1) {
                    si = i;
                    sj = j;
                }
                if(grid[i][j]!=-1) no++;
            }
        }
        int[] count = new int[1];
        find(si, sj, count, grid, visited, no);
        return count[0];
    }
    static boolean  find(int i, int j, int[] count, int[][] grid, boolean[][] visited, int no){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]==-1 || visited[i][j]){
            return false;
        }
        if(grid[i][j]==2 && no==1) return true;
        if(grid[i][j]==2) return false;

        visited[i][j]=true; // starting point will be marked as visited and move to all 4 directions (dfs)
        if(find(i+1, j, count, grid, visited, no-1)){
            count[0]++;
        }
        if(find(i, j+1, count, grid, visited, no-1)){
            count[0]++;
        }
        if(find(i-1, j, count, grid, visited, no-1)){
            count[0]++;
        }
        if(find(i, j-1, count, grid, visited, no-1)){
            count[0]++;
        }
        visited[i][j]=false; // unmark visited, for backtracking, undo the choice made earlier.
        return false;
    }
}