package drill;

import java.util.Scanner;

/**
 * Created by aditya.joshee on 15/12/14.
 */
public class BinarySearch {


    public static void main(String args[]){
        int[] ip = {1,2,3,4,6,9};
        Scanner s = new Scanner(System.in);
        int x = s.nextInt();
        System.out.println("Target index: "+search(ip,x));
    }

    private static int search(int[] arr, int x){
        if(arr!=null && arr.length>0){
            int left = 0;
            int right = arr.length-1;
            int mid = left + (right-left)/2;

            while(left<=right){
                if(arr[mid]==x){
                    return mid;
                }
                if(arr[mid]>x){
                    right=mid-1;
                }
                else{
                    left=mid+1;
                }
                mid=left+(right-left)/2;
            }
        }
        return -1;
    }
}
