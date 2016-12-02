package adityajoshee.dsa.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aditya on 8/11/16.
 */
public class SubsetSum {
    public static void main(String args[]){
        int[] arr = new int[]{4,3,2,8,6,1,7};
        int sum = 19;
        printSubsetsWithSum(arr,sum,0, new ArrayList());
    }

    private static boolean printSubsetsWithSum(int[] arr, int sum, int start, List subset){
        if(sum==0){
            System.out.println(subset.toString());
            return true;
        }
        for(int i=start; i<arr.length;i++){
            if(arr[i]<=sum){
                subset.add(arr[i]);
                printSubsetsWithSum(arr, sum-arr[i], i+1, subset);
                subset.remove(new Integer(arr[i]));
            }
        }
        return false;
    }
}
