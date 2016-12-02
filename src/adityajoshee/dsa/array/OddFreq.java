package adityajoshee.dsa.array;

/**
 * Created by aditya on 8/12/16.
 */

// only 1 element occurs odd number of times. Find that.
public class OddFreq {
    public static void main(String args[]) {
        int[] arr = {4, 5, 1, 1, 4, 5, 1, 5, 5}; // 4(i), 5, 6, 10, 12(j)
        System.out.println(findOddFreqElement(arr));
    }
    private static int findOddFreqElement(int[] arr){
        int xor = 0;
        for(int x : arr){
            xor = x ^ xor;
        }
        return xor;
    }

}
