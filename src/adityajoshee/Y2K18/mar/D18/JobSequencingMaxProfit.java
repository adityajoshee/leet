package adityajoshee.Y2K18.mar.D18;

import java.util.*;

/**
 * Created by aditya.joshee on 3/18/18.
 * Given jobs with their deadlines and profits, maximise profit.
 */
public class JobSequencingMaxProfit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] deadline = new int[N];
        int[] profit = new int[N];
        for (int i = 0; i < N; i++) {
            deadline[i] = scanner.nextInt();
            profit[i] = scanner.nextInt();
        }



        //sort by dec profit
        for (int i = 0; i < profit.length; i++) {
            int min = 0;
            for (int j = 0; j < profit.length-i; j++) {
                if (profit[j]<profit[min]){
                    min = j;
                }
            }
            swap(profit, deadline, min, profit.length-1-i);
        }

        boolean[] occupied = new boolean[profit.length+1];
        int profitMax = 0;
        int[] sequcence =new int[profit.length+1];
        // at every timeunit the job with max profit about to expire must be executed
        for (int i = 0; i < profit.length; i++) {
            int currDeadline = deadline[i];
            boolean occ = false;
            while (currDeadline>0 && !occ) {
                if (!occupied[currDeadline]){
                    occupied[currDeadline] = true;
                    profitMax = profitMax + profit[i];
                    occ = true;
                    sequcence[currDeadline] = profit[i];
                }
                else {
                    currDeadline--;
                }
            }
        }
        System.out.println("max profit = "+profitMax);
        System.out.println(Arrays.toString(sequcence));
    }


    private static void swap(int[] endTime, int[] startTime, int max, int last) {
        int i = endTime[last];
        int j = startTime[last];
        endTime[last] = endTime[max];
        startTime[last] = startTime[max];
        endTime[max] = i;
        startTime[max] = j;
    }
}
