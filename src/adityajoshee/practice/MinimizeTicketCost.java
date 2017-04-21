package adityajoshee.practice;

import java.util.Arrays;

/**
 * Created by aditya.j on 4/20/17.
 */
public class MinimizeTicketCost {
    public static void main(String args[]){
        int[] travelDate = {1,7,8,9,10};
        int[] ticketPeriod = {1,7,30};
        int[] costOfTicket = {2,7,25};
        System.out.println(findMinCostToTravel(travelDate, ticketPeriod, costOfTicket));
    }

    private static int findMinCostToTravel(int[] travelDate, int[] days, int[] cost){
        int[][] matrix = new int[cost.length][travelDate.length];
        for (int i = 0; i < matrix[0].length; i++) {
            matrix[0][i] = 2*(i+1);
        }
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][0] = cost[0]; // since only travel date is 1, the cost will be min of ticket costs.
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                // two cases :
            }
        }
        return -1;
    }
}
