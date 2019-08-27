package adityajoshee.practice;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by aditya.joshee on 2019-08-18.
 */
public class MinimumWindowSubstring {
    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
    }
    public static String minWindow(String s, String t) {
        if(s.length()==0 || (s.length()<t.length())) return "";
        int[] wfreq = new int[256];
        int[] tfreq = new int[256];
        for(int i=0; i<t.length(); i++){
            tfreq[t.charAt(i)]++;
        }
        int l=0, r=0, matches=0, minLen=Integer.MAX_VALUE;
        String minStr = "";

        while(r<=s.length()){
            if(matches==t.length()){
                if(minLen>r-l){
                    minLen = r-l;
                    minStr = s.substring(l, l+minLen);
                }
                if(tfreq[s.charAt(l)]>=1){
                    if(wfreq[s.charAt(l)]==tfreq[s.charAt(l)]){
                        matches--;
                    }
                    wfreq[s.charAt(l)]--;
                }
                l++;
            }
            else{
                if(r<s.length() && tfreq[s.charAt(r)]>=1){
                    if(wfreq[s.charAt(r)] < tfreq[s.charAt(r)]){
                        matches++;
                    }
                    wfreq[s.charAt(r)]++;
                }
                r++;
            }
        }
        return minStr;
    }
}
