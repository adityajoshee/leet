package adityajoshee.Y2K18.jan.D15;

import java.util.*;

/**
 * Created by aditya.joshee on 1/15/18.
 * https://leetcode.com/problems/combination-sum/description/
 *
 * Given a list of candidate numbers (C) (without duplicates) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

 The same repeated number may be chosen from C unlimited number of times.
 */
public class CombinationSum {
    static int k = 0;
    static Set<List> sets = new HashSet<>();
    static List list = new ArrayList();
    public static void main(String[] args){
        int t = 8;
        int[] candidates = {2, 3, 6, 8}; //sorted
        find(candidates, t, 0);
        System.out.println(k);
        Iterator iterator1 = sets.iterator();
        while (iterator1.hasNext()){
            Iterator iterator = ((List)iterator1.next()).iterator();
            while (iterator.hasNext()){
                System.out.print(iterator.next()+" ");
            }
            System.out.println();
        }
    }

    private static void find(int[] candidates, int target, int p) {
        if (target<0){
            return;
        }
        if (target==0){
            k++;
            List s = new ArrayList();
            s.addAll(list);
            sets.add(s);
            return;
        }
        for (int i = p; i<candidates.length; i++){
            list.add(candidates[i]);
            find(candidates, target-candidates[i], i);
            list.remove(list.size()-1);
        }
    }
}
