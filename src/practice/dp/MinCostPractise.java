package practice.dp;

/**
 * Created by aditya on 10/11/16.
 */
public class MinCostPractise {
    public static void main(String args[]){
        int[][] cost = {     {0, 4, 15},{10, 9, 8},{4, 12, 0}    };
        System.out.println(getMinCost(cost, 0, 0));
    }
    private static int getMinCost(int[][] arr, int x, int y){
        int[][] minCostDp = new int[arr.length][arr[0].length];
        for (int i = 0; i < minCostDp.length; i++) {
            for (int j = 0; j < minCostDp[0].length; j++) {
                if(i==0 && j==0){
                    minCostDp[i][j] = arr[i][j];
                }
                else {
                    if (i == 0) {
                        minCostDp[i][j] = arr[i][j] + arr[i][j - 1];
                    }
                    else if (j == 0) {
                        minCostDp[i][j] = arr[i][j] + arr[i - 1][j];
                    }
                    else{
                        minCostDp[i][j] = arr[i][j] + Math.min(minCostDp[i-1][j],minCostDp[i][j-1]);
                    }
                }
            }
        }
        return minCostDp[minCostDp.length-1][minCostDp[0].length-1];
    }
}
