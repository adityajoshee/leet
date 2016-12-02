package adityajoshee.dsa.matrix;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by aditya on 10/9/16.
 */
public class WaysToReachBottomDP {
// Possible moves - right or bottom.
// Initial pos - 0,0
    public static void main(String args[]) throws Exception{
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        System.out.println("Enter row:");
        int r = Integer.parseInt(bufferedReader.readLine());
        System.out.println("Enter column:");
        int c= Integer.parseInt(bufferedReader.readLine());
        System.out.println("No. of ways: "+countMoves(r,c));
    }
    private static int countMoves(int r, int c){
        int dp[][] = new int[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(i==0 || j==0){
                    dp[i][j] = 1;
                }
                else{
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }

        return dp[r-1][c-1];
    }
}
