package adityajoshee.dsa.stack;

import java.util.Random;
import java.util.Stack;

/**
 * Created by aditya on 11/30/16.
 */
// stack operation with getMin() in O(1)

public class MinStack {
    public static void main(String args[]) throws Exception{
        Random r = new Random();
        MyMinStack<Integer> myMinStack = new MyMinStack<>();
        for (int i = 0; i < 5; i++) {
            int x = r.nextInt(15);
            myMinStack.push(x);
            System.out.print(x+" -> ");
            System.out.println(myMinStack.getMin());
        }
        myMinStack.pop();
        myMinStack.pop();
        System.out.println(myMinStack.getMin());
    }

    static class MyMinStack<T extends Comparable>{
        Stack<T> stack = new Stack<>();
        Stack<T> minKeeper = new Stack<>();

        void push(T t){
            stack.push(t);
            if (minKeeper.size()==0){
                minKeeper.push(t);
            }
            else if (t.compareTo(minKeeper.peek())<=0){
                minKeeper.push(t);
            }
        }

        T pop() {
            if (stack.size()>0){
                T t = stack.pop();
                if (t.compareTo(minKeeper.peek())==0){
                    minKeeper.pop();
                }
                return t;
            }
            return null;
        }

        T getMin() throws Exception{
            if (stack.size()>0){
                return minKeeper.peek();
            }
            else {
                throw new Exception();
            }
        }
    }
}
