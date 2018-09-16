package adityajoshee.Y2K18.apr.D22;

/**
 * Created by aditya.joshee on 4/22/18.
 */
public class MinJumpsToReachEnd {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
        System.out.println(findMethod1(arr));
        System.out.println(findMethod2(arr));
    }


    public static int findMethod1(int[] arr){
        int[] dp = new int[arr.length];
        for (int i = 0; i < dp.length; i++) {
            dp[i]=-1;
        }
        return findMethod1(arr, 0, dp);
    }
    private static int findMethod1(int[] arr, int p, int[] dp) {

        if (p>=arr.length-1){
            return 0;
        }
        if (dp[p]!=-1){
            return dp[p];
        }
        if (arr[p]==0){
            return Integer.MAX_VALUE;
        }
        int min = Integer.MAX_VALUE;
        for (int i = p+1; i <= p+arr[p]; i++) {
            min = Math.min(findMethod1(arr, i, dp), min);
        }
        min =  min==Integer.MAX_VALUE? Integer.MAX_VALUE:min+1;
        dp[p] = min;
        return dp[p];
    }

    public static int findMethod2(int[] arr){
        int[] dp = new int[arr.length];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = -1;
        }
        dp[arr.length-1] = 0;

        for (int i = arr.length-2; i >=0 ; i--) {
            if (arr[i] == 0){
                dp[i] = Integer.MAX_VALUE;
                continue;
            }
            int min = Integer.MAX_VALUE;
            for (int j = i+1; j <= i+arr[i] ; j++) {
                if (j>=arr.length){
                    min = 0;
                }
                else {
                    min = Math.min(min, dp[j]);
                }
                dp[i] = min==Integer.MAX_VALUE?Integer.MAX_VALUE:min+1;
            }
        }
        return dp[0];
    }
}
