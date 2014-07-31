package algorithms;

/**
 * Created by aditya.joshee on 23/07/14.
 *
 * K(n)=K(n-3)+K(n-2)+K(n-1)
 */
public class NSteps {
    public static void main(String args[]){
        System.out.println(stepdown(2));

    }

    public static int stepdown(int n){
        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        return stepdown(n-1)+stepdown(n-2);
        }
    }
