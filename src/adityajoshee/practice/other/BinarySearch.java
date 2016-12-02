package adityajoshee.practice.other;

import java.util.Scanner;

/**
 * Created by aditya.joshee on 15/12/14.
 */
public class BinarySearch {

    public static void main(String args[]){
        int[] arr = {1, 5, 7, 0, 2, 4, 9 , 8, 11, 12, 3};

        arr = sort(arr);
        for (int i:arr) {
            System.out.print(i+ " ");
        }

        Scanner scn = new Scanner(System.in);
        int x = scn.nextInt();
        System. out.println("Searching for : "+x);
        System.out.println(binarySearch(arr,x));

    }

    public static int binarySearch(int[] arr, int x){    // return index if found else -1

        int left = 0, right = arr.length-1;
        int mid = left + (right - left)/2 ;

        while(left<=right){
            if(arr[mid]==x){
                return mid;
            }
            if(x>arr[mid]){
                left = mid+1;
            }
            else{
                right = mid-1;
            }
            mid = left+(right-left)/2;
        }
        return -1;
    }



    private static int[] sort(int[] arr){
        // bubble sort

        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr.length-1-i; j++){ // with every iteration, the next bigger will be at the correct position.
                if(arr[j+1]<arr[j]){
                    swap(arr,j,j+1);
                }
            }
        }
        return arr;
    }

    private static void swap(int[] arr, int i, int j){
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
