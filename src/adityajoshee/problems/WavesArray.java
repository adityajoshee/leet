package adityajoshee.problems;

import java.util.Arrays;

/**
 * Created by aditya on 10/23/16.
 *
 * Given an array of numbers, output a wave.
 Input: a0 a1 a2 .. an-1
 Mathematical expression for wave: ai>=aj<=ak>=al<=am for all i, j,k,l .. m belong to [0,n-1]
 */
public class WavesArray {
    public static void main(String args[]){
        int[] arr = {1,2,0,-1,3};//{4,5,6,1,9,8,2,1,0};
        arr = getWavicurve(arr);
        System.out.println(Arrays.toString(arr));
    }
    private static int[] getWavicurve(int[] arr){
        boolean high = true;
        for (int i = 0; i < arr.length-1; i++, high=!high) {
            if (high){
                if(arr[i]<arr[i+1]){
                    swap(arr, i, i+1);
                }
            }
            else {
                // current element should become a trough
                if (arr[i]> arr[i+1]){
                    swap(arr, i, i+1);
                }
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
