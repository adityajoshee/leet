package adityajoshee.hackerrank.algorithm.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * Created by aditya on 9/10/16.
 */
public class FibonacciModified {
    public static void main(String args[]) throws IOException{
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String[] inputs = bufferedReader.readLine().split(" ");
        int a=-1,b=-1,n=-1;
        for (int i = 0; i < inputs.length; i++) {
            a = Integer.parseInt(inputs[0]);
            b = Integer.parseInt(inputs[1]);
            n = Integer.parseInt(inputs[2]);
        }
        System.out.println(getNth(a,b,n));
    }
    private static BigInteger getNth(int a, int b, int n){
        BigInteger[] vals = new BigInteger[n];
        vals[0] = BigInteger.valueOf(a);
        vals[1] = BigInteger.valueOf(b);
        int k=2;
        while(k < n){
            vals[k] = vals[k-2].add((vals[k-1]).multiply(vals[k-1]));
            k++;
        }
        return vals[n-1];
    }
}
