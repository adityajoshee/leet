package datastructure.stack;

/**
 * Created by adityajoshee on 29/04/16.
 */
public class ReverseStack {
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

    private static void reverseStack(MyStack<Integer> stack){

        if(stack.isEmpty()){
            return;
        }
        Integer current = popBottom(stack);
        reverseStack(stack);
        stack.push(current);
    }

    // removes the bottom element from the stack (go to the bottom.
    // Skip pushing the bottom to stack, but put all other again to stack and return bottomo )
    private static Integer popBottom(MyStack<Integer> stack){
        Integer bottom = null;
        if(!stack.isEmpty()) {
            Integer current = stack.pop();
            if(stack.isEmpty()){
                return current;
            }
            bottom  = popBottom(stack);
            stack.push(current);
        }
        return bottom;
    }
}
