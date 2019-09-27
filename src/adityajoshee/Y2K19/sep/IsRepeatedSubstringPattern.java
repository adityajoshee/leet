package adityajoshee.Y2K19.sep;

/**
 * Created by aditya.joshee on 2019-09-14.
 */
public class IsRepeatedSubstringPattern {
    public static void main(String[] args) {
        System.out.println(find("acaca"));
    }

    private static boolean find(String s) {
        return ((s+s).substring(1, (s+s).length()-2)).indexOf(s)!=-1;
    }
}
