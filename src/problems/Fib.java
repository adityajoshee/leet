package problems;

/**
 * Created by aditya.joshee on 15/11/14.
 */
public class Fib {
    public static void main(String args[]){
        int a = 0;
        int b = 1;
        int n = 10;
        int t;
        System.out.println(a);
        System.out.println(b);
        while(n-->0){
            System.out.println(a+b);
            t=b;
            b=a+b;
            a=t;
        }

    }
}
