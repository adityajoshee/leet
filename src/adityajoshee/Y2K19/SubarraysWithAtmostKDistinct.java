package adityajoshee.Y2K19;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by aditya.joshee on 2019-08-24.
 */
public class SubarraysWithAtmostKDistinct {
    public static void main(String[] args) {
        int[] A={1,2,3,4};
        System.out.println(subarraysWithAtMostK(A, 2));
    }

    private static int subarraysWithAtMostK(int[] A, int k) {
        int l=0,r=0,res=0;
        Map<Integer, Integer> map = new HashMap<>();
        while(r<A.length){
            map.put(A[r], map.getOrDefault(A[r],0)+1);
            r++;
            while(map.size()>k){
                if(map.get(A[l])==1){
                    map.remove(A[l]);
                }
                else{
                    map.put(A[l], map.get(A[l])-1);
                }
                l++;
            }
            res = res+r-l;

        }
        return res;
    }

}
