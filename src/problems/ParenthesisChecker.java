package problems;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by aditya.joshee on 08/09/14.
 */
public class ParenthesisChecker {
    public static void main(String args[]){
        char[] input = {'[','[','3',']','{','}','(','2',')'};
        System.out.println("Are parenthesis balanced? "+ parenCheck(input));
    }
    private static boolean parenCheck(char[] input){
        ArrayList tokens = new ArrayList();

        tokens.add('[');
        tokens.add(']');
        tokens.add('{');
        tokens.add('}');
        tokens.add('(');
        tokens.add(')');

        Stack stack = new Stack();
        for(int i=0;i<input.length;i++){
            if(tokens.contains(input[i])){
                if(input[i]=='[' || input[i]=='(' || input[i]=='{'){
                    stack.push(input[i]);
                }
                else{
                    if(stack.peek().toString().charAt(0)=='[' && input[i]==']' ||
                            stack.peek().toString().charAt(0)=='(' && input[i]==')' ||
                                stack.peek().toString().charAt(0)=='{' && input[i]=='}'
                    ){
                        stack.pop();
                        System.out.println("true till now");
                    }
                    else{
                        return false;
                    }
                }
            }
        }
        if(stack.empty()){
            return true;
        }
        return false;
    }
}
