package adityajoshee.dsa.array.nextHigherElement;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by aditya on 11/23/16.
 */
public class SigmoidNextGreaterElement {
    public static void main(String args[]){
        int[] arr = {4,5,2,20};
        int[][] ansMatrix = find(arr);
        System.out.println(Arrays.toString(ansMatrix[0]));
        System.out.println(Arrays.toString(ansMatrix[1]));

    }
    private static int[][] find(int[] arr){
        if(arr.length==0){
            return null;
        }
        int[][] result = new int[2][arr.length];
        int k = 0;
        Stack<Integer> stack = new Stack();
        stack.push(0); //  push 0th index


        for(int i=1; i<arr.length; i++){
            int topIndex = stack.peek();
            while (!stack.isEmpty() && arr[i] > arr[topIndex]){
                topIndex = stack.pop();
                result[0][k] = arr[topIndex];
                result[1][k] = arr[i];
                k++;
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            int e = stack.pop();
            result[0][k] = arr[e];
            result[1][k] = -1;
        }
        return result;
    }
}