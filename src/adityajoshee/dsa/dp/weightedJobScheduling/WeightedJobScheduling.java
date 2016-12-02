package adityajoshee.dsa.dp.weightedJobScheduling;

import adityajoshee.dsa.matrix.PrintMatrix;

/**
 * Created by aditya on 11/12/16.
 */
// maximize profit such that no jobs overlap.
// O(N*N) in space and time (optimal is O(NlogN in time and O(N) in space))
public class WeightedJobScheduling {
    public static void main(String args[]){
        int[][] jobsData = { // starttime, endtime, profit
                {3,9,200},
                {4,5,50},
                {6,7,100},
                {1,2,60}
        };
        System.out.println(findMaxValue(jobsData, 9));
    }
    private static int findMaxValue(int[][] jobsData, int maxEndTime){
        int[][] dpJobVsEndTimes = new int[jobsData.length][maxEndTime+1] ;

        for (int i = 0; i < jobsData.length; i++) {
            for (int j = 0; j <= maxEndTime; j++) {
                int currJobStartTime = jobsData[i][0];
                int currJobEndTime = jobsData[i][1];
                int currJobProfit = jobsData[i][2];
                int pYes; // profit if curr job is scheduled.
                int pNo = i-1>=0?dpJobVsEndTimes[i-1][j]:0;
                if (currJobEndTime<=j){
                    if (i-1>=0){
                        // if current job is scheduled
                        pYes = currJobProfit + dpJobVsEndTimes[i-1][currJobStartTime];
                    }
                    else{
                        // if current job is scheduled and is first job i.e. i=0.
                        pYes = currJobProfit;
                    }
                }
                else{
                    // job can't be accomodated till time j.
                    pYes = j-1>=0?dpJobVsEndTimes[i][j-1]:0;
                }
                dpJobVsEndTimes[i][j] = Math.max(pYes,pNo);
            }
        }
        PrintMatrix.print(dpJobVsEndTimes);
        return dpJobVsEndTimes[jobsData.length-1][maxEndTime];
    }
}
