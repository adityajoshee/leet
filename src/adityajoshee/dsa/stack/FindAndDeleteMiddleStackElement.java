package adityajoshee.dsa.stack;

import java.util.Stack;

/**
 * Created by aditya on 8/21/16.
 */

// stack size is unknown...so can't use size() function.

public class FindAndDeleteMiddleStackElement {
    public static void main(String args[]){
        Stack<Integer> s = new Stack<>();
        for(int i=1; i<=5; i++)
            s.push(i);

        findMiddle(s,0, new Size());
        deleteMiddle(s,0, new Size());
        findMiddle(s,0,new Size());
    }

    private static class Size{
        int val = 0;
    }

    private static void findMiddle(Stack<Integer> s, int depth, Size size){
        if(s.empty()){
            size.val = depth;
            System.out.println("SIZE:"+ size.val);
            return ;
        }
        int e = s.pop();
        findMiddle(s,depth+1,size);
        if(depth == size.val/2){
            System.out.println(e);
        }
        s.push(e);
    }

    private static void deleteMiddle(Stack<Integer> s, int depth, Size size ){
        if(s.empty()){
            size.val = depth;
            System.out.println("SIZE:"+ size.val);
            return ;
        }
        int e = s.pop();
        if(depth != size.val/2){
            s.push(e);
        }
    }
}
