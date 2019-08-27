package adityajoshee.Y2K19;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by aditya.joshee on 2019-08-22.
 */
public class LargestMountain {
    public static void main(String[] args) {
        System.out.println(longestMountain(new int[]{0,1,2,3,4,5,4,3,2,1,0}));
    }
    public static int longestMountain(int[] A) {
        boolean same = true;
        for(int i=0; i<A.length-1; i++){
            if(A[i]!=A[i+1]){
                same = !same;
                break;
            }
        }
        if(same) return 0;

        boolean incr = true;
        int l=0,r=0,len=0;
        while(r<A.length-1){
            while(r<A.length-1 && ((incr && A[r+1]>A[r]) || (!incr && A[r+1]<A[r]))){
                r++;
                System.out.println(r+","+(A.length-1));
            }
            if(!incr){
                len = Math.max(len, r-l+1);
                l = r;
            }
            incr = !incr;
            r++;
        }
        return len;

    }
}