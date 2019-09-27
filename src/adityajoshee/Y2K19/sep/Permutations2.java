package adityajoshee.Y2K19.sep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by aditya.joshee on 2019-09-24.
 */
public class Permutations2 {
    public static void main(String[] args) {
        for(List<Integer> arr: permuteUnique(new int[]{1,1})){
            for(int x: arr){
                System.out.print(x+" ");
            }
            System.out.println();
        }
    }
    public static List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList();
        boolean[] visited = new boolean[nums.length];
        find(nums, cur, res, visited);
        return res;
    }
    private static void find(int[] nums, List<Integer> cur, List<List<Integer>> res, boolean[] visited){
        if(cur.size()==nums.length){
            res.add(new ArrayList(cur));
            return;
        }
        for(int i=0; i<nums.length; i++){
            if(i>0 && nums[i-1]==nums[i] && visited[i-1]){ // to remove duplicates
                continue;
            }
            if(!visited[i]){
                // visit
                cur.add(nums[i]);
                visited[i] = true;
                find(nums, cur, res, visited);
                visited[i] = false;
                cur.remove(cur.size()-1);
            }
        }
    }

}
