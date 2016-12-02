package adityajoshee.dsa.matrix.minCost;

/**
 * Created by adityajoshee on 21/05/16.
 */
public class MinCostDP {
    public static void main(String args[]){
       // int[][] cost = {  {1, 2, 3},{4, 8, 2},{1, 5, 3}  };
        int[][] cost = {     {1, 4, 15},{10, 9, 8},{4, 12, 0}    };

        System.out.println(minCost(cost));
    }
    private static int minCost(int[][] cost){
        int[][] dp = new int[cost.length][cost[0].length];

        for(int i=0;i<cost.length;i++){ // row
            for(int j=0; j<cost[0].length; j++){
                if(i-1>=0 && j-1>=0){
                    // ie. if both previous possible moves are valid
                    dp[i][j]=cost[i][j]+Math.min(dp[i-1][j],dp[i][j-1]) ;
                }
                else if(i-1>=0){
                    dp[i][j]=cost[i][j]+dp[i-1][j];
                }
                else if(j-1>=0) {
                    dp[i][j] =cost[i][j]+ dp[i][j-1];
                }
            }
        }
        return dp[cost.length-1][cost[0].length-1]; // return the destination cell value
    }

}
