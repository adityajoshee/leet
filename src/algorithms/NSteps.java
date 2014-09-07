package algorithms;

/**
 * Created by aditya.joshee on 23/07/14.
 *
 * K(n)=K(n-3)+K(n-2)+K(n-1)
 *
 * If there is staircase of n step and we can only take steps of 1,2 or 3 at a time then
 * how many ways are there to cover the whole staircase.
 *
 *
 * DP can also be applied here.
 */
public class NSteps {
    public static void main(String args[]){
        System.out.println(stepdown(5));

    }

    public static int stepdown(int n){
        if(n<0){
            return 0;
        }
        if(n==0 || n==1){ // means either the steps are over or only 1 step is left which can be covered only in 1 way.
            return 1;
        }
        return stepdown(n-1)+stepdown(n-2)+stepdown(n-3);
        }
    }
