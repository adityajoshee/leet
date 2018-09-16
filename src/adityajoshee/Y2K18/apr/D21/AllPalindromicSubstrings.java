package adityajoshee.Y2K18.apr.D21;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by aditya.joshee on 4/21/18.
 */
public class AllPalindromicSubstrings {
    public static void main(String[] args) {
        String input = "abaaa";
        Set<String> output = new HashSet<>();
        findAndAddToOutput(input.toCharArray(), 0, input.length()-1, output);
        for (String s : output){
            System.out.println(s);
        }
        List<List<String>> lists = Solution.partition(input);
    }

    private static void findAndAddToOutput(char[] chars, int i, int j, Set<String> output) {
        if (i<0 || j>=chars.length){
            return;
        }
        if(isPalindrome(chars, i, j)){
            output.add(new String(chars, i, j-i+1));
        }
        for (int k = i; k < j; k++) {
            findAndAddToOutput(chars, i, k, output);
            findAndAddToOutput(chars, k+1, j, output);
        }
    }


    public static boolean isPalindrome(char[] arr, int l, int r){
        while (l<r){
            if (arr[l]!=arr[r]){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }



    public static class Solution {
        public static List<List<String>> partition(String s) {
            List<List<String>> res = new ArrayList<>();
            List<String> list = new ArrayList<String>();
            dfs(s,0,list,res);
            return res;
        }

        public static void dfs(String s, int pos, List<String> list, List<List<String>> res){
            if(pos==s.length()) res.add(new ArrayList<String>(list));
            else{
                for(int i=pos;i<s.length();i++){
                    if(isPal(s,pos,i)){
                        list.add(s.substring(pos,i+1));
                        dfs(s,i+1,list,res);
                        list.remove(list.size()-1);
                    }
                }
            }
        }

        public static boolean isPal(String s, int low, int high){
            while(low<high) if(s.charAt(low++)!=s.charAt(high--)) return false;
            return true;
        }

    }
}
