package adityajoshee.dsa.recursion;

/**
 * Created by adityajoshee on 26/04/16.
 *

 Ways to arrange Balls such that adjacent balls are of different types
    There are ‘p’ balls of type P, ‘q’ balls of type Q and ‘r’ balls of type R.
    Using the balls we want to create a straight line such that no two balls of same type are adjacent.


 Time Complexity of this solution is exponential.


 *
 */
public class AdjBallsDifferentColor {

    public static void main(String args[]){
        int p = 2, q = 1, r = 1;
        System.out.println("Ways: "+printBallArrangements(p,q,r,"",""));
    }

    private static int printBallArrangements(int p,int q,int r,String currentArrangement,String lastBall){

        if(p==0 && q==0 && r==0){
            // done
            System.out.println(currentArrangement);
            return 1;
        }
        int i=0,j=0,k=0;
        if(p>0 && !lastBall.equals("P"))
            i=printBallArrangements(p-1,q,r,currentArrangement+"P","P");
        if(q>0 && !lastBall.equals("Q"))
            j=printBallArrangements(p,q-1,r,currentArrangement+"Q","Q");
        if(r>0 && !lastBall.equals("R"))
            k=printBallArrangements(p,q,r-1,currentArrangement+"R","R");
        return i+j+k;

    }



}
