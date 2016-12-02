package adityajoshee.dsa.array.minJumps;

import java.util.Arrays;

/**
 * Created by aditya on 10/17/16.
 */

// O(n*n) in time and O(n)space
public class MinimumJumps {
    public static void main(String args[]){
        int[] jumpSet = {1,2,1,1,1};//{1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};//
        System.out.println(findMinNumOfJumps(jumpSet));
    }
    private static int findMinNumOfJumps(int[] jumps){
        int[] arr = new int[jumps.length];
        arr[0] = 0; // source
        for (int i = 1; i < arr.length; i++) {
            int min = Integer.MAX_VALUE-1;
            for (int j = 0; j < i; j++) {
                //check for all previous reachable nodes to current node i
                // and take min of their values.
                if(j+jumps[j] >= i && arr[j] < min){ // first condn means that from j we can reach i or more.
                    min = arr[j];
                }
            }
            arr[i] = min + 1; // 1 step from the jth node to i.
        }
        System.out.println(Arrays.toString(arr));
        return arr[arr.length-1];
    }
}