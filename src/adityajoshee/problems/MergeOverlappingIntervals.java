package adityajoshee.problems;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by aditya.joshee on 08/09/14.
 */
public class MergeOverlappingIntervals {
    static class Interval {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "Interval{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }
    static class IntervalComparator implements Comparator<Interval>{

        @Override
        public int compare(Interval o1, Interval o2) {
            return o1.start-o2.start;
        }
    }

    public static void main(String args[]){
        Interval i1 = new Interval(2,4);
        Interval i2 = new Interval(1,3);
        Interval i3 = new Interval(5,7);
        Interval i4 = new Interval(3,6);
        Interval i5 = new Interval(8,9);
        Interval i6 = new Interval(9,11);
        Interval i7 = new Interval(10, 13);
        List<Interval> intervals = new ArrayList<>();
        intervals.add(i1);
        intervals.add(i2);
        intervals.add(i3);
        intervals.add(i4);
        intervals.add(i5);
        intervals.add(i6);
        intervals.add(i7);

        for (Interval i:mergeOverlapping(intervals)){
            System.out.print(i+" ");
        }
    }
    private static List<Interval> mergeOverlapping(List<Interval> intervals){
        List<Interval> result = new ArrayList<>();
        intervals.sort(new IntervalComparator());
        Interval pre = intervals.remove(0);

        for (Interval current:intervals){
            if (current.start<pre.end){
                //merge
                Interval newInterval = new Interval(pre.start, current.end);
                pre = newInterval;
            }
            else {
                // cannot merge with any other interval, so add to result
                result.add(pre);
                pre = current;
            }
        }
        result.add(pre);

        return result;
    }
}
