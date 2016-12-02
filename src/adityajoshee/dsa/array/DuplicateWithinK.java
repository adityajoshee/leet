package adityajoshee.dsa.array;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by aditya on 9/26/16.
 */

//http://www.geeksforgeeks.org/check-given-array-contains-duplicate-elements-within-k-distance/

public class DuplicateWithinK {
    public static void main(String args[]){
        int[] arr  = {1, 2, 3, 4, 1, 2, 3, 4};
        int k = 3;
        System.out.println(areThereDuplicates(arr,k));
    }
    private static boolean areThereDuplicates(int[] arr, int k){
        int l = 0;
        int r = k;
        int c = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i <= k && k<arr.length; i++) {
            if(set.contains(arr[i])) {
                return true;
            }
            set.add(arr[i]);
            c++;
        }
        while(r < arr.length){
            set.remove(l);
            l++;
            if(set.contains(arr[c])){
                return true;
            }
        }
        return false;
    }
}
