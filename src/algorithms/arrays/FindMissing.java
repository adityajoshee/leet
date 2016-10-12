package algorithms.arrays;

/**
 * Created by aditya.joshee on 29/11/14.
 */

/*
Find missing number in an array of size n and numbers in sorted order from 0 to n-1
Find in Log(n).

 */
public class FindMissing {

    public static void main(String[] a){
        int[] arr={0,1,2,3,4,5,6,7,9,10};
        System.out.println(findMissing(arr));
    }

    static int findMissing(int[] arr){
        int left=0;
        int right=arr.length-1;
        int mid=-1;
        while(left<right)
        {
            mid=left + (right-left)/2;
            if(arr[mid]==mid){
                left=mid+1;
            }
            else{
                if(arr[mid-1]==mid-1){
                    return mid;
                }
                right=mid-1;
            }
        }
        return arr[mid];
    }

}
