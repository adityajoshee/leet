package algorithms.arrays;

/**
 * Created by aditya on 8/12/16.
 */

//  http://www.geeksforgeeks.org/check-for-majority-element-in-a-sorted-array/

public class MajorityElementSortedArray {
    public static void main(String args[]){
        int[] arr = new int[] {1,1,1,3,3,3};
        System.out.println(isMajorityElement(arr,3));
    }

    // find if x is a majority element (freq > n/2). Arr is sorted.
    private static boolean isMajorityElement(int[] arr, int x){

        if(arr[arr.length/2]!=x){
            return false;
        }

        int firstIndexOfX = binarySearchFirstIndexOf(arr, 0, arr.length/2, x);

        System.out.println(firstIndexOfX);
        return firstIndexOfX+arr.length/2<arr.length && arr[firstIndexOfX+arr.length/2]==x?true:false;

    }

    private static int binarySearchFirstIndexOf(int[] arr, int l, int r, int x){

        int mid = l+(r-l)/2;

        if(arr[mid]==x && ((mid>0 && arr[mid-1]<x) || mid==0)){
            return mid;
        }
        if(arr[mid]==x){
            r = mid-1;
        }
        else{
            l = mid+1;
        }
        return binarySearchFirstIndexOf(arr,l,r,x);

    }
}
