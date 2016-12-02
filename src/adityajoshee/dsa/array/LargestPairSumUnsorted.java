package adityajoshee.dsa.array;

/**
 * Created by adityajoshee on 03/05/16.
 */


// O(n)
// simply find largest and 2nd largest in single pass
public class LargestPairSumUnsorted {

    public static void main(String ags[]){
        int[] arr = {100,4,6,1,7,3,9,10,0,5,101};
        find(arr);
    }
    private static void find(int[] arr){
        int currentMax = arr[0];
        int currentNextMax = Integer.MIN_VALUE;
        for(int i=1; i<arr.length; i++){
            if(arr[i]>currentMax){
                currentNextMax = currentMax;
                currentMax = arr[i];
            }
            else if(arr[i]>currentNextMax){
                currentNextMax = arr[i];
            }
        }
        System.out.println("Pair is : "+ currentMax+", "+currentNextMax);
    }

}
