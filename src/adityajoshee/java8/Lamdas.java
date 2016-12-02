package adityajoshee.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.*;

/**
 * Created by aditya.joshee on 07/08/15.
 */
public class Lamdas {
    public static void main(String args[]){
        List<Integer> list= Arrays.asList(1,2,4,6,7,8,0,9);
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
        List<String> myList =
                Arrays.asList("a1", "a2", "b1", "c2", "c1");
    }
}
