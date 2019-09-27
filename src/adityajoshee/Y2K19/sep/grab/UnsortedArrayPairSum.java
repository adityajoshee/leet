package adityajoshee.Y2K19.sep.grab;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by aditya.joshee on 2019-09-26.
 */

//https://github.com/rishabh115/Interview-Questions/tree/master/Grab#coding
public class UnsortedArrayPairSum {
    public static void main(String[] args) {
        int[] arr = {5,1,6,8,2,7,3, 3};
        find(arr, 9);
    }

    /*
    2 ways :
    1. Sort the array. Use low & hi index from start and end of sorted arr.
    2. Use hashmap. Iterate the array and find the diff of curr element for index not equal the curr element's index
     */
    private static void find(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>(arr.length);
        for(int i=0; i<arr.length; i++){
            Integer idx = map.get(k-arr[i]);
            if(idx!=null) {
                System.out.println(idx + ", " + i);
            }
            map.put(arr[i], i);
        }
    }
}
