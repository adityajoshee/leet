package adityajoshee.Y2K19.apr.dp;

/**
 * @author Aditya Joshee
 */

// dp approach
public class Fib {
    public static void main(String[] args) {
        long[] inputs = {90};
        for (long i : inputs){
            System.out.println(fibNthValue(i));

        }
    }

    private static long fibNthValue(long i) {
        long a = 1;
        long b = 1;
        if (i < 3){
            return 1;
        }
        while (i-- > 2){
            long t = b;
            b = t + a;
            a = t;
        }
        return b;

    }
}
