package adityajoshee.dsa.array;

/**
 * Created by aditya on 10/14/16.
 */
public class Regex {
    // regex must have min length of 2
    // . means prev char must come once.
    // * mean prev char can come 0 or more times.
    public static void main(String args[]){
        char[] reg = {'a','*','b'};
        String input = "aaab";
        char[] str = input.toCharArray();
        System.out.println(isValid(str, reg));
    }
    private static boolean isValid(char[] str, char[] reg){
        int i=0,k=0;

        while(i<str.length && k<reg.length){
            //if()
        }
        // TODO
        return true;
    }
}
