package adityajoshee.practice.recursion;

/**
 * Created by aditya on 11/13/16.
 */
// findMethod1 whether there is atleast a subset with sum S
// This function can be used as a subroutine to equal-sum-partitioning problem.

public class SubsetSumProblem {
    public static void main(String args[]){
        int[] arr = {4,2,8,7,9};
        System.out.println(ifExists(arr,19,0));
    }
    private static boolean ifExists(int[] arr, int sum, int j){
        if (sum==0){
            return true;
        }
        if (sum<0){
            return false;
        }
        boolean res = false;
        for (int i = j; i < arr.length; i++) {
            res = ifExists(arr, sum-arr[i], j++);
            if (res){
                break;
            }
        }
        return res;
    }
}
