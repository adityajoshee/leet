package adityajoshee.Y2K18.aug.D12;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {2,6,0,9,1,7,8};
        sort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    private static void sort(int[] arr, int l, int r) {
        if (l<r){
            int m = l + (r-l)/2;
            sort(arr, l, m);
            sort(arr, m+1, r);
            merge(arr, l, m, r);
        }
        // if l==r then single element, means already sorted subarray
    }
    private static void merge(int[] arr, int l, int m, int r) {

        int size1 = m-l+1;
        int size2 = r-(m+1)+1;
        int[] L = new int[size1];
        int[] R = new int[size2];

        //copy data into L
        for (int i = 0; i < L.length; i++) {
            L[i] = arr[l+i];
        }
        //copy data into R
        for (int i = 0; i < R.length; i++) {
            R[i] = arr[m+1+i];
        }

        int i = 0, j = 0, k = l;
        while (i < L.length && j < R.length){

            if (L[i] < R[j]){
                arr[k++] = L[i++];
            }
            else {
                arr[k++] = R[j++];
            }
        }

        while (i < L.length){
            arr[k++] = L[i++];
        }
        while (j < R.length){
            arr[k++] = R[j++];
        }


    }
}
