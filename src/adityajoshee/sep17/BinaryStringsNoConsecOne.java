package adityajoshee.sep17;

/**
 * Created by aditya.joshee on 9/6/17.
 */
//findMethod1 no. of binary strings of size k with no
    // consecutive ones
    // by recurrence
    //a[i] = a[i - 1] + b[i - 1]
    //b[i] = a[i - 1]

public class BinaryStringsNoConsecOne {
    public static void main(String args[]){
        int k = 3;
        Count a = new Count(1);
        Count b = new Count(1);
        find(true, a, 1, k);
        find( false, b, 1, k);
        System.out.println(a.val+b.val);
    }
    private static void find(boolean endsWithZero, Count c, int currLen, int k){
        if (currLen==k){
            return ;
        }
        if (endsWithZero){
            c.val++;
            find(true, c, currLen+1, k);
            find(false, c, currLen+1, k);
        }
        else{
            find(true, c, currLen+1, k);
        }
        return;
    }

    static class Count{
        int val;

        public Count(int val) {
            this.val = val;
        }
    }
}
