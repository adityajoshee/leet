package adityajoshee.dsa.array;

/**
 * Created by aditya on 11/29/16.
 */
/*
O(n+m) - merge
O(k) - online compare using two indices
O(log(n) + log(m)) - divide and conquer
 */
//TODO bugs
public class KthLargestInTwoSortedArrays {
    public static void main(String args[]){
        int[] ar = {10,20,35,60,80,200};
        int[] br = {15,40,50,70,100,160};
        int k = 4;//70
        System.out.println(find(ar, 0, ar.length-1, br, 0, br.length-1, k));
    }
    private static int find(int[] ar,  int i, int j, int[] br, int x, int y, int k){
        // base cases...
        if (i>j){
            return br[x+k-1];
        }
        if (x>y){
            return ar[i+k-1];
        }

        int mida = (j-i+1)/2;
        int midb = (y-x+1)/2;
        // recursive cases...
        if (k > (mida + midb)){
            if (ar[i+mida]>br[x+midb]){
                return find(ar, i, j, br, x+midb+1, y, k-midb-1);
            }
            else {
                return find(ar, i+mida+1, j, br, x, y, k-mida-1);
            }
        }
        else{
            if (ar[i+mida]>br[x+midb]){
                return find(ar, i, i+mida, br, x, y, k);
            }
            else{
                return find(ar, i, j, br, x, x+midb, k);
            }

        }
    }
}
