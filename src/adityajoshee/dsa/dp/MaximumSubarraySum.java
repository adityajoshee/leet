package adityajoshee.dsa.dp;

/**
 * Created by aditya.joshee on 14/09/14.
 */

public class MaximumSubarraySum {
    public static void main(String args[]){
        int[] a = {100,-2,3,-4,5,6,-7};
        System.out.println("Max SubSequence Sum: "+ kadane(a));
    }

    // If all are -ve elements then the algo returns 0;
    private static int kadane(int[] a){
        int cmax=0;  //current max
        int gmax=0;   // global max

        for(int i=0;i<a.length;i++){
            cmax=cmax+a[i];
            if(cmax<0){
                cmax=0;
            }
            if(gmax<cmax){
                gmax=cmax;
            }
        }
        return gmax;
    }

    // correct soln.
    private static int find(int[] arr){
        int currentSum = arr[0];
        int currentMax = arr[0];

        for(int i=1; i<arr.length; i++){
            currentSum = Math.max(arr[i],currentSum + arr[i]);
            currentMax = Math.max(currentSum, currentMax);
        }
        return currentMax;
    }
}
