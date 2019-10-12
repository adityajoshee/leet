package adityajoshee.Y2K19.oct;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by aditya.joshee on 2019-10-12.
 */
/*
Input: Number of Jobs n = 4
       Job Details {Start Time, Finish Time, Profit}
       Job 1:  {1, 2, 50}
       Job 2:  {3, 5, 20}
       Job 3:  {6, 19, 100}
       Job 4:  {2, 100, 200}
Output: The maximum profit is 250.
We can get the maximum profit by scheduling jobs 1 and 4.
Note that there is longer schedules possible Jobs 1, 2 and 3
but the profit with this schedule is 20+50+100 which is less than 250.
 */

public class WeightedJobSchedulingStartEndTimes {
    public static void main(String[] args) {
        int[][] jobsData = { // starttime, endtime, profit
                {1,2,50},
                {3,5,20},
                {6,19,100},
                {2,100,200}
        };
        System.out.println(new WeightedJobSchedulingStartEndTimes().maxProfit(jobsData));
    }

    private int maxProfit(int[][] jobsData) {
        //sort jobs by ending times
        Job[] jobs = new Job[jobsData.length];
        for (int i = 0; i < jobs.length; i++) {
            jobs[i] = new Job(jobsData[i][0], jobsData[i][1], jobsData[i][2]);
        }
        Arrays.sort(jobs);
        System.out.println(find(jobs.length-1, jobs));
        return findDP(jobs.length-1, jobs);
    }

    private int findDP(int n, Job[] jobs) {
        int[] maxP = new int[jobs.length]; // stores intermediate max profits
        maxP[0] = jobs[0].p;
        for(int i=1; i<jobs.length; i++){
            int pre = prevNonOverlapping(i, jobs);
            int inc = jobs[i].p + (pre<0 ? 0 : maxP[pre]);
            int exc = maxP[i-1];
            maxP[i] = Math.max(inc, exc);
        }
        return maxP[maxP.length-1];
    }


    //recursive, slow solution
    private int find(int n, Job[] jobs) {
        if (n==0){
            return jobs[0].p;
        }
        int k = prevNonOverlapping(n, jobs);
        int maxIncl = k<0 ? jobs[n].p : jobs[n].p+find(k, jobs);
        int maxExcl = find(n-1, jobs);
        return Math.max(maxIncl, maxExcl);
    }

    private int prevNonOverlapping(int n, Job[] jobs) {
        for(int i=n-1; i>=0; i--){
            if(jobs[i].e <= jobs[n].s){
                return i;
            }
        }
        return -1;
    }

    class Job implements Comparable<Job>{
        int s;
        int e;
        int p;

        public Job(int s, int e, int p) {
            this.s = s;
            this.e = e;
            this.p = p;
        }

        @Override
        public int compareTo(Job o) {
            return this.e - o.e;
        }
    }
}
