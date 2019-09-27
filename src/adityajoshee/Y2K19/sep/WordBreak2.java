package adityajoshee.Y2K19.sep;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by aditya.joshee on 2019-09-13.
 */
public class WordBreak2 {
    public static void main(String[] args) {
        String str = "aaaaaaaaaaaaa";
        String[] dictionary = {"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"};
        Set<String> dict = new HashSet<>(Arrays.stream(dictionary).collect(Collectors.toSet()));

//        dict.addAll(dictionary);
//        dict.add("e");
//        dict.add("l");
//        dict.add("tcod");
//        dict.add("c");
//        dict.add("cod");
//        dict.add("e");
//        dict.add("ode");

        List<String> res = wordBreak(str, dict);
        for(String s: res){
            System.out.println(s);
        }
    }

    public static List<String> wordBreak(String s, Set<String> wordDict) {
        return wordBreakHelper(s, wordDict, new HashMap());
    }
    public static List<String> wordBreakHelper(String s, Set<String> wordDict, HashMap<String,List<String>> map) {
        List<String> res = new ArrayList();
        if(s == null || s.length() == 0) {
            return res;
        }
        if(map.containsKey(s)) {
            return map.get(s);
        }
        if(wordDict.contains(s)) {
            res.add(s);
        }
        for(int i = 1 ; i <= s.length() ; i++) {
            String t = s.substring(i);
            if(wordDict.contains(t)) {
                List<String> temp = wordBreakHelper(s.substring(0 , i) , wordDict, map);
                for(int j = 0 ; j < temp.size() ; j++) {
                    res.add(temp.get(j) + " " + t);
                }
            }
        }
        map.put(s , res);
        return res;
    }


    private static List<String> wordBreak2(String str, Set<String> dict) {
        List<String> res = new LinkedList<>();
        find(0, str, "", dict, res);
        return res;
    }

    private static boolean find(int i, String str, String curr, Set<String> dict, List<String> res) {
        if (i==str.length()){
            // we reached end
            res.add(curr.substring(0, curr.length()-1));
            return true;
        }
        for(int j=i; j <= str.length(); j++){
            if (dict.contains(str.substring(i, j))){
                find(j, str, curr + str.substring(i, j)+ " ", dict, res);
            }
        }
        return false;
    }
}
