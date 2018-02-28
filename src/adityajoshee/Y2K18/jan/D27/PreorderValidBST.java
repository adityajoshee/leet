package adityajoshee.Y2K18.jan.D27;

import java.util.Stack;

/**
 * Created by aditya.joshee on 1/27/18.
 *
 * Can given array be preorder of a BST?
 */
public class PreorderValidBST {
    public static void main(String[] args) {
        int[] pre = {3,2,1};//{5,3,0,2,1,4,7,9,8};
        System.out.println(canBeBST(pre));
    }

    private static boolean canBeBST(int[] pre) {
        Stack<Integer> stack = new Stack();
        int lastPopped = Integer.MIN_VALUE;
        stack.push(pre[0]);
        for (int i = 1; i < pre.length; i++) {
            if (pre[i]<lastPopped){
                return false;
            }
            if (pre[i]<stack.peek()){
                stack.push(pre[i]);
            }
            else {
                while (!stack.empty() && pre[i]>stack.peek()){
                    lastPopped = stack.pop();
                }
                stack.push(pre[i]);
            }
        }
        return true;
    }
}
