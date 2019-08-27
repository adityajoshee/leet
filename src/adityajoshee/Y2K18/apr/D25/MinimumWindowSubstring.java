package adityajoshee.Y2K18.apr.D25;

/**
 * Created by aditya.joshee on 4/25/18.
 */
public class MinimumWindowSubstring {
    public static void main(String[] args) {
        String S = "bba", T = "ba";
        System.out.println(findMinLenWindow(S.toCharArray(), T.toCharArray()));
    }

    private static String findMinLenWindow(char[] str, char[] pat) {
        int[] strCharCount = new int[256];
        int[] patCharCount = new int[256];
//        for (char c : str){
//            strCharCount[c] = 1;
//        }
        for (char c : pat){
            patCharCount[c] = patCharCount[c]+1;
        }
        int counter = 0;
        int startCurr = -1;
        int min = Integer.MAX_VALUE;

        int x = -1 ,y = -1;
        int i = 0;
        while (i<str.length){

            if (patCharCount[str[i]]>0 && strCharCount[str[i]]<patCharCount[str[i]]){
                counter++;
                strCharCount[str[i]]=strCharCount[str[i]]+1;
                if (startCurr==-1){
                    startCurr = i;
                }

                if (counter==pat.length){
                    if (min>i-startCurr){
                        min = i-startCurr+1;
                        x = startCurr;
                        y = i;
                    }

                    //reset start and counter and strCharCounts
                    for (int j = 0; j < strCharCount.length; j++) {
                        strCharCount[j] = 0;
                    }
                    i = startCurr+1;
                    startCurr = -1;
                    counter = 0;
                }
                else {
                    i++;
                }
            }
            else {
                i++;
            }
        }
//        System.out.println(x+","+y);
        if(x==-1 || y==-1){
            return "";
        }
        return new String(str).substring(x,y+1);
    }

    //optimized
    public String minWindow(String s, String t) {
        if(t.length()>s.length()) return "";
        String min=null;
        if(t.length()>s.length()) return min;

        int[] tFreq = new int[128];
        int[] wFreq = new int[128];
        for(Character c: t.toCharArray()){
            tFreq[c]++ ;
        }

        int left = 0, right = 0, count = 0;

        while(right<s.length()){
            while(right<s.length() && count<t.length()){
                char c = s.charAt(right);
                wFreq[c]++ ;
                if(tFreq[c]>=wFreq[c]){
                    count++;
                }
                right++;
            }
            while(count==t.length()){
                char c = s.charAt(left);
                min = min==null ? s.substring(left, right) : right-left<min.length() ? s.substring(left, right) : min;

                wFreq[c]-- ;
                if(wFreq[c]<tFreq[c]){
                    count--;
                }
                // System.out.println(left + "-"+ right+"-"+min+"-"+count);
                left++;
            }
        }
        return min==null ? "" : min;
    }
}
