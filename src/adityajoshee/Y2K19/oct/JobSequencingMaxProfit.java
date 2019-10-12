package adityajoshee.Y2K19.oct;

import java.util.*;

/**
 * Created by aditya.joshee on 2019-10-12.
 */
/*
Given an array of jobs where every job has a deadline and a profit.
Profit can be earned only if the job is finished before the deadline.
It is also given that every job takes a single unit of time,
so the minimum possible deadline for any job is 1.
How to maximize total profit if only one job can be scheduled at a time.
Print the sequence of jobID order to maximize total profit.
 */
public class JobSequencingMaxProfit {
    public static void main(String[] args) {
        int[] deadline = new int[]{2,1,2,1,3};
        int[] profit = new int[]{100,19,27,25,15};
        System.out.println(new JobSequencingMaxProfit().find(deadline, profit));
    }

    private Collection<Integer> find(int[] deadline, int[] profit) {
        TreeMap<Integer, Integer> jobSequence = new TreeMap<>();
        boolean[] used = new boolean[deadline.length];
        PriorityQueue<ProfitAndDeadline> pq = new PriorityQueue<>();
        for(int i=0; i<deadline.length; i++){
            pq.offer(new ProfitAndDeadline(i, profit[i], deadline[i]));
        }
        while (!pq.isEmpty()){
            ProfitAndDeadline pnd = pq.poll();
            int i = pnd.deadline-1; // latest time slot for this task
            while (i>=0){
                if(used[i]){
                    i--;
                }
                else {
                    jobSequence.put(i, pnd.id);
                    used[i] = true;
                    break;
                }
            }
        }
        return jobSequence.values();
    }
    private class ProfitAndDeadline implements Comparable<ProfitAndDeadline>{
        int id;
        int profit;
        int deadline;

        public ProfitAndDeadline(int id, int profit, int deadline) {
            this.id = id;
            this.profit = profit;
            this.deadline = deadline;
        }

        @Override
        public int compareTo(ProfitAndDeadline o) {
            return o.profit - this.profit;
        }
    }
}
