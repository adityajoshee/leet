package adityajoshee.hackerrank.challenges;

/**
 * Created by aditya on 9/12/16.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by aditya on 9/12/16.
 */

// current algorithm is On2 but needs to be updated with nlogn. TODO
public class LIS {
    public static void main(String args[]) throws IOException{
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        int n = Integer.parseInt(bufferedReader.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(bufferedReader.readLine());
        }
        System.out.println(LIS(arr));
    }
    private static int LIS(int[] arr){
        int[] LIS = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            LIS[i] = 1; // since lenght of LIS which ends at i and includes arr[i] will be min 1.
        }
        for (int i = 1; i < arr.length; i++) { // start from 1 as LIS[0] will be 1 everytime.
            for (int j = 0; j < i; j++) {
                if(arr[j] < arr[i] && LIS[i] < 1 + LIS[j]){
                    LIS[i] = 1 + LIS[j];
                }
            }
        }
        return maxElement(LIS);
    }
    // findMethod1 max element from an array
    private static int maxElement(int[] arr){
        int maxOfAll=arr[0];
        for(int i=1;i<arr.length;i++){
            if(arr[i]>maxOfAll){
                maxOfAll=arr[i];
            }
        }
        return maxOfAll;
    }
}
