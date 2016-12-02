package adityajoshee.dsa.array.patternMatching;

/**
 * Created by aditya on 10/24/16.
 */
/*
* --> Matches with 0 or more instances of any character or set of characters.
? --> Matches with any one character.
 */
public class WildcardMatchingRecursive {

    public static void main(String args[]){
        char[] wildcard = "?*a*c?b*".toCharArray();
        char[] input = "aacbcbbjoshee".toCharArray();
        System.out.println(match(input,wildcard, 0, 0));
    }
    private static boolean match(char[] input, char[] wildcard, int i, int j){
        if (i==input.length && j==wildcard.length){
            return true;
        }
        if (i==input.length){
            if (j==wildcard.length-1 && wildcard[j]=='*')
                return true;
            return false;
        }
        if (j==wildcard.length){
            return false;
        }
        if (wildcard[j]=='*'){
            // Critical Branching step
            return match(input,wildcard,i+1,j) || match(input, wildcard, i, j+1);
        }
        if(wildcard[j]=='?' || (wildcard[j] == input[i]) ){
            return match(input,wildcard,i+1, j+1);
        }
        return false;
    }

}
