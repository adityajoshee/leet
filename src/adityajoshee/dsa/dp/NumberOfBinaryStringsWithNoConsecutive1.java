package adityajoshee.dsa.dp;

/**
 * Created by aditya.j on 4/9/17.
 */
/*
Count number of binary strings without consecutive 1’s.
Given a positive integer N, count all possible distinct binary strings of length N
 such that there are no consecutive 1’s.
 */
public class NumberOfBinaryStringsWithNoConsecutive1 {
    public static void main(String args[]){
        int N = 5;
        System.out.println(find(N));
    }
    private static int find(int n){
        int[] zeroEnding = new int[n+1];
        int[] oneEnding = new int[n+1];
        zeroEnding[0]=0;
        oneEnding[0]=0;
        zeroEnding[1]=1;
        oneEnding[1]=1;
        for (int i = 2; i < n+1; i++) {
            zeroEnding[i] = zeroEnding[i-1]+oneEnding[i-1];
            oneEnding[i] = zeroEnding[i-1];
        }
        return zeroEnding[n]+oneEnding[n];
    }
}
