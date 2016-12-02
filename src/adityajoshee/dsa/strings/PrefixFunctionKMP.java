package adityajoshee.dsa.strings;

/**
 * Created by adityajoshee on 16/05/16.
 */


// generating prefix func is the first half of KMP

public class PrefixFunctionKMP {

    public static void main(String args[]){
        String patternString  = "acacabacacabacacac";

        char[] pattern = patternString.toCharArray();

        for(int i=0;i<pattern.length;i++)
            System.out.print(pattern[i]+" ");
        System.out.println();
        int[] prefixFunction = generatePrefixFunction(pattern);
        for(int i=0;i<prefixFunction.length;i++)
            System.out.print(prefixFunction[i]+" ");
    }


    public static int[] generatePrefixFunction(char[] pattern){
        int j=0;
        int[] prefixArray = new int[pattern.length];
        prefixArray[0]=0; // as we are looking only for proper prefixes.

        for(int i=1;i<pattern.length;){
            if(pattern[i]==pattern[j]){
                j++;
                prefixArray[i]=j;
                i++;
            }
            else {
                if(j==0){
                    prefixArray[i]=0;
                    i++;
                }
                else{
                    j=prefixArray[j-1];
                }
            }
        }
        return prefixArray;
    }
}
