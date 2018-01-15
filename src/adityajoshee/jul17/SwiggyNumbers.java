package adityajoshee.jul17;

import java.util.Scanner;

/**
 * Created by aditya.joshee on 7/22/17.
 */
public class SwiggyNumbers {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        long a = scanner.nextLong();
        long b = scanner.nextLong();
        System.out.println(findMagicNumbers(a, b));
    }
    private static long findMagicNumbers(long a, long b){
        if (b<a){
            return 0;
        }
        long alen = findNoOfDigits(a);
        long blen = findNoOfDigits(b);
        long mid=0;

        if (alen==blen){
            return forEqualLen(a, b);
        }

        for (long i = alen+1; i < blen; i++){
            mid = mid + (long)Math.pow(2,i);
        }
        long x =  forEqualLen(a, (long) Math.pow(10,alen)-1)+mid+forEqualLen((long) Math.pow(10,blen-1), b);
        return x;
    }

    private static long forEqualLen(long x, long y){
        long c=0;

        for (long i=x; i<=y; i++){
            if(isMagicNo(i)){
                c++;
            }
        }
        return c;
    }

    private static boolean isMagicNo(long x){
        do{
            long r = x%10;
            x = x/10;
            if (r!=4 && r!=7){
                return false;
            }
        }
        while (x>0);
        return true;

    }

    private static long findNoOfDigits(long x){
        long count=0;
        do {
            x = x/10;
            count++;
        }
        while (x>0);
        return count;
    }
}
