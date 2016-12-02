package adityajoshee.dsa.datastructure.binarytree.bstFromPreorder;

import java.util.Stack;

/**
 * Created by aditya on 11/27/16.
 */
public class ValidBstPreorderUsingStack {
    public static void main(String args[]){
        int[] preorder = {40, 30, 35, 20, 80};//{6,3,0,5,4,8,7,9};//{3,2,5,1,7};
        System.out.println(isBstPossible(preorder));
    }
    private static boolean isBstPossible(int[] pre){
        Stack<Integer> stack = new Stack<>();
        int lower = -1;
        for (int i = 0; i < pre.length; i++) {
            if (pre[i]<lower){
                return false;
            }
            while (!stack.empty() && pre[i]>stack.peek()){
                lower = stack.pop();
            }
            stack.push(pre[i]);
        }
        return true;
    }
}
