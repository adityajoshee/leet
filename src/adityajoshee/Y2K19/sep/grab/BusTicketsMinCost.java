package adityajoshee.Y2K19.sep.grab;

/**
 * Created by aditya.joshee on 2019-09-26.
 */
public class BusTicketsMinCost {
    public static void main(String[] args) {
        int[] costOfTicket = {2, 7, 25};
        int[] daysCanTravel ={1, 7, 30};
        int[] travelDays = {6,11,12,24,26,27,30};
        System.out.println(minCost(costOfTicket, daysCanTravel, travelDays));
    }

    private static int minCost(int[] costOfTicket, int[] daysCanTravel, int[] travelDays) {
        boolean[] day = new boolean[31];
        for (int i = 0; i < travelDays.length; i++) {
            day[travelDays[i]] = true;
        }

        int[] dp = new int[31];
        for (int i = 1; i < dp.length; i++) {
            if (!day[i]){ // if the person doesn't need to travel on ith day then min cost is same as prev min
                dp[i] = dp[i-1];
            }
            else{
                dp[i] = Math.min(Math.min(
                        i-daysCanTravel[0] < 1 ? costOfTicket[0] : costOfTicket[0]+dp[i-daysCanTravel[0]],
                        i-daysCanTravel[1] < 1 ? costOfTicket[1] : costOfTicket[1]+dp[i-daysCanTravel[1]]),
                        i-daysCanTravel[2] < 1 ? costOfTicket[2] : costOfTicket[2]+dp[i-daysCanTravel[2]]);
            }
        }
        return dp[30];
    }
}
