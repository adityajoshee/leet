package adityajoshee.dsa.strings;

/**
 * Created by adityajoshee on 17/05/16.
 */

// uses PrefixFunctionKMP.java

public class KMP {
    public static void main(String args[]){
        String patternString = "bcbb";
        char[] pattern = patternString.toCharArray();
        int[] prefixArray = PrefixFunctionKMP.generatePrefixFunction(pattern);
        String textString = "abcbcabcbcbb";
        char[] text = textString.toCharArray();
        System.out.println(search(text,pattern,prefixArray));
    }

    public static int search(char[] text, char[] pattern, int[] prefixArray){

        int p = 0; // current index of pattern;

        for(int i=0; i<text.length; i++){
            //System.out.print(i+" "+p+"    ");
            if(text[i]==pattern[p]){
                p++;
                if(p==pattern.length){
                    return i-pattern.length+1;
                }
            }
            else{
                if(p==0){
                    // simple go to next char in text
                }
                else{
                    // retreat
                    p=prefixArray[p-1];
                    //System.out.print("retreat:"+p+"    ");
                    i--; // keep i to same position (-1 bcoz it will be incr in loop)
                }
            }
        }
        return -1; // not found

    }




}
