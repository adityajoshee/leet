package datastructure.stack;

import java.util.Stack;

/**
 * Created by aditya on 8/21/16.
 */

public class MiddlePrintDelete {
    public static void main(String args[]){
        Stack<Integer> s = new Stack<>();
        for(int i=1; i<=5; i++)
            s.push(i);

        execute(s,0, new Size());
    }

    private static class Size{
        int val = 0;
    }

    private static void execute(Stack<Integer> s,int depth, Size size){
        if(s.empty()){
            size.val = depth;
            System.out.println("SIZE:"+ size.val);
            return ;
        }
        int e = s.pop();
        execute(s,depth+1,size);
        if(depth == size.val/2){
            System.out.println(e);
        }
        s.push(e);
    }
}
