package adityajoshee.hackerrank.algorithm.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by aditya.j on 2/26/17.
 */
public class Candies {
    public static void main(String args[]) throws IOException {
//        int[] ratings = {5,4,3,0,1,2};
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(inputStreamReader);
        int N = Integer.parseInt(br.readLine());
        int[] ratings = new int[N];
        for (int i = 0; i < N; i++) {
            ratings[i] = Integer.parseInt(br.readLine());
        }
        System.out.println(assign(ratings));
    }
    private static long assign(int[] ratings){
        long sum2 = 0;
        int[] assignment = new int[ratings.length];
        Arrays.fill(ratings,1);
        for (int i = 0; i < ratings.length-1; i++) {
            if (ratings[i+1]>ratings[i]){
                assignment[i+1] = assignment[i]+1;
            }
        }
        for (int i = ratings.length-1; i > 0; i--) {
            if (ratings[i-1]>ratings[i] && assignment[i-1]<=assignment[i]){
                assignment[i-1] = assignment[i]+1;
            }
        }
        for (int i = 0; i < assignment.length; i++) {
            sum2+=assignment[i];
        }
        System.out.println(Arrays.toString(assignment));
        return sum2;
    }
}