package adityajoshee.Y2K19.apr.dp;

/**
 * @author Aditya Joshee
 */
public class CoinChange {
    public static void main(String[] args) {
        int[] deno = {1, 2, 3,10,22,11,8};
        int sum = 30;
        System.out.println(findMinCoins(deno, sum));
    }

    private static long findMinCoins(int[] deno, long sum) {
        if (sum<0){
            return Integer.MAX_VALUE;
        }
        if (sum==0){
            return 0;
        }
        long min = Integer.MAX_VALUE;
        for (int i=0; i<deno.length; i++){
            min = Math.min(min, 1+findMinCoins(deno, sum-deno[i]));
        }
        return min;
    }
}
