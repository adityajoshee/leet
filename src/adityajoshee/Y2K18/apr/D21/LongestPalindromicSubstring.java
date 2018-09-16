package adityajoshee.Y2K18.apr.D21;

/**
 * Created by aditya.joshee on 4/21/18.
 */
public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        String str = "geekxkeesskeeg";
        System.out.println(find(str.toCharArray()));
        System.out.println(optitmisedDP(str.toCharArray()));
    }

    // On2 time and On2 space
    private static int find(char[] str) {
        boolean[][] isPalin = new boolean[str.length][str.length];
        int maxLen = 1;

        // len 1 palindromes
        for (int i = 0; i < isPalin.length; i++) {
            isPalin[i][i] = true;
        }

        // len 2 palindromes
        for (int i = 0; i < isPalin.length-1; i++) {
            if (str[i]==str[i+1]){
                maxLen = 2;
                isPalin[i][i+1]=true;
            }
        }

        // len 3+ palindromes
        for (int len = 3; len <= str.length; len++) {
            for (int i = 0; i < str.length-len+1; i++) {
                if (str[i]==str[i+len-1] && isPalin[i+1][i+len-2]){
                    maxLen = len;
                    isPalin[i][i+len-1] = true;
                }
            }
        }
        return maxLen;
    }

    //manacher's algo On time
    public static int manacher(){
        return -1; //todo
    }


    public static int optitmisedDP(char[] str){
        // findMethod1 even & odd length palindromes separately
        
        int low;
        int high;

        int maxLen = 0;
        for (int i = 0; i < str.length; i++) {
            low = i;
            high = i+1;
            // even len palindrome
            while (high<str.length && low>=0) {
                if (str[low]==str[high]){
                    maxLen = Math.max(maxLen, high-low+1);
                    low--;
                    high++;
                }
                else {
                    break;
                }
            }
            // odd len palindrome
            int r = 0;
            low = i;
            while (low+r<str.length && low-r>=0) {
                if (str[low+r]==str[low-r]){
                    maxLen = Math.max(maxLen, r*2+1);
                    r++;
                }
                else {
                    break;
                }
            }
        }
        return maxLen;
    }
}
