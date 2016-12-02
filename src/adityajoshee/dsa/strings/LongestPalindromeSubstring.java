package adityajoshee.dsa.strings;

/**
 * Created by adityajoshee on 28/04/16.
 */

// Brute force approach - O(N^3)
// checks all substrings and keep track of current max size palindrome.

public class LongestPalindromeSubstring {

    public static void main(String[] a){
        String input = "CBBAKKABBCXLITOTILXD";
        char[] ip=input.toCharArray();
        //System.out.print(isPalindrome(ip,0,ip.length-1));
        if(ip.length>1){
            System.out.println(longestPalindromicSubstring(ip));
        }
    }

    private static int longestPalindromicSubstring(char[] input){

        int tempMaxSize = 1;  // String is 1 char is always a palindrome
        for(int i=0; i<input.length; i++){
            for (int j=i; j<input.length; j++){
                if(isPalindrome(input,i,j)){
                    if(tempMaxSize<(j-i+1)){
                        tempMaxSize=j-i+1;
                    }
                }
            }
        }
        return tempMaxSize;
    }

    private static boolean isPalindrome(char[] chars, int start, int end){
        for(int i=start,j=end; i<=(end-1)/2; i++,j--){
            if(chars[i]!=chars[j]){
                return false;
            }
        }
        return true;
    }
}
