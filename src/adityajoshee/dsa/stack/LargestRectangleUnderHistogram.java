package adityajoshee.dsa.stack;

import java.util.Stack;

/**
 * Created by aditya.j on 3/30/17.
 */
//http://www.geeksforgeeks.org/largest-rectangle-under-histogram/
public class LargestRectangleUnderHistogram {
    public static void main(String args[]){
        int[] arr = {5,0,2,3,1,7};
        System.out.println(findMaxArea(arr));
    }
    private static int findMaxArea(int arr[]){
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        for (int i = 0; i < arr.length; i++) {
            if (stack.isEmpty() || arr[i]>arr[stack.peek()]){
                stack.push(i);
            }
            else if (arr[i]==arr[stack.peek()]){

            }
            else{
                //new element is smaller than top
                while(!stack.isEmpty() && arr[i]<arr[stack.peek()]){
                    int poppedIndex = stack.pop();
                    int lesserIndex = -1;
                    if (!stack.isEmpty()){
                        lesserIndex = stack.peek();
                    }
                    maxArea = maxArea>=arr[poppedIndex]*(i-lesserIndex-1)?maxArea:arr[poppedIndex]*(i-lesserIndex-1);
                }
                stack.push(i);
            }
        }
        while (!stack.empty()){
            int x = stack.pop();
            int left = -1;
            if (!stack.isEmpty()){
                left = stack.peek();
            }
            maxArea = Math.max(maxArea,arr[x]*(arr.length-left-1));//?maxArea:arr[x]*(arr.length-lesser-1);
        }
        return  maxArea;
    }

}
