package adityajoshee.dsa.matrix.minCost;

/**
 * Created by aditya on 10/11/16.
 */
public class MinCostTopDown {
    public static void main(String args[]){
        int[][] cost = {     {0, 4, 15},{10, 9, 8},{4, 12, 0}    };
        System.out.println(getMinCost(cost, 2, 2));
    }
    private static int getMinCost(int[][] arr, int x, int y){
        // x, y initially will be the destination
        if(x==0 && y==0){
            return arr[x][y]; // which is some constant, here 0.
        }
        if(x<0 || y<0){
            return Integer.MAX_VALUE;
        }
        return arr[x][y]+Math.min(getMinCost(arr, x-1, y), getMinCost(arr, x, y-1));
    }
}
