package adityajoshee.Y2K19.oct;

/**
 * Created by aditya.joshee on 2019-10-02.
 */
//https://leetcode.com/problems/minimum-window-substring/
public class MinWindowSubstringAllCharsPresent {
    public static void main(String[] args) {
        String S = "a";
        String T = "a";
        System.out.println(minWindow(S, T));
    }
    public static String minWindow(String s, String t) {
        String res = "";
        if(s.length()==0 || s.length()<t.length()) return res;

        int[] tfreq = new int[256];
        boolean[] isReq = new boolean[265];
        char[] tc = t.toCharArray();
        char[] sc = s.toCharArray();

        for(int i=0; i<tc.length; i++){
            tfreq[tc[i]]++;
            isReq[tc[i]] = true;
        }
        int i=0,j=0,m=0,min=Integer.MAX_VALUE;

        while(j < sc.length){
            if(isReq[sc[j]] && tfreq[sc[j]]>0){ // if the new char is required
                m++;             // incr matches
            }
            tfreq[sc[j]]--; // reduce the count of this char now required.
            while(i<j && m==tc.length){    // check if all chars are in the current window i,j
                if(min > j-i+1){    // update min
                    res = s.substring(i, j+1);   // update res
                    min = j-i+1;
                }
                if(isReq[sc[i]]){  // now reduce window from left
                    if(tfreq[sc[i]]>=0) m--;
                    tfreq[sc[i]]++;
                }
                i++;
            }
            j++;
        }
        return res;
    }
}