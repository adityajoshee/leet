package adityajoshee.dsa.array.minJumps;

/**
 * Created by aditya on 9/13/16.
 */

//http://www.geeksforgeeks.org/minimum-number-of-jumps-to-reach-end-of-a-given-array/

public class MinJumpsReachEndLinear {
    public static void main(String args[]){
        int[] jumpSet = {1,2,1,1,1};//{1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
        System.out.print("\n"+findMinJumps(jumpSet));
    }
    private static int findMinJumps(int[] arr){
        int jumps = 1;
        int steps = arr[0];
        int maxReach = arr[0] + 0;
        for (int i = 1; i < arr.length-1; i++ ) {
            if(i+arr[i]>maxReach){
                maxReach = i+arr[i];
            }
            steps--;
            if(steps==0){
                jumps++;
                steps = maxReach-i;
            }

        }
        return jumps;
    }
}

