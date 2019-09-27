package adityajoshee.dsa.strings;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by aditya.joshee on 2019-09-03.
 */
public class MinimumWindowSubstring {
    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
    }
    public static String minWindow(String s, String t) {
        if(s==null || t==null || s.length()<t.length()) return "";
        String minWin = "";
        int minWinLen = Integer.MAX_VALUE;
        Map<Character, Integer> freqMap = new HashMap<>(); // or use array of size 128/256
        for(int i=0; i<t.length(); i++){
            freqMap.put(new Character(t.charAt(i)), freqMap.getOrDefault(t.charAt(i),0)+1);
        }

        int i=0,j=0,matches=0;
        while(j<s.length()){
            // move j
            if(freqMap.get(s.charAt(j))!=null){
                if(freqMap.get(s.charAt(j))>0){
                    matches++;
                }
                // if(matches==t.length()){
                //     minWinLen = Math.min(minWinLen, j-i+1);
                //     minWin = s.substring(i, minWinLen);
                // }
                freqMap.put(s.charAt(j), freqMap.get(s.charAt(j))-1);
            }
            j++;

            while(matches==t.length()){
                if(minWinLen>j-i){
                    minWinLen = j-i;
                    minWin = s.substring(i, i+minWinLen);
                }
                // move i
                if(freqMap.get(s.charAt(i))!=null){
                    if(freqMap.get(s.charAt(i))==0){
                        matches--;
                    }
                    freqMap.put(s.charAt(i), freqMap.get(s.charAt(i))+1);
                }
                i++;
            }
        }
        return minWin;
    }
}
