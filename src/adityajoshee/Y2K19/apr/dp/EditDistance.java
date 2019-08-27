package adityajoshee.Y2K19.apr.dp;

/**
 * @author Aditya Joshee
 */
public class EditDistance {
    public static void main(String[] args) {
        String s1 = "eabc";
        String s2 = "ebcd";
        System.out.println(findEditCost(s1.toCharArray(), s1.length()-1, s2.toCharArray(), s2.length()-1));
    }

    private static int findEditCost(char[] s1, int a, char[] s2, int b) {
        if (a<0){
            return b+1;
        }
        if (b<0){
            return a+1;
        }
        if (s1[a]==s2[b]){
            return findEditCost(s1,a-1,s2,b-1);
        }
        return 1+Math.min(findEditCost(s1,a-1,s2,b-1), Math.min(findEditCost(s1,a-1,s2,b), findEditCost(s1,a,s2,b-1)));
    }
}
