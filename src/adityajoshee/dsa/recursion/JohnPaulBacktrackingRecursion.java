package adityajoshee.dsa.recursion;

/**
 * Created by adityajoshee on 22/04/16.
 */
public class JohnPaulBacktrackingRecursion {

    public static void main(String arg[]){

        System.out.println(sequences(0, 0, "", 3));

    }

    private static int sequences(int X, int Y, String s, int N){
        if(X+Y==N){
            System.out.println(s);
            return 1;
        }

        int a=sequences(X+1,Y,s+"x",N);
        int b=0;
        if(Y<N/2){
            b =sequences(X,Y+1,s+"y",N);
        }

        return a+b;
    }
}
