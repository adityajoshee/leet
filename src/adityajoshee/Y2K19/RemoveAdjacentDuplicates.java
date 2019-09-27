package adityajoshee.Y2K19;

/**
 * Created by aditya.joshee on 2019-09-11.
 */

public class RemoveAdjacentDuplicates {
    public static void main(String[] args) {
        System.out.println(removeDuplicates("aababaab"));
    }
    public static String removeDuplicates(String s) {
        if(s.length()<2) return s;
        int i=1;
        while(i<s.length()){
            int j=i;
            if(s.charAt(i)==s.charAt(i-1)){
                //duplicate found, find how many more duplicates are there
                //for the curr char
                while(j<s.length()-1){
                    if(s.charAt(j)==s.charAt(j+1)){
                        j++; // j will be the index of last duplicate for curr char
                    }
                    else{
                        break;
                    }
                }
                // now remove all chars from i-1 till j since they are duplicates
                if(j==s.length()){
                    s = s.substring(0, i-1) ;
                }
                else{
                    s = s.substring(0, i-1) + s.substring(j+1);
                }
                i = i-1 < 1 ? 1 : i-1;
            }
            else{
                i++;
            }
        }
        return s;
    }
}
