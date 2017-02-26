package adityajoshee.hackerrank.algorithm.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by aditya on 9/12/16.
 */
public class CoinChangeProblem {
    public static void main(String args[]) throws IOException{

        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String[] inputs = bufferedReader.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);
        int[] deno = new int[m];
        String[] input = bufferedReader.readLine().split(" ");
        for (int i = 0; i < m; i++) {
            deno[i] = Integer.parseInt(input[i]);
        }
        System.out.println(noOfWays(n,deno));
    }

    private static long noOfWays(int sum, int[] coins){
        long[][] aux = new long[sum+1][coins.length+1];

        for (int i = 0; i <= sum; i++) {
            aux[i][0] = 0; // no coins mean 0 ways to provide change for any value of sum.
        }
        for (int i = 0; i <= coins.length; i++) {
            aux[0][i] = 1; // if sum is 0 then only 1 way i.e. give no coin.
        }
        aux[0][0] = 1;

        for (int i = 1; i <= sum; i++) {
            for (int j = 1; j <= coins.length; j++) {
                // only coins till coins[j-1] are available for sum = i
                if(i>=coins[j-1]){
                    aux[i][j] = aux[i-coins[j-1]][j] + aux[i][j-1];
                }
                else {
                    aux[i][j] = aux[i][j-1];
                }
            }
        }
        return aux[sum][coins.length];
    }
}
