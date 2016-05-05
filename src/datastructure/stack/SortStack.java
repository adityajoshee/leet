package datastructure.stack;

/**
 * Created by adityajoshee on 30/04/16.
 */
public class SortStack {
    public static void main(String args[]){
        MyStack<Integer> stack = new MyStack<>(10);
        int i=9;
        while (i>=0){
            stack.push(i--);
        }
        stack.printCurrentStack();

        sortStack(stack);
        stack.printCurrentStack();
    }

    private static void sortStack(MyStack<Integer> stack){
        if(!stack.isEmpty()){
            Integer x = stack.pop();
            sortStack(stack);
            sortedInsert(stack,x);
        }
    }

    private static void sortedInsert(MyStack<Integer> stack , Integer p){
        if(stack.isEmpty() || stack.peek()<p){
            stack.push(p);
            return;
        }
        Integer currentTop = stack.pop();
        sortedInsert(stack,p);
        stack.push(currentTop);

    }

    /*
      0
    4
    3
     */
}
