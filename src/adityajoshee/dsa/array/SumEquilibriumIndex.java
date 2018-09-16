package adityajoshee.dsa.array;

/**
 * Created by aditya on 11/7/16.
 */
//http://www.geeksforgeeks.org/equilibrium-index-of-an-array/

public class SumEquilibriumIndex {
    public static void main(String args[]){
        int[] arr = {-7, 1, 5, 2, -4, 3, 0};
        find(arr);
    }
    private static void find(int[] arr){
        // first findMethod1 sum...
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        // track left sum and right sum and check for equality
        int lsum = 0;
        int rsum = sum;
        for (int i = 0; i < arr.length; i++) {
            rsum -= arr[i];
            if (lsum==rsum){
                System.out.println("Index "+ i+" is an equilibrium index");
            }
            lsum += arr[i];
        }
    }
}
