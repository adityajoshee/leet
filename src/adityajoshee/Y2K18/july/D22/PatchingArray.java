package adityajoshee.Y2K18.july.D22;

/**
 * Created by aditya.joshee on 7/22/18.
 */

/*
Given a sorted positive integer array nums and an integer n,
add/patch elements to the array such that any number in range [1, n]
inclusive can be formed by the sum of some elements in the array. Return
the minimum number of patches required. -- HARD

 */
public class PatchingArray {
    public static void main(String[] args) {
        int[] arr = {1,4,10};
        int n = 50;
        System.out.println(exe(arr, n));
    }

    private static int exe(int[] arr, int n) {

        int count = 0;
        long target = 1;
        int i = 0;
        while (target<=n){
            if (i<arr.length && arr[i]<=target){
                target += arr[i++];
            }
            else{
                target += target;
                count++;
            }
        }
        return count;

    }
}
