package adityajoshee.dsa.recursion;

/**
 * Created by aditya.j on 5/6/17.
 */
public class MaxSumNoAdjacent {
    public static void main(String args[]){
        int[] arr = {6, -5, -10, 100, 10, 5};
        System.out.println(findMaxWithNoAdj(arr,arr.length-1));
        System.out.println(findMaxOptimised(arr));
        System.out.println(findMaxSpaceAndTimeOptimised(arr));
    }


    private static int findMaxWithNoAdj(int[] arr, int i){
        if (i<0){
            return 0;
        }
        return Math.max(arr[i]+findMaxWithNoAdj(arr,i-2), findMaxWithNoAdj(arr, i-1));
    }

    // but O(n) space
    private static int findMaxOptimised(int[] arr){
        int[] maxTill = new int[arr.length];
        maxTill[0] = Math.max(arr[0],0); // for -ves, if first element is -ve then maxTill[i] should be 0
        maxTill[1] = Math.max(arr[0],arr[1]);

        for (int i = 2; i < maxTill.length; i++) {
            maxTill[i] =    Math.max(arr[i]+maxTill[i-2], maxTill[i-1]);
        }
        return maxTill[maxTill.length-1];
    }


    // O(1) space
    private static int findMaxSpaceAndTimeOptimised(int[] arr){
        int maxTillPrev = 0;
        int maxTillPrevToPrev = 0;
        for (int i = 0; i < arr.length; i++) {
            int x = Math.max(arr[i]+maxTillPrevToPrev, maxTillPrev);
            maxTillPrevToPrev = maxTillPrev;
            maxTillPrev = x;
        }
        return Math.max(maxTillPrev, maxTillPrevToPrev);
    }
}
