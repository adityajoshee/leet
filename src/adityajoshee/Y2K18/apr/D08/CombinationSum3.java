package adityajoshee.Y2K18.apr.D08;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by aditya.joshee on 4/9/18.
 *
 * Find all possible combinations of k numbers that add up to a number n,
 * given that only numbers from 1 to 9 can be used and each combination should
 * be a unique set of numbers.
 */
public class CombinationSum3 {
    public static void main(String[] args) {
        int k = 3;
        int n = 9;
        Set<List<Integer>> set = new HashSet<>();
        find(n, k, 1, set, new ArrayList<>());
        for (List<Integer> list : set){
            for (Integer integer: list){
                System.out.print(integer+" ");
            }
            System.out.println();
        }
    }

    private static void find(int n, int k, int i, Set<List<Integer>> set, ArrayList<Integer> list) {
        if (n<0){
            return;
        }
        if (n==0 && list.size()==k){
            List<Integer> list1 =new ArrayList<>();
            list1.addAll(list);
            set.add(list1);
            return;
        }
        for (int j = i; j <= 9; j++) {
            if (list.size()<k){
                list.add(j);
                find(n-j, k, j+1, set, list);
                list.remove(list.size()-1);
            }
        }
    }
}
