package adityajoshee.Y2K19.sep;

/**
 * Created by aditya.joshee on 2019-09-27.
 */
public class SCS {

    public static void main(String[] args) {

        System.out.println(shortestCommonSupersequence("abac","cababab"));
    }
    public static String shortestCommonSupersequence(String s1, String s2) {
    /*
    take the longer string as the base string. if s1 = "abac", s2 = "cbec"
    s1 is the base. Find the LCS of s1 and s2. It will be "bc". Now we need to add 'c' and 'e'
    in s1 in order as they appear in s2.
    */

        String lcs = lcs(s1, s2);
//        System.out.println(lcs);
        int i=0, j=0, l=0;
        StringBuffer sb = new StringBuffer();
        while(l<lcs.length()){
            while(i<s1.length() && l<lcs.length() && lcs.charAt(l)!=s1.charAt(i)){
                sb.append(s1.charAt(i++));
            }
            while(j<s2.length() && l<lcs.length() && lcs.charAt(l)!=s2.charAt(j)){
                sb.append(s2.charAt(j++));
            }

            if (l<lcs.length()){
                sb.append(lcs.charAt(l));
                l++; i++; j++;
            }
        }
        sb.append(s1.substring(i)).append(s2.substring(j));
        return sb.toString();
    }

    private static String lcs(String s1, String s2){
        if(s1.length()==0 || s2.length()==0) return "";

        String[][] dp = new String[s1.length()+1][s2.length()+1];
        for(int i=0; i<dp.length; i++){
            dp[i][0] = "";
        }
        for(int j=0; j<dp[0].length; j++){
            dp[0][j] = "";
        }
        for(int i=1; i<dp.length; i++){
            for(int j=1; j<dp[0].length; j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] +  s1.charAt(i-1) ;
                }
                else{
                    dp[i][j] = dp[i-1][j].length() > dp[i][j-1].length() ? dp[i-1][j] : dp[i][j-1];
                }
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }

}
