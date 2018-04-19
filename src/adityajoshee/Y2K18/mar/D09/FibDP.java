package adityajoshee.Y2K18.mar.D09;

import java.util.Scanner;

/**
 * Created by aditya.joshee on 3/9/18.
 */
public class FibDP {
    public static void main(String[] args) {
        System.out.println(printNthFib(new Scanner(System.in).nextInt()));
    }

    private static int printNthFib(int N) {
        int a = 0;
        int b = 1;
        if (N==1){
            return a;
        }
        if (N==2){
            return b;
        }
        N = N-2;
        while (N>0){
            N--;
            int t = a + b;
            a = b;
            b = t;
        }
        return b;
    }
}
