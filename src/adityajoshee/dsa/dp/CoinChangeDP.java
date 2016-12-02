package adityajoshee.dsa.dp;

/**
 * Created by adityajoshee on 23/04/16.
 */
public class CoinChangeDP {


    public static void main(String args[]){
        int  N = 4;
        int[] S= {1,2,3};
        //int N=4;  int [] S = {1,2,3} will have 4 solutions
        //int N=10;  int [] S = {2, 5, 3, 6} will have 5 solutions
        System.out.println(countWaysToPay(N, S));

    }

    private static int countWaysToPay(int N,int[] S){
        int[][] sumVsSet_dp = new int[N+1][S.length+1];

        for(int i=0;i<=S.length;i++){
            sumVsSet_dp[0][i]=1;     //if the payment is 0 then 1 way i.e. don't give any coins
        }
        for(int j=1; j<=N;j++){
            sumVsSet_dp[j][0]=0;   // no way to pay if S is void but payment >=1
        }

        printCurrentBoard(sumVsSet_dp);

        for(int i=1; i<=N; i++){
            for(int j=1; j<=S.length; j++){
                int r=0,t=0;
                if(i-S[j-1]>=0)
                    r = sumVsSet_dp[i-S[j-1]][j];    // include the current coin in S and take the subproblem's solution from DP array (but don't exclude the current coin)
                t = sumVsSet_dp[i][j-1];         // don't include the current coin in S and take the subproblem's solution from DP array (i.e. exclude the current coin)
                sumVsSet_dp[i][j]=r+t;
            }
            printCurrentBoard(sumVsSet_dp);
        }
        return sumVsSet_dp[N][S.length];
    }


    private static void printCurrentBoard(int[][] c){
        for (int i=0;i<c.length;i++){
            for(int j=0;j<c[i].length;j++){
                System.out.print(" " + c[i][j]);
            }
            System.out.println();
        }
        System.out.println("**********************");

    }
}
