package adityajoshee.Y2K18.may.D24;

/**
 * Created by aditya.joshee on 5/24/18.
 *
 * Given a string, rearrange the string in such a way so that no two same characters are adjacent.
 */
public class RearrangeStringNoAdjacent {
    public static void main(String[] args) {
        String s = "aaaabc";
        System.out.println(rearrange(s.toCharArray()));
    }

    // On*n solution, not optimal
    private static String rearrange(char[] chars) {
        int i = 0;
        while (i<chars.length-2){
            if (chars[i]==chars[i+1]){
                int j = i+2;
                while (chars[i+1]==chars[j]){
                    j++;
                    if (j==chars.length){
                        System.out.println("Not possible.");
                        return null;
                    }
                }

                swap(chars, i+1, j);
            }
            i++;
        }
        if (chars[chars.length-1]==chars[chars.length-2]){
            System.out.println("Not possible.");
            return null;
        }
        return new String(chars);
    }

    private static void swap(char[] chars, int i, int j) {
        char p = chars[i];
        chars[i] = chars[j];
        chars[j] = p;
    }
}
