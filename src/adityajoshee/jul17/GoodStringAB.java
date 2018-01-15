package adityajoshee.jul17;

import java.util.Scanner;

/**
 * Created by aditya.joshee on 7/23/17.
 * abab
 */
public class GoodStringAB {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        System.out.println(isgood(input)==true?"Good":"Bad");
    }
    private static boolean isGood(String s, String curr){
        if (s.equals(curr.toString())){
            return true;
        }
        if (curr.length()>=s.length()){
            return false;
        }
        boolean res = false;
        for (int i = 0; i <= curr.length(); i++) {
            if( res = isGood(s, insert(curr, "ab", i))){
                break;
            }
        }
        return res;
    }

    private static boolean isgood(String input){
        if (input.length()==0){
            return true;
        }
        int indexOfAB = input.indexOf("ab");
        if (indexOfAB!=-1){
            input = input.substring(0,indexOfAB)+ input.substring(indexOfAB+2, input.length());
        }
        else{
            return false;
        }
        return isgood(input);
    }

    public static String insert(String bag, String marble, int index) {
        String bagBegin = bag.substring(0,index);
        String bagEnd = bag.substring(index);
        return bagBegin + marble + bagEnd;
    }
}
