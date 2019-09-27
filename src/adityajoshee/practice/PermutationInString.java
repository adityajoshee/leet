package adityajoshee.practice;

/**
 * Created by aditya.joshee on 2019-09-08.
 */
public class PermutationInString {
    public static void main(String[] args) {
        System.out.println(checkInclusion("abcdxabcde","abcdeabcdx"));
    }
    public static boolean checkInclusion(String s1, String s2) {
        if(s2.length()<s1.length()) return false;

        // maintain freq of chars in current window of s2 and
        // match against the freq of chars in s1

        int[] s1freq = new int[26];
        int[] s2freq = new int[26];

        for(int i=0; i<s1.length(); i++){
            s1freq[s1.charAt(i)-'a']++;
        }
        int i=0, j=0, matches = 0;
        while(j<s2.length()){
            //add the new char in window, incr freq. by 1
            s2freq[s2.charAt(j)-'a']++;

            // if new char has higher freq than in s1, reduce the window from left
            if(s1freq[s2.charAt(j)-'a'] < s2freq[s2.charAt(j)-'a']){
                if(s1freq[s2.charAt(i)-'a']==s2freq[s2.charAt(i)-'a']){
                    matches--;
                }
                s2freq[s2.charAt(i)-'a']--;
                i++;
                continue;
            }

            //update matches if freq. matches.
            //if freq of chars in the curr window matches that in s1 ret true
            //else increase window
            if(s1freq[s2.charAt(j)-'a'] == s2freq[s2.charAt(j)-'a']){
                matches++;
                if(matches==s1.length()){
                    return true;
                }
            }
            j++;
        }
        return false;
    }
}