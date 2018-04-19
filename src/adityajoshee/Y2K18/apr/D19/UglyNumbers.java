package adityajoshee.Y2K18.apr.D19;

/**
 * Created by aditya.joshee on 4/19/18.
 */
public class UglyNumbers {
    public static void main(String[] args) {
        int n = 20;
        System.out.println("nth Ugly:"+nthUgly(n));
    }

    private static int nthUgly(int n) {
        int[] uglies = new int[n];
        uglies[0] =1; //by convention
        int i2 = 0;
        int i3 = 0;
        int i5 = 0;

        int next2mul = uglies[i2]*2;
        int next3mul = uglies[i2]*3;
        int next5mul = uglies[i2]*5;

        for (int i = 1; i < n; i++) {
            int nextUgly = Math.min(next2mul, Math.min(next3mul, next5mul));
            uglies[i] = nextUgly;
            System.out.println(nextUgly);

            if (next2mul==nextUgly){
                i2++;
                next2mul = uglies[i2]*2;
            }
            if (next3mul==nextUgly){
                i3++;
                next3mul = uglies[i3]*3;
            }
            if (next5mul==nextUgly){
                i5++;
                next5mul = uglies[i5]*5;
            }
        }
        return uglies[n-1];
    }
}
