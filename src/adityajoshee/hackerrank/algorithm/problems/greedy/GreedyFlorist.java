package adityajoshee.hackerrank.algorithm.problems.greedy;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by aditya.j on 2/26/17.
 */
public class GreedyFlorist {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);

        int N, K;
        N = in.nextInt();
        K = in.nextInt();

        int price[] = new int[N];
        for(int i=0; i<N; i++){
            price[i] = in.nextInt();
        }
        System.out.println(findMinCost(price,K));
    }
    private static long findMinCost(int[] price, int k){
        if ((float)price.length/k <= 1.0){
            return sumOfPriceArray(price);
        }
        Arrays.sort(price);
        int buyCount = 0;
        long total = 0;
        int p = price.length-1;
        while (p>=0){
            for (int i = 0; i < k && p>=0; i++) {
                total+= (buyCount+1)*price[p--];
            }
            buyCount++;
        }
        return total;
    }

    private static long sumOfPriceArray(int[] price){
        long sum = 0;
        for (int i = 0; i < price.length; i++) {
            sum+=price[i];
        }
        return sum;
    }
}
