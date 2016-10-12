package datastructure.stack;

/**
 * Created by aditya on 8/21/16.
 */
public class ReverseStack2 {
    public static void main(String args[]) {
        MyStack<Integer> stack = new MyStack(10);
        for(int i = 0 ; i<10; i++){
            stack.push(i);
        }
        System.out.println("Original Stack :");
        stack.printCurrentStack();

        reverseStack(stack);
        System.out.println("Reversed Stack :");

        stack.printCurrentStack();
    }

    public static void reverseStack(MyStack<Integer> stack){
        if(stack.isEmpty()){
            return;
        }
        int e = stack.pop();
        reverseStack(stack);
        insertReverted(stack,e);
    }

    public static void insertReverted(MyStack<Integer> stk, int e){
        if(stk.isEmpty()){
            stk.push(e);
            return;
        }
        int x = stk.pop();
        insertReverted(stk, e);
        stk.push(x);
    }

}
