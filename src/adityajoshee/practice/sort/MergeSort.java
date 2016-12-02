package adityajoshee.practice.sort;

import java.util.Arrays;

/**
 * Created by aditya on 11/18/16.
 */
public class MergeSort {
    public static void main(String args[]){
        int[] arr = {3,9,8,5,1,4,3,7,0};// {4,3,2,8,1,9,0,6,7};
        mergeSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    private static void mergeSort(int[] arr, int l, int r){
        if (l<r){
            int m = l + (r-l)/2;
            mergeSort(arr,l,m);
            mergeSort(arr,m+1,r);
            merge(arr,l,r);
        }
    }
    private static void merge(int[] arr, int l, int r){
        int m = l + (r-l)/2;
        // subarrayA is from l to m;
        // subarrayB is from m+1 to r;
        // both subarrays are sorted, we have to merge them, so that arr is sorted from l through r.

        int[] L = new int[m-l+1];
        int[] R = new int[r-m];

        for(int i=0;i<L.length;i++)
            L[i]=arr[l+i];
        for(int i=0;i<R.length;i++)
            R[i]=arr[m+1+i];

        int i = 0;
        int j = 0;
        int k = l;
        while (i<L.length && j<R.length){
            if (R[j]<L[i]){
                arr[k++] = R[j++];
            }
            else{
                arr[k++] = L[i++];
            }
        }
        while (i<L.length){
            arr[k++] = L[i++];
        }
        while (j<R.length){
            arr[k++] = R[j++];
        }
    }
}
