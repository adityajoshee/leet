package adityajoshee.dsa.matrix;

/**
 * Created by adityajoshee on 21/05/16.
 */
public class MinCostBottomUp {

    public static void main(String args[]){
        int[][] cost = {     {0, 4, 15},{10, 9, 8},{4, 12, 0}    };
        System.out.println(minCost(cost, 0, 0));
    }
    private static int minCost(int[][] cost, int x, int y){
        if(x == cost.length || y==cost[0].length){
            return Integer.MAX_VALUE; // i.e. if x or y is out of bounds index
        }
        if(x==cost.length-1 && y==cost[0].length-1){
            return cost[x][y]; // ie. if x,y is destination.
        }
        return cost[x][y]+Math.min(minCost(cost,x+1,y),minCost(cost,x,y+1));
    }


}
