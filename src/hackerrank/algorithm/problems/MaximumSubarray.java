package hackerrank.algorithm.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by aditya on 9/10/16.
 */
public class MaximumSubarray {
    public static void main(String args[]) throws IOException{
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        int t = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(bufferedReader.readLine());
            String[] inputs = bufferedReader.readLine().split(" ");
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(inputs[j]);
            }
            int[] sums = getMaxSums(arr);
            System.out.println(sums[0]+" "+sums[1]);
        }
    }
    private static int[] getMaxSums(int[] arr){
        int maxElement = arr[0];
        int currentMaxSum = 0;
        int maxSum = 0;
        boolean allNegative = true;
        int positivesSum = 0;
        int[] sums = new int[2];
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]>maxElement){
                maxElement = arr[i];
            }
            if(arr[i]>=0){
                allNegative=false;
                positivesSum += arr[i];
            }
            currentMaxSum = currentMaxSum+arr[i]<0?0:currentMaxSum+arr[i];
            maxSum = maxSum<currentMaxSum?currentMaxSum:maxSum;
        }
        if(allNegative){
            sums[0] = maxElement;
            sums[1] = maxElement;
        }
        else{
            sums[0] = maxSum;
            sums[1] = positivesSum;
        }
        return sums;
    }
}
