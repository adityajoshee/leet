package adityajoshee.dsa.backtracking;

/**
 * Created by aditya on 8/11/16.
 */
public class StringPermutation {
    public static void main(String args[]){
        int[] arr = new int[]{1,2,3};
        printPermutations(arr, 0);
    }

    private static void printPermutations(int[] arr, int level){
        if(arr.length-1==level){
            for(int i: arr) System.out.print(i);
            System.out.println();
            return;
        }

        for(int i=level; i<arr.length; i++){
            swap(arr, i, level);
            printPermutations(arr, level+1);
            swap(arr, i, level);
        }
    }

    private static void swap(int[] arr, int x, int y){
        int t = arr[x];
        arr[x] = arr[y];
        arr[y] = t;
    }
}
