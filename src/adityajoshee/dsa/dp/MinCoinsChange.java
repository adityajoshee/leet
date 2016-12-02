package adityajoshee.dsa.dp;

/**
 * Created by aditya on 9/14/16.
 *
 * {9, 6, 5, 1} and V = 11.
 {1,4,5,15,20}; V = 23
 Greedy solution will not work. Using DP.
 */
public class MinCoinsChange {
    public static void main(String args[]){
        int[] coins = {9, 6, 5, 1};
        int v = 11;
        findMin(coins,v);
    }
    private static int findMin(int[] coins, int v){
        return -1;
    }
}
