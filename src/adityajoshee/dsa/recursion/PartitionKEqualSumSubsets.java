package adityajoshee.dsa.recursion;

import java.util.Arrays;

/**
 * Created by aditya.joshee on 2019-08-19.
 */
public class PartitionKEqualSumSubsets {
    public static void main(String[] args) {
        System.out.println(canPartitionKSubsets(new int[]{2,2,2,2,3,4,5}, 4));
    }
    public static boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for(int n: nums){
            sum = sum + n;
            max = Math.max(max, n);
        }
        if(sum%k!=0 || max>(sum/k)) return false;

        return isPossible(nums, k, sum/k, 0, new boolean[nums.length], 0);
    }
    public static boolean isPossible(int[] nums, int k, int tsum, int csum, boolean[] visited, int j){
        if (k==0) return true;
        if (csum>tsum) return false;
        if (csum==tsum) return isPossible(nums, k-1, tsum, 0, visited, 0);

        for(int i=j; i<nums.length; i++){
            if(!visited[i]){
                visited[i] = true;
                if (isPossible(nums, k, tsum, csum+nums[i], visited, i+1)){
                    return true;
                }
                visited[i] = false;
            }
        }
        return false;
    }
}
