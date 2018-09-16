package adityajoshee.Y2K18.sep.D15;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {21,3,1,1,1,0,1};
        sort(0, arr.length-1, arr);
        System.out.println(Arrays.toString(arr));
    }
    private static void sort(int l, int r, int[] arr){
        int p = getPivotsCorrectPosition(l, r, arr);
        if (p-1>l){
            sort(l, p-1, arr);
        }
        if (p+1<r){
            sort(p+1, r, arr);
        }
    }
    private static int getPivotsCorrectPosition(int l, int r, int[] arr) {
        int p = r;
        r = r-1;
        while (l<r){
            while (l<r && arr[l]<=arr[p]){
                l++;
            }
            while (l<r && arr[r]>=arr[p]){
                r--;
            }
            if (l<r){
                swap(arr, l++, r--);
            }
        }
        if (arr[l]<arr[p]){
            return p; // pivot at correct position
        }
        swap(arr, p, l);
        return l;
    }
    private static void swap(int[] arr, int x, int y) {
        int t = arr[x];
        arr[x] = arr[y];
        arr[y] = t;
    }
}
