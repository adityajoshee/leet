package algorithms.recursion;

/**
 * Created by adityajoshee on 17/04/16.
 */
public class StringPermutations {

    public void printPermutations(String s){
        char[] input = s.toCharArray();
        helper(0, input.length - 1, input);
    }

    private void helper(int left, int right, char[] s){
        if(left==right){
            System.out.println(s);
        }
        else{
            for(int i=left;i<=right;i++){
                swap(s,left,i);
                helper(left + 1, right, s);
                swap(s,left,i);
            }
        }

    }
    private void swap(char[] s,int x, int y){
        char t= s[x];
        s[x] = s[y];
        s[y] = t;
    }

    public static void main(String ar[]){
        StringPermutations problemObject = new StringPermutations();
        problemObject.printPermutations("123");
    }
}
