package adityajoshee.practice;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aditya.joshee on 2019-09-07.
 */

class MergeNewInterval {
    public static void main(String[] args) {
        int[][] res = insert(new int[][]{{1,2},{3,5},{6,7},{8,10},{12,16}}, new int[]{4,8});
        for (int[] r: res){
            System.out.println(r[0]+","+r[1]);
        }
    }
    public static int[][] insert(int[][] intervals, int[] newInt) {
        if(intervals.length==0) return new int[][]{newInt};
        List<int[]> res = new ArrayList<>();
        for(int[] cInt: intervals){
            if(newInt[1]<cInt[0]){
                // simply add the new interval
                res.add(newInt);
                res.add(cInt);
                // once the newInt is add make newInt as cInt
                newInt = cInt;
            }
            else if((cInt[1]>=newInt[0] && cInt[0]<=newInt[0]) ||
                    (cInt[1]>=newInt[1] && cInt[0]<=newInt[1]) ||
                    (cInt[1]<=newInt[1] && cInt[0]>=newInt[0])
            ){
                //merge
                newInt[0] = newInt[0]<cInt[0] ? newInt[0] : cInt[0];
                newInt[1] = newInt[1]>cInt[1] ? newInt[1] : cInt[1];
            }
            else{
                //simply add the
                res.add(cInt);
            }
        }
        return res.toArray(new int[res.size()][2]);
    }
}