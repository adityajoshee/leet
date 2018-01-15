package adityajoshee.dsa.recursion;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by aditya.j on 5/1/17.
 */
public class WordBreak {
    public static void main(String args[]){
        Set<String> dict = new HashSet<>();
        dict.add("i");
        dict.add("im");
        dict.add("adi");
        System.out.println(find("imadi", dict));
    }

    private static boolean find(String input, Set<String> dict){
        for (int i = 0; i < input.length(); i++) {
            if (dict.contains(input.substring(0,i+1))){
                if(i==input.length()-1 || find(input.substring(i+1), dict)){
                    return true;
                }
            }
        }
        return false;
    }
}

/*
dict = {"adi", "aditya", "joshee"}
input = {"adityajoshee"}
 */
