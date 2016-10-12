package algorithms.dp;

/**
 * Created by aditya on 9/13/16.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by aditya on 9/13/16.
 */
public class SumOfDigitsOptimised {
    public static void main(String args[]) throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        int n = Integer.parseInt(bufferedReader.readLine());
        System.out.println(get(n));
    }
    private static int get(int n){
        int total = 0;
        int[] dSums = new int[n+1];
        dSums[0] = 0;
        for (int i = 1; i <= n; i++) {
            total = total + digitSum(i,dSums);
        }
        return total;
    }
    private static int digitSum(int x, int[] stored){
        stored[x] = x%10 + stored[x/10];
        return stored[x];
    }
}

