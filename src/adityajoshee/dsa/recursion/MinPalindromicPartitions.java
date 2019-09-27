package adityajoshee.dsa.recursion;

/**
 * Created by aditya.j on 4/2/17.
 */
public class MinPalindromicPartitions {
    public static void main(String args[]){
        int[] arr = {1,2,1,2,2,2,1,2,2,1,2,1,2,1};
        System.out.println(minPartitions(arr,0, arr.length-1));
    }
    private static int minPartitions(int[] arr, int i, int j){
        if (i==j){
            return 0;
        }
        if (isPalindrome(arr, i, j)){
            return 0;
        }
        int min = Integer.MAX_VALUE;
        // recurrence relation ...
        for (int k = i; k < j; k++) {
            int q = minPartitions(arr, i, k) + 1 + minPartitions(arr, k+1, j);
            if (min>q){
                min = q;
            }
        }
        return min;
    }
    private static boolean isPalindrome(int[] arr, int i, int j){
        while (i<j){
            if (arr[i++]!=arr[j--]){
                return false;
            }
        }
        return true;
    }
}
