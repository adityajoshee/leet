package adityajoshee.Y2K18.sep.D16;

import java.util.Stack;

public class NextGreaterElement {
    public static void main(String[] args) {
        int[] arr = {4,3,2,5,9,8,1,10};
        find(arr);
    }

    private static void find(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (stack.empty()){
                stack.push(i);
            }
            else {
                while (!stack.empty() && arr[stack.peek()]<arr[i]){
                    int k = stack.pop();
                    System.out.println(arr[k] + " NGE " + arr[i]);
                }
                stack.push(i);
            }

        }
        while (!stack.empty()){
            System.out.println(arr[stack.pop()] + " NGE " + -1);
        }
    }
}
