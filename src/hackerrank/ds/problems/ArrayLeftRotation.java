package hackerrank.ds.problems;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by aditya on 9/5/16.
 */
public class ArrayLeftRotation{
    public static void main(String args[]) throws Exception{
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int d = Integer.parseInt(input[1]);
        String[] nums = br.readLine().split(" ");
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(nums[i]);
        }
        leftShift(arr,d);
        for(int i=0; i<n; i++){
            System.out.print(arr[i]+ " ");
        }
    }

    private static int[] leftShift(int[] arr, int d){
        reverse(arr, 0, d-1);
        reverse(arr, d, arr.length-1);
        reverse(arr, 0, arr.length-1);
        return arr;
    }
    private static void reverse(int[] arr, int l, int r){
        while(l<r){
            swap(arr,l,r);
            l++;r--;
        }
    }
    private static void swap(int[] arr, int l, int r){
        int k = arr[r];
        arr[r] = arr[l];
        arr[l] = k;
    }
}
