package adityajoshee.Y2K18.apr.D07;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by aditya.joshee on 4/7/18.
 * Find all subarrays with equals sum K.
 */
public class SubarraysWithSum {
    public static void main(String[] args) {
        int[] INPUT = {10, 2, -2, -20, 10};
        printSubarrays(INPUT, -12);
    }

    private static void printSubarrays(int[] input, int k) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<Integer> initial = new ArrayList<>();
        initial.add(-1);
        map.put(0, initial);
        int preSum = 0;

        // Loop across all elements of the array
        for(int i=0; i< input.length; i++) {
            preSum += input[i];
            // If point where sum = (preSum - k) is present, it means that between that
            // point and this, the sum has to equal k
            if(map.containsKey(preSum - k)) {   // Subarray found
                List<Integer> startIndices = map.get(preSum - k);
                for(int start : startIndices) {
                    System.out.println("Start: "+ (start+1)+ "\tEnd: "+ i);
                }
            }

            List<Integer> newStart = new ArrayList<>();
            if(map.containsKey(preSum)) {
                newStart = map.get(preSum);
            }
            newStart.add(i);
            map.put(preSum, newStart);
        }
    }
}
