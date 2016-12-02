package adityajoshee.hackerrank.algorithm.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by aditya on 10/20/16.
 */
public class CountingSort1 {
    public static void main(String args[]) throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        int n = Integer.parseInt(bufferedReader.readLine());
        String[] inputstrs = bufferedReader.readLine().split(" ");
        int[] input = new int[inputstrs.length];
        for (int i = 0; i < input.length; i++) {
            input[i] = Integer.parseInt(inputstrs[i]);
        }
        printCounts(input);
    }
    private static void printCounts(int[] input){
        if(input.length>0) {
            int[] counts = new int[100];
            for (int i = 0; i < input.length; i++) {
                counts[input[i]] += 1;
            }
            for (int i = 0; i < counts.length; i++) {
                System.out.print(counts[i] + " ");
            }
        }
    }

}
