package adityajoshee.Y2K18.jan.D21;

import java.util.Arrays;

/**
 * Created by aditya.joshee on 1/21/18.
 */
public class MoveZerosToEnd {

    public static void main(String[] args) {
        int[] arr = {1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0};//{1,0,2,0,0,5,0,7};
        move(arr);
        System.out.println(Arrays.toString(arr));

    }

    private static void move(int[] arr) {
        int i = 0, j=1;
        while(j<arr.length){
            if (arr[i]==0 && arr[j]!=0){
                swap(arr, i, j);
                i++;
            }
            if(arr[i]!=0){
                i++;
            }
            j++;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
