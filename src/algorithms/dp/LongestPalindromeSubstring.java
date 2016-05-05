package algorithms.dp;

/**
 * Created by adityajoshee on 28/04/16.
 *
 *
 * // Solution using DP
 */
public class LongestPalindromeSubstring {
    public static void main(String[] a) {
        String input = "ALITXTILXP";
        char[] ip = input.toCharArray();
        //System.out.print(isPalindrome(ip,0,ip.length-1));
        if (ip.length > 1) {
            System.out.println(longestPalindromicSubstring(ip));
        }
    }

    private static int longestPalindromicSubstring(char[] input) {
        return -1;
    }
}
