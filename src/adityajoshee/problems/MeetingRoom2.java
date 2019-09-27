package adityajoshee.problems;

import java.util.PriorityQueue;

/**
 * Created by aditya.joshee on 2019-08-16.
 */
public class MeetingRoom2 {
    // find min conf rooms needed = find max overlapping rooms

    public static void main(String[] args) {
        int[][] meetings = {{1,5},{2,3},{3,4},{3,5}};
        System.out.println(minRooms(meetings));
    }
    public static int minRooms(int[][] meet){
        //assume meetings are sorted by start time, for this problem (otherwise we need to sort)
        int rooms=0;
        PriorityQueue<Integer> earliestEndingTimes = new PriorityQueue<>();
        earliestEndingTimes.add(meet[0][1]);

        for(int[] meeting : meet){
            int st = meeting[0];
            int en = meeting[1];
            if(earliestEndingTimes.isEmpty() || earliestEndingTimes.peek()>st){
                rooms++;
            }
            else {
                earliestEndingTimes.poll();
            }
            earliestEndingTimes.add(en);
        }
        return rooms;
    }
}
