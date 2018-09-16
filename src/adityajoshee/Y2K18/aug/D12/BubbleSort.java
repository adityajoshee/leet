package adityajoshee.Y2K18.aug.D12;

import java.util.Arrays;

// optimised bubble sort. If already sorted in any iterations then
// no further iterations are required. So best case is O(n)
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {0,9,1,4,5};//{2,6,0,9,1,7,8};
        System.out.println(Arrays.toString(sort(arr)));
    }

    private static int[] sort(int[] arr) {
        boolean swapped = false;
        for (int i=0; i<arr.length; i++){
            for (int j = 0; j < arr.length-1-i; j++) {
                swapped = false;
                if (arr[j]>arr[j+1]){
                    swapped = true;
                    swap(arr, j, j+1);
                }
            }
            if (!swapped){
                System.out.println("Breaking out, no further iterations required");
                break;
            }
        }
        return arr;
    }

    private static void swap(int[] arr, int x, int y){
        int t = arr[x];
        arr[x] = arr[y];
        arr[y] = t;
    }
}
