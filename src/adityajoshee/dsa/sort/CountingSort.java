package adityajoshee.dsa.sort;

import java.util.Arrays;

/**
 * Created by aditya on 10/20/16.
 */
// non-comparison sort
// efficient only when range is comparable to input size.
public class CountingSort {

    public static void main(String args[]){
        int[] arr = {4,2,0,5,6,2,9,3,4};
        System.out.println(Arrays.toString(countingSort(arr)));
    }

    private static int[]countingSort(int[] a) {
        int k = getRange(a);
        int c[] = new int[k];
        for (int i = 0; i < a.length; i++)
            c[a[i]]++;
        for (int i = 1; i < k; i++)
            c[i] += c[i-1];  // required to make counting sort stable
        System.out.println(Arrays.toString(c));

        int b[] = new int[a.length];
        for (int i = a.length-1; i >= 0; i--) {
            c[a[i]] = c[a[i]] - 1;
            b[c[a[i]]] = a[i];
        }
        return b;
    }
    private static int getRange(int[] arr){
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]<min){
                min = arr[i];
            }
            if(arr[i]>max){
                max = arr[i];
            }
        }
        return max-min+1;
    }

}
