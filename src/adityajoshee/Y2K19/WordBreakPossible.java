package adityajoshee.Y2K19;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by aditya.joshee on 2019-09-13.
 */
public class WordBreakPossible {
    public static void main(String[] args) {
        Set<String> dict = new HashSet<>();
        dict.add("lee");
        dict.add("leet");
        dict.add("tc");
        dict.add("code");
        System.out.println(wordBreakPossible("", dict));
    }

    private static boolean wordBreakPossible(String leetcode, Set<String> dict) {
        Boolean[] possibleFrom = new Boolean[leetcode.length()];
        return isPossible(0, leetcode, dict, possibleFrom);
    }

    private static boolean isPossible(int i, String input, Set<String> dict, Boolean[] possibleFrom) {
        if(i==input.length()){
            // this mean word break is possible till index input.length() so we should return true.
            return true;
        }
        if (possibleFrom[i]!=null) return possibleFrom[i];
        for(int j=i; j<input.length(); j++){
            if (dict.contains(input.substring(i, j+1)) && isPossible(j+1, input, dict, possibleFrom)){
                return true;
            }
        }
        possibleFrom[i]=false; // this might help reduce future duplicate computation
        return false;
    }
}
