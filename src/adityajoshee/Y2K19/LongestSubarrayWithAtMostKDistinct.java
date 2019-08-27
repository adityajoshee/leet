package adityajoshee.Y2K19;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by aditya.joshee on 2019-08-24.
 */
public class LongestSubarrayWithAtMostKDistinct {
    public static void main(String[] args) {
        int[] A = {1,2,3};
        System.out.println(helper(A, 2));
    }

    private static int helper(int[] a, int k) {
        int i=0,j=0,l=0;
        Map<Integer, Integer> map = new HashMap<>();

        while(j<a.length){
            map.put(a[j], map.getOrDefault(a[j],0)+1);
            j++;

            if(map.size()<=k){
                l = Math.max(l, j-i);
            }
            while (map.size()>k){
                if(map.get(a[i])==1){
                    map.remove(a[i]);
                }
                else{
                    map.put(a[i], map.get(a[i])-1);
                }
                i++;
            }
        }
        return l;
    }
}
