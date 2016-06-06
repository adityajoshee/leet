package algorithms.matrix;

/**
 * Created by adityajoshee on 21/05/16.
 */
public class MinCost {

    public static void main(String args[]){
        int[][] cost = {     {0, 4, 15},{10, 9, 18},{4, 12, 0}    };
        System.out.println(minCost(cost, 0, 0));
    }
    private static int minCost(int[][] cost, int x, int y){
        if(y==cost[0].length || x == cost.length){
            return Integer.MAX_VALUE;
        }
        if(x==cost.length-1 && y==cost[0].length-1){
            return cost[x][y];
        }
        return cost[x][y]+Math.min(minCost(cost,x+1,y),minCost(cost,x,y+1));
    }


}
