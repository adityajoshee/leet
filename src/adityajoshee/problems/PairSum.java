package adityajoshee.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by adityajoshee on 19/05/16.
 */
public class PairSum {

    public static void main(String args[]){
        int[] arr  = {4,2,7,1,8,9,10,3,5};
        System.out.println(findPairs(arr,10));
    }
    private static int findPairs(int[] arr,int S){
        int count = 0;

        if(arr.length>=2){
            Map<Integer,Integer> map = new HashMap<>();
            for(int i=0;i<arr.length;i++){
                map.put(arr[i],i);
            }
            for(int i=0;i<arr.length;i++){
                Integer b = map.get(S-arr[i]);
                if(b!=null && S-arr[i]!=arr[i] && i>b){            // i>b to avoid duplicates and S-arr[i]!=arr[i] to avoid number S/2 if present
                    System.out.println(i+", "+map.get(S-arr[i]));
                    count++;
                }
            }
        }
        return count;
    }

}
