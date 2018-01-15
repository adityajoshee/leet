package adityajoshee.dsa.dp.minimizeTicketCost;

import java.util.Arrays;

/**
 * Created by aditya on 11/10/16.
 */
public class PublicTicketCost {
    public static void main(String args[]){
        int[] arr  =  {1,2,4,5,7,8,9,10,11,12,29,30};//{1,7,8,9,10,15,16,17,18,21,25};
        int[] tDays = {1,7,30};//{1,7,30}; // number of days for which the ith ticket type is valid.
        int[] tCost = {2,7,25};// cost of the ith ticket.
        System.out.println(minCost2(arr, tDays, tCost));
    }
    public static int minCost(int[] arr, int[] tDays, int[] tCost) {
        int[][] dp = new int[arr.length][tDays.length];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < tDays.length; j++) {

                int prevDayIndex = findPrevDayIndex(arr,i,tDays,j);
                int prevCost = prevDayIndex>=0 ? dp[prevDayIndex][tDays.length-1] : 0;
                int currCost = prevCost + tCost[j];
                if(j-1>=0){
                    currCost = Math.min(currCost, dp[i][j-1]);
                }
                dp[i][j] = currCost;
            }
        }
        print(dp);
        return dp[arr.length-1][tDays.length-1];
    }
    private static void print(int arr[][]){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
    private static int findPrevDayIndex(int[] arr, int i, int[] days, int j){
        int validAfterDate = arr[i] - days[j];
        if (validAfterDate<1){
            return -1;
        }
        for (int k = i-1; k >= 0; k--) {
            if (arr[k]<=validAfterDate){
                return k;
            }
        }
        return -1;
    }



    public static int minCost2(int[] arr, int[] validFor, int[] cost){
        boolean[] travel = new boolean[31];
        for (int i = 0; i < arr.length; i++) {
            travel[arr[i]] = true;
        }
        System.out.println(Arrays.toString(travel));
        return -1;
    }
}