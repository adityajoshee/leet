package adityajoshee.dsa.array.nextHigherElement;

import java.util.Stack;

/**
 * Created by aditya on 8/13/16.
 */

// http://www.geeksforgeeks.org/next-greater-element/

public class NextGreaterElement {


    public static void main(String args[]){

        int[] arr = new int[]{7,4,5,0,8,2,1,9};
        printNextGreaterElement(arr);

    }
    private static void printNextGreaterElement(int[] arr){
        Stack stack = new Stack();
        stack.push(arr[0]); // better to put index than element

        for(int i=1; i<arr.length; i++){

            while(!stack.empty() && arr[i]>(int)stack.peek()){
                int p = (int)stack.pop();
                System.out.println(p+"->"+arr[i]);
            }
            stack.push(arr[i]);
        }
    }
}
