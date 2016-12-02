package adityajoshee.dsa.array;

/**
 * Created by aditya on 8/12/16.
 */
public class ExponentialForm {
// find with minimum base

    public static void main(String args[]){
        System.out.println(canBeInExpForm(1023));
    }
    private static boolean canBeInExpForm(int x){
        if(x==1){
            return true;
        }
        for(int i=2; i<=Math.sqrt(x); i++){
            if(x%i!=0){
                continue;
            }
            int e = 0;
            int temp=1;
            while(temp<x){
                temp*=i;
                e++;
                if(temp==x){
                    System.out.println(i+"^"+e);
                    return true;
                }
            }
        }
        return false;
    }
}
