package adityajoshee.dsa.recursion;

/**
 * Created by aditya.j on 4/2/17.
 */
/*
findMethod1 the min number of scalar multiplications needed for product of an array of matrices
 */
public class MatrixChainMult {
    public static void main(String args[]){
        int[] arr = {1, 2, 3, 4}  ;
        System.out.println(findMinCalc(arr,1,arr.length-1));
    }
    private static int findMinCalc(int p[], int i, int j) {
        if (i==j){
            // only single matrix..so nothing to multiply
            return 0;
        }
        int min = Integer.MAX_VALUE;
        int cmin;
        for (int k = i; k < j; k++) {
            cmin = findMinCalc(p,i,k) + findMinCalc(p, k+1, j) + p[i-1]*p[k]*p[j];
            if (min > cmin){
                min = cmin;
            }
        }
        return min;
    }

}
