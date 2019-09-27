package adityajoshee.Y2K19;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by aditya.joshee on 2019-09-13.
 */
public class StringToDictionaryWordSentence {
    public static void main(String[] args) {
        Set<String> dict = new HashSet<>();
        dict.add("adity");
        dict.add("adi");
        dict.add("a");
        dict.add("ditya");
        System.out.println(stringToDictionaryWordSentence("aaditya", dict));
    }

    private static String stringToDictionaryWordSentence(String input, Set<String> dict) {
        return convert(0, input, "", dict);
    }

    private static String convert(int s, String input, String sen, Set<String> dict) {
        if (s==input.length()){
            return sen;
        }
        for (int i=s; i<input.length(); i++){
            String t = sen;
            if (dict.contains(input.substring(s, i+1))){
                sen = sen+input.substring(s, i+1)+" ";
                String res = convert(i+1, input, sen, dict);
                if (res!=null) return res;
                sen = t;
            }
        }
        return null;
    }
}
