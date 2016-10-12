package algorithms.matrix;

import java.util.Scanner;
/**
 * Created by aditya.joshee on 31/07/14.
 *
 * Robot is @ topleft. And can move only right and down.
 * Find number of ways to reach bottom right.
 *
 * It can also be achieved by p&c by (r+c)!/(r!*c!)
 *
 * Recursion based, can be improved using DP
 */
public class WaysToReachBottom {
    // Possible moves - right or bottom .
    public static void main(String args[]){
        Scanner in =new Scanner(System.in);
        System.out.println("Enter row,column:");
        int r=in.nextInt();
        int c=in.nextInt();
        System.out.println("No. of ways: "+countMoves(r,c));
    }
    private static int countMoves(int r,int c ){
        if(r<1 || c<1){
            return -Integer.MIN_VALUE;
        }
        if(r==1||c==1){
            return 1;
        }
        return countMoves(r-1,c)+countMoves(r,c-1);
    }
}
