package adityajoshee.dsa.recursion;

/**
 * Created by aditya on 11/13/16.
 */
// order in which points are scored matters.

public class WaysToScoreInAGame {
    public static void main(String args[]){
        int[] validPoints = {3,5,10};
        int n = 20;
        System.out.println(findWays(validPoints,n));
    }
    private static int findWays(int[] validPoints, int finalScore){
        if (finalScore==0){ // the solution stack works
            return 1;
        }
        if (finalScore<3){ // the solution stack is not valid.
            return 0;
        }
        return  findWays(validPoints,finalScore-validPoints[0]) +
                findWays(validPoints,finalScore-validPoints[1]) +
                findWays(validPoints,finalScore-validPoints[2]);

    }
}
