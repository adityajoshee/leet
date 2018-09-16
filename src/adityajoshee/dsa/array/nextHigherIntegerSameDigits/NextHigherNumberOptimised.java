package adityajoshee.dsa.array.nextHigherIntegerSameDigits;

import java.util.Arrays;

/**
 * Created by aditya on 11/8/16.
 */
public class NextHigherNumberOptimised {
    public static void main(String args[]){
        int[] arr = {8,0,2,5,4,3,1};
        updateNumber(arr);
        System.out.println(Arrays.toString(arr));
    }
    private static void updateNumber(int[] arr){
        // findMethod1 first trough from right...
        int nextSmallerIndex = arr.length-1;
        boolean isSortedDesc = true;

        for (int i = arr.length-2; i >= 0; i--) {
            if (arr[i]<arr[nextSmallerIndex]){
                isSortedDesc = false;
                nextSmallerIndex = i;
                break;
            }
            else{
                nextSmallerIndex = i;
            }
        }

        if (isSortedDesc){
            // there will be no higher number than current
            System.out.println("No solution.");
            return;
        }

        // findMethod1 the least greater on the right of current.
        // using binary search nLog(n) here instead of O(n) traversal.
        int leastGreaterOnRightIndex = modifiedBinarySearch(arr,nextSmallerIndex+1, arr.length-1, arr[nextSmallerIndex]);
        swap(arr, leastGreaterOnRightIndex, nextSmallerIndex);

        // simple swap the symmetrically opposite elements, as the array is sorted in desc. (instead of sorting again)
        swapOpposites(arr,nextSmallerIndex+1, arr.length-1); // O(n)
    }


    private static void swap(int[] arr, int x, int y){
        int t = arr[x];
        arr[x] = arr[y];
        arr[y] = t;
    }
    private static void swapOpposites(int[] arr, int l, int r){
        while(l<r){
            swap(arr, l++, r--);
        }
    }
    private static int modifiedBinarySearch(int arr[], int li, int ri, int e){
        int pi = 0;
        while(li<ri){
            pi = li + (ri-li)/2;
            if (arr[pi]>e){
                li = pi+1;
            }
            else{
                ri = pi-1;
            }
        }
        return arr[pi]>e?pi:pi+1;
    }
}
