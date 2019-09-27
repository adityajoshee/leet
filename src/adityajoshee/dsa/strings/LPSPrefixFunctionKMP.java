package adityajoshee.dsa.strings;

/**
 * Created by adityajoshee on 16/05/16.
 */


// generating prefix func is the first half of KMP

public class LPSPrefixFunctionKMP {

    public static void main(String args[]){
        String patternString  = "abaaab";

        char[] pattern = patternString.toCharArray();

        for(int i=0;i<pattern.length;i++)
            System.out.print(pattern[i]+" ");
        System.out.println();
        int[] prefixFunction = generatePrefixFunction(pattern);
        for(int i=0;i<prefixFunction.length;i++)
            System.out.print(prefixFunction[i]+" ");
    }


    public static int[] generatePrefixFunction(char[] pattern){
        int len=0;
        int[] prefixArray = new int[pattern.length];
        prefixArray[0]=0; // as we are looking only for PROPER prefixes.
        int i=1;

        while (i<pattern.length){
            if(pattern[i]==pattern[len]){
                len++;
                prefixArray[i]=len;
                i++;
            }
            else {
                if(len==0){
                    prefixArray[i]=0;
                    i++;
                }
                else{
                    len=prefixArray[len-1];
                }
            }
        }
        return prefixArray;
    }
}
