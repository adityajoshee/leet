package adityajoshee.dsa.array.nextHigherElement;

import java.util.Stack;

/**
 * Created by aditya on 10/17/16.
 */
//http://stackoverflow.com/questions/19720349/find-next-higher-element-in-an-array-for-each-element

public class NextHigherElementForEach {
    public static void main(String args[]){
        int[] arr = {2,1,4,3,2,0,5,9,6};
        printNextHigher(arr);
    }
    private static void printNextHigher(int[] arr){
        Stack<Integer> stack = new Stack<>();
        stack.push(arr[0]);
        int i=1;
        while (i<arr.length){
            while(!stack.empty() && arr[i]>stack.peek()){
                int popped = stack.pop();
                System.out.println(popped+"->"+arr[i]);
            }
            stack.push(arr[i++]);
        }
        while (!stack.isEmpty()){
            System.out.println(stack.pop()+"->"+"X");
        }
    }
}
