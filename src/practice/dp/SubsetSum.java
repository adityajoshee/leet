package practice.dp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by aditya on 9/13/16.
 */
public class SubsetSum {
    public static void main(String args[]){
        int[] arr = {4,3,2,8,6,1,7};
        int sum = 19;
        Arrays.sort(arr);
        Set s = new HashSet();
        System.out.println(determine(arr,0,arr.length-1,sum, s));
        System.out.println(s);
    }
    private static boolean determine(int[] arr, int l, int r, int sumLeft, Set current){
        if(sumLeft==0){
            return true;
        }
        for (int i = l; i <= r; i++) {
            if(arr[i]<=sumLeft){
                current.add(arr[i]);
                boolean res = determine(arr,i+1,r,sumLeft-arr[i], current);
                if(res){
                    return true;
                }
                current.remove(arr[i]);
            }
            else {
                return false;
            }
        }
        return false;
    }
}
