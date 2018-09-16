package adityajoshee.Y2K18.aug.D12;

import java.util.Arrays;
import java.util.Scanner;

/*
Optimised insertion sort. No further swaps required if
in any iteration current element is larger than
element at the previous index
 */
public class InsertionSort {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int size = scanner.nextInt();
//        int[] arr = new int[size];
//
//        for (int i = 0; i < size; i++) {
//            arr[i] = scanner.nextInt();
//        }
        int[] arr = {2,6,0,9,1,7,8};

        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {

            for (int j = i; j > 0; j--) {
                if (arr[j]<arr[j-1]){
                    swap(arr, j, j-1);
                }
                else {
                    continue;
                }
            }

        }
    }
    private static void swap(int[] arr, int x, int y){
        int t = arr[x];
        arr[x] = arr[y];
        arr[y] = t;
    }
}
