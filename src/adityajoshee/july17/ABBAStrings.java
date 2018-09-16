package adityajoshee.july17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

/**
 * Created by aditya.joshee on 7/2/17.
 */
/*
One day, Jamie noticed that many English words only use the letters A and B.
Examples of such words include "AB" (short for abdominal), "BAA" (the noise a sheep makes),
 "AA" (a type of lava), and "ABBA" (a Swedish pop sensation).

Inspired by this observation, Jamie created a simple game. You are given two Strings:
initial and target. The goal of the game is to findMethod1 a sequence of valid moves that will change
initial into target. There are two types of valid moves:

Add the letter A to the end of the string.
Add the letter B to the end of the string and then reverse the entire string.
 (After the reversal the newly-added B becomes the first character of the string).
Return "Possible" (quotes for clarity) if there is a sequence of valid moves that will
 change initial into target. Otherwise, return "Impossible".
"A"
"BABA"
Returns: "Possible"

Jamie can perform the following moves:
1. Initially, the string is "A".
2. Jamie adds a 'B' to the end of the string and then reverses the string. Now the string is "BA".
3. Jamie adds a 'B' to the end of the string and then reverses the string. Now the string is "BAB".
4. Jamie adds an 'A' to the end of the string. Now the string is "BABA".
Since there is a sequence of moves which starts with "A" and creates the string "BABA", the answer is "Possible".
 */

public class ABBAStrings {
    public static void main(String args[]) throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String initial = bufferedReader.readLine();
        String target = bufferedReader.readLine();
        //System.out.println(isTransformationPossible(initial, target, falseOutcomeInputs)==true?"Possible":"Impossible");
        System.out.println(isPossible(initial, target)==true?"Possible":"Impossible");

    }

    private static boolean isTransformationPossible(String initial, String target, HashSet<String> falseOutcomeInputs) {
        if (falseOutcomeInputs.contains(initial)){
            return false;
        }
        if (initial.length()==target.length()){
            if (initial.equals(target)){
                return true;
            }
            else{
                falseOutcomeInputs.add(initial);
                return false;
            }
        }
        System.out.println(falseOutcomeInputs.size());
        return isTransformationPossible(initial.concat("A"), target, falseOutcomeInputs) || isTransformationPossible(reverse(initial.concat("B")), target, falseOutcomeInputs);
    }

    private static String reverse(String s){
        char[] chars = s.toCharArray();
        int i = 0;
        int j = chars.length-1;
        while (i<j){
            char t = chars[i];
            chars[i]=chars[j];
            chars[j] = t;
            i++; j--;
        }
        return new String(chars);
    }

    private static boolean isPossible(String initial, String target){
        if (initial.equals(target)){
            return true;
        }
        if (target.length()<initial.length() || target.length()<=0){
            return false;
        }
        char lastChar = target.charAt(target.length()-1);
        char firstChar = target.charAt(0);
        boolean m1 = false, m2 = false;
        if (lastChar=='A'){
            m1 = isPossible(initial, target.substring(0, target.length()-1));
        }
        if (firstChar=='B'){
            m2 = isPossible(initial, reverse(target.substring(1, target.length())));
        }
        return m1||m2;
    }

}
