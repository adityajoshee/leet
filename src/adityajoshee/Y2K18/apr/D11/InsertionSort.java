package adityajoshee.Y2K18.apr.D11;

import java.util.Arrays;

/**
 * Created by aditya.joshee on 4/11/18.
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {-1,9,6,4,7,0,99};
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i]<arr[i-1]){
                int j = i;
                while (j>0 && arr[j]<arr[j-1]){
                    int t = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = t;
                    j--;
                }
            }
        }
    }
}