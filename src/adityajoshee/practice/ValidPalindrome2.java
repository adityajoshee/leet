package adityajoshee.practice;

/**
 * Created by aditya.joshee on 2019-09-08.
 */

class ValidPalindrome2 {
    public static void main(String[] args) {
        System.out.println(validPalindrome("aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga"));
    }
    public static boolean validPalindrome(String s) {
        if(s.length()<2) return true;
        int i=0,j=s.length()-1;
        boolean canDel=true;

        while(i<j){
            if(s.charAt(i)==s.charAt(j)){
                i++;j--;
                continue;
            }
            if(canDel){
                if(s.charAt(i)==s.charAt(j-1)){
                    j--;
                }
                else if( s.charAt(i+1)==s.charAt(j)){
                    i++;
                }

                canDel=false;
            }
            else{
                return false;
            }
        }
        return true;
    }
}