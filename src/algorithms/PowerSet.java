package algorithms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by adityajoshee on 18/04/16.
 */
public class PowerSet {

    public static void main(String[] args) {
        List<Object> list = new ArrayList<Object>();
        list.add("a");
        list.add("b");
        list.add("c");

        System.out.println(getSubsetUsingBitMap(list));
    }

    private static Set<Set<Object>> getSubsetUsingBitMap(List<Object> list){

        Set<Set<Object>> result = new HashSet<Set<Object>>();

        int numOfSubsets = 1 << list.size(); //OR Math.pow(2, list.size())

        // For i from 0 to 7 in case of [a, b, c],
        // we will pick 0(0,0,0) and check each bits to see any bit is set,
        // If set then element at corresponding position in a given Set need to be included in a subset.
        for(int i = 0; i < numOfSubsets; i++){

            Set<Object> subset = new HashSet<Object>();

            int mask = 1; // we will use this mask to check any bit is set in binary representation of value i.

            for(int k = 0; k < list.size(); k++){
                if((mask & i) != 0){ // If result is !=0 (or >0) then bit is set.
                    subset.add(list.get(k)); // include the corresponding element from a given set in a subset.
                }
                // check next bit in i.
                mask = mask << 1;
            }

            // add all subsets in final result.
            result.add(subset);
        }
        return result;
    }

}