package algorithms.strings;

import java.util.*;

/**
 * Created by adityajoshee on 29/04/16.
 */
public class AnagramsTogetherFromText {

    public static void main(String args[]){
        String[] text = {"abcd","bdca","xyz","azx","cabd","kcd","zyx","acdb","yxz","krp","rpk"};
        System.out.println(printAnagramsTogether(text));
    }
    private static Map<String,List<String>> printAnagramsTogether(String[] text){
        if(text==null){
            return null;
        }

        Map<String,List<String>> anagramToList  = new HashMap<>(10);

        for(int i=0; i<text.length; i++){
            String current = text[i];
            char[] currentInChars = current.toCharArray();
            Arrays.sort(currentInChars);
            String sortedCurrent = new String(currentInChars);

            List<String> listAtCurrentAnagram = anagramToList.get(sortedCurrent);
            if(listAtCurrentAnagram==null){
                listAtCurrentAnagram = new ArrayList<>();
                listAtCurrentAnagram.add(current);
                anagramToList.put(sortedCurrent,listAtCurrentAnagram);
            }
            else{
                listAtCurrentAnagram.add(current);
            }
        }
        return anagramToList;
    }
}
