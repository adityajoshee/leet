package adityajoshee.Y2K19.sep;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by aditya.joshee on 2019-09-13.
 */
public class WordBreak1 {
    public static void main(String[] args) {
        Set<String> dict = new HashSet<>();
        dict.add("leet");
        dict.add("c");
        dict.add("cod");
        dict.add("ode");
        System.out.println(wordBreak("leetcode", dict));
    }

    private static boolean wordBreak(String str, Set<String> dict) {
        boolean[] dp = new boolean[str.length()+1];
        dp[0] = true; // empty string
        for (int i = 1; i <= str.length(); i++) {
            for (int j = i-1; j >= 0 ; j--) {
                dp[i] = dp[j] && dict.contains(str.substring(j, i));
                if (dp[i]) break;
            }
        }
        return dp[dp.length-1];
    }
}
