package algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aditya.joshee on 07/09/14.
 */
public class RemoveDuplicatePrimes {

    public static void main(String args[]){
        int[] org = {3,5,7,11,23, 47,3, 7, 13};
        List result = removeDuplicates(org);
        System.out.println(result.toString());
    }
    private static List removeDuplicates(int[] org){
        int ml = 1;
        int k =0;
        List result=new ArrayList();
        for(int i=0;i<org.length;i++){
            if(ml%org[i]!=0){
                // not a duplicate
                ml = ml * org[i];
                result.add(org[i]);
            }
            else{
                // it is a duplicate
                org[i]=-1; // or remove it
            }

        }
        return result;
    }
}
