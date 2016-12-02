package adityajoshee.dsa.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by aditya on 9/13/16.
 */
public class SumOfDigits {
    public static void main(String args[]) throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        int n = Integer.parseInt(bufferedReader.readLine());
        System.out.println(get(n));
    }
    private static int get(int n){
        int total = 0;
        for (int i = 1; i <= n; i++) {
            total = total + digitSum(i);
        }
        return total;
    }
    private static int digitSum(int x){
        int sum = 0;
        while (x!=0){
            sum += x%10;
            x = x/10;
        }
        return sum;
    }
}
