package adityajoshee.dsa.stack;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by adityajoshee on 29/04/16.
 */
public class BalancedParenthesis {

    private static Set leftParenthesis = new HashSet<>();
    private static Set rightParenthesis = new HashSet<>();

    static {
        leftParenthesis.add('{');
        leftParenthesis.add('[');
        leftParenthesis.add('(');

        rightParenthesis.add('}');
        rightParenthesis.add(']');
        rightParenthesis.add(')');
    }


    public static void main(String args[]){
        char[] input = {'(','[','{','}','(',')','(',')','[',']',')'};
        System.out.println(isBalanced(input));
    }

    private static boolean isBalanced(char[] input){

        MyStack<Character> stack = new MyStack<>(input.length/2+1);
        for(int i =0; i<input.length; i++){
            if(stack.isFull()){
                return false;
            }
            if(leftParenthesis.contains(input[i])){
                stack.push(input[i]);
            }
            else if (stack.isEmpty()){
                return false;
            }
            else {
                Character c = stack.peek();
                if(c.equals('{') && input[i]=='}'){
                    stack.pop();
                    continue;
                }
                if(c.equals('[') && input[i]==']'){
                    stack.pop();
                    continue;
                }
                if(c.equals('(') && input[i]==')'){
                    stack.pop();
                    continue;
                }
                else{
                    System.out.println("Error at : "+input[i]);
                    return false;
                }
            }
        }
        if(!stack.isEmpty()){
            return false;
        }
        return true;
    }
}
