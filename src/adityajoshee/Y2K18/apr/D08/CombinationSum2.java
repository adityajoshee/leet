package adityajoshee.Y2K18.apr.D08;

import java.util.*;

/**
 * Created by aditya.joshee on 4/8/18.
 *
 * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
 * Each number in C may only be used once in the combination.
 */
public class CombinationSum2 {
    public static void main(String[] args) {
        int[] arr = {7,8,2,1,3,4};
        Set<List<Integer>> set = new HashSet<>();
        find(arr, 15, 0, new ArrayList<>(), set);
        for (List<Integer> list : set){
            for (Integer integer: list){
                System.out.print(integer+" ");
            }
            System.out.println();
        }
    }

    private static void find(int[] arr, int s, int p, List<Integer> list, Set<List<Integer>> set) {
        if(s<0){
            return; // useless combination
        }
        if (s==0){
            // one solution found, add to set
            List<Integer> list1 = new ArrayList<>();
            list1.addAll(list);
            set.add(list1);
            return;
        }
        for (int i = p; i < arr.length; i++) {
            list.add(arr[i]);
            find(arr, s-arr[i], i+1, list, set);
            list.remove(list.size()-1); //backtrack
        }
    }
}
