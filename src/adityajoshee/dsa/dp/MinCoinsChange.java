package adityajoshee.dsa.dp;

import java.util.Arrays;

/**
 * Created by aditya on 9/14/16.
 *
 * {9, 6, 5, 1} and V = 11.
 {1,4,5,15,20}; V = 23
 Greedy solution will not work. Using DP.
 */
public class MinCoinsChange {
    public static void main(String args[]){
        int[] coins = {3, 5, 1};
        int v = 11;
        System.out.println(findMin(coins,v));
    }
    private static int findMin(int[] coins, int v){
        int[] partials = new int[v+1];
        Arrays.fill(partials, Integer.MAX_VALUE);
        partials[0]=0;
        for (int i = 1; i <= v; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j]<=i && partials[i-coins[j]]+1<partials[i]){
                    partials[i] = partials[i-coins[j]]+1;
                }
            }
        }
        return partials[v];
    }
}
