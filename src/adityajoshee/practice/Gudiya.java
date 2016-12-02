package adityajoshee.practice;

/**
 * Created by aditya on 11/25/16.
 */
public class Gudiya {
    public static void main(String args[])
    {
        String s = "GUDIYA";
        char[] c = s.toCharArray();
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < i+1; j++) {
                System.out.print(c[j]);
            }
            System.out.println();
        }
        for (int i = c.length-1; i >= 0; i++) {
            for (int j = i; j >= 0; j--) {
                System.out.print(c[j]);
            }
            System.out.println();
        }

    }
}
