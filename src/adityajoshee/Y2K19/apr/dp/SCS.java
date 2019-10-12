package adityajoshee.Y2K19.apr.dp;

/**
 * @author Aditya Joshee
 */
// smallest common supersequence of 2 string
public class SCS {
    public static void main(String[] args) {
        String s1 = "bbabacaa";
        String s2 = "cccababab";
        System.out.println(getSCS(s1.toCharArray(), s1.length()-1, s2.toCharArray(), s2.length()-1));
    }

    private static int getSCS(char[] s1, int i, char[] s2, int j) {
        if (i<0){
            return j+1;
        }
        if (j<0){
            return i+1;
        }
        if (s1[i]==s2[j]){
            return 1+getSCS(s1, i-1, s2, j-1);
        }
        return 1 + Math.min(getSCS(s1, i, s2, j-1),  getSCS(s1, i-1, s2, j));
    }
}
