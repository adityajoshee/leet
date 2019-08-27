package adityajoshee.Y2K19.apr.dp;

/**
 * @author Aditya Joshee
 */
public class Knapsack01 {
    public static void main(String[] args) {
        int[] val = {20,5,10,40,15,25};
        int[] wt = {1,2,3,8,7,4};
        int n = 10;
        System.out.println(maxValue(val, val.length-1, wt, wt.length-1, n));
    }

    private static int maxValue(int[] val, int v, int[] wt, int w, int totalwt) {
        if (v<0){
            return 0;
        }
        if (totalwt>=wt[w]){
            return Math.max(val[v] + maxValue(val, v-1, wt, w-1, totalwt-wt[w]),
                    maxValue(val, v-1, wt, w-1, totalwt));
        }
        return maxValue(val, v-1, wt, w-1, totalwt);
    }
}
