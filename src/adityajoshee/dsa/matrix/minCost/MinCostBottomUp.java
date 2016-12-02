package adityajoshee.dsa.matrix.minCost;

/**
 * Created by aditya on 11/20/16.
 */
/*
http://www.geeksforgeeks.org/dynamic-programming-set-6-min-cost-path/
Source - 0,0; Destn - n,m;
Possible moves - right, bottom, diagonally down.

DP should be used instead, so that the same subproblem
is not solved over and over again.
 */
public class MinCostBottomUp {
    public static void main(String args[]){
        int[][] costMatrix= {
            {1,2,3},
            {4,8,2},
            {1,5,3}
        };
        System.out.println(findMinPathRecursion(costMatrix,0,0,0));
        System.out.println(findMinPathDP(costMatrix));

    }
    private static int findMinPathRecursion(int[][] costMatrix, int i, int j, int currCost){
        if (i>=costMatrix.length || j>=costMatrix[0].length){
            // invalid move...returning MAX_VAL should be safe
            return Integer.MAX_VALUE;
        }
        if (i==costMatrix.length-1 && j==costMatrix[0].length-1){
            // destination reached...i.e. bottom right...
            return currCost+costMatrix[i][j];
        }

        /*
         otherwise...solve the subproblem by adding the current cell cost &
          then recurring for all possible next move..
         */
        return minOf(findMinPathRecursion(costMatrix,i+1,j,costMatrix[i][j]+currCost),
                findMinPathRecursion(costMatrix,i,j+1,costMatrix[i][j]+currCost),
                findMinPathRecursion(costMatrix,i+1,j+1,costMatrix[i][j]+currCost)
        );
    }

    private static int minOf(int a, int b, int c){
        return a<b? ( a<c ? a : c) : ( b<c ? b : c);
    }

    private static int findMinPathDP(int[][] costMat){
        int[][] dp = new int[costMat.length][costMat[0].length];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) { //j=1, since 0,0 is source.

                if (i==0 && j==0){
                    dp[i][j]=costMat[i][j];
                }

                else {
                    int costU = Integer.MAX_VALUE;
                    int costL = Integer.MAX_VALUE;
                    int costD = Integer.MAX_VALUE;

                    if (i - 1 >= 0) {
                        costU = dp[i - 1][j];
                    }
                    if (j - 1 >= 0) {
                        costL = dp[i][j - 1];
                    }
                    if (i - 1 >= 0 && j - 1 >= 0) {
                        costD = dp[i - 1][j - 1];
                    }
                    dp[i][j] = costMat[i][j]+minOf(costU, costD, costL);
                }

            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }
}
