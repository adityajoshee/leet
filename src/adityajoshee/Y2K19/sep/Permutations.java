package adityajoshee.Y2K19.sep;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aditya.joshee on 2019-09-22.
 */

// use either DP or Backtracking, given that integers are distinct
public class Permutations {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        for (List<Integer> r: permute(arr)){
            System.out.println(r.toString());
        }
        System.out.println();
        for (List<Integer> r: permuteBacktracking(arr)){
            System.out.println(r.toString());
        }
    }

    // DP solution
    private static List<List<Integer>> permute(int[] arr) {
        List<List<Integer>> prev = new ArrayList<>();
        List<List<Integer>> curr;
        //we will find permutation for the new subarray (starting 0 to i) using the old permutations
        prev.add(new ArrayList(){{ add(arr[0]); }});

        for (int i = 1; i < arr.length; i++) {
            curr = new ArrayList<>();
            for(List<Integer> perm: prev){
                for(int j=0; j <= perm.size(); j++){ // put new element at all possible positions of a particular perv perm
                    perm.add(j, arr[i]);
                    curr.add(new ArrayList<>(perm));
                    perm.remove(j);
                }
            }
            prev = curr;

        }
        return prev;
    }

    private static List<List<Integer>> permuteBacktracking(int[] arr){
        List<Integer> curr = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        backtrack(curr, res, arr);
        return res;
    }

    private static void backtrack(List<Integer> curr, List<List<Integer>>res, int[] arr) {
        if (curr.size()==arr.length){
            // permutation generated, add to res.
            res.add(new ArrayList<>(curr));
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (!curr.contains(arr[i])){
                int idx = curr.size();
                curr.add(idx, arr[i]);
                backtrack(curr, res, arr);
                curr.remove(idx);
            }
        }
    }
}
