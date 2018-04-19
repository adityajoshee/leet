package adityajoshee.Y2K18.apr.D11;

import java.util.Arrays;

/**
 * Created by aditya.joshee on 4/11/18.
 */
public class CountingSort {
    public static void main(String[] args) {
        int[] arr = {2, 0, 1, 2, 3, 1, 1, 5, 4};
        sort(arr);
    }

    private static void sort(int[] arr) {
        //find max
        int k = 0;
        for (int i = 0; i < arr.length; i++) {
            k = Math.max(arr[i], k);
        }
        int[] farr = new int[k+1];
        for (int i = 0; i < arr.length; i++) {
            farr[arr[i]]++;
        }
        for (int i = 1; i < farr.length; i++) {
            farr[i] = farr[i-1]+farr[i];
        }
        int[] output = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            if (farr[arr[i]]>=1){ // if freq at least 1
                output[farr[arr[i]]-1] = arr[i];
                farr[arr[i]]--;
            }
        }
        System.out.println(Arrays.toString(output));
    }
}
