package adityajoshee.dsa.dp.minimizeTicketCost;

import java.util.Arrays;

/**
 * Created by aditya.j on 4/21/17.
 */
//http://www.geeksforgeeks.org/find-the-minimum-cost-to-reach-a-destination-where-every-station-is-connected-in-one-direction/
public class MinTrainTicketCost {
    public static void main(String args[]){

        int[][] pairCost = {
                {0,15,80,90},
                {1000, 0, 40,50},
                {1000,1000,0,70},
                {1000,1000,1000,0}
        };
        System.out.println(minCostToReachLastStation(pairCost));
    }

    private static int minCostToReachLastStation(int[][] pairCosts){
        int[] mincosti = new int[pairCosts.length];
        for (int i = 1; i < pairCosts.length; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = i-1; j >= 0 ; j--) {
                int temp = mincosti[j]+pairCosts[j][i];
                min = temp<min?temp:min;
            }
            mincosti[i] = min;
        }
        return mincosti[pairCosts.length-1];
    }
}
