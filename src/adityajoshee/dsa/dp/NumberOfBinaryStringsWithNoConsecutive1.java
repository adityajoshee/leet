package adityajoshee.dsa.dp;

import adityajoshee.problems.PairSum;

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
        int N = 2;
        System.out.println(find(N));
        // other way:
        System.out.print(count(N-1,1)+count(N-1, 0));
    }

    //low complexity = n
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

    // high complexity = 2^n
    private static int count(int n, int last){
        if (n==0) {
            return 1;
        }
        if (last==1){
            return count(n-1, 0);
        }
        else{ // last==0
            return count(n-1,1)+count(n-1,0);
        }
    }
}
