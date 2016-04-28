package algorithms.recursion;

/**
 * Created by adityajoshee on 23/04/16.

 *
 * Given a value N, if we want to make change for N cents, and we have infinite supply of each of S = { S1, S2, .. , Sm} valued coins, how many ways can we make the change? The order of coins doesn’t matter.

 For example, for N = 4 and S = {1,2,3}, there are four solutions: {1,1,1,1},{1,1,2},{2,2},{1,3}. So output should be 4. For N = 10 and S = {2, 5, 3, 6}, there are five solutions: {2,2,2,2,2}, {2,2,3,3}, {2,2,6}, {2,3,5} and {5,5}. So the output should be 5.
 */
public class CoinChange {

    public static void main(String args[]){
        int  N = 10;
        int[] S= {2, 5, 3, 6};
        int paidTillNow=0;
        System.out.println(countWaysToPay(N, S, paidTillNow,0));

    }
    private static int countWaysToPay(int N,int[] S,int paidTillNow, int currentCoin){
        if(paidTillNow==N){
            // one of possibly many valid solution
            return 1;
        }
        if(paidTillNow>N){
            // invalid solution
            return 0;
        }

        int x = countWaysToPay(N, S, paidTillNow+S[currentCoin], currentCoin);

        int y = 0;
        if(currentCoin+1<S.length)
            y=countWaysToPay(N,S,paidTillNow, currentCoin+1);

        return x+y;
    }
}
