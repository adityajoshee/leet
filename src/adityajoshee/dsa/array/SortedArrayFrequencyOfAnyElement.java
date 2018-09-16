package adityajoshee.dsa.array;

/**
 * Created by aditya on 11/17/16.
 */
/*
In a sorted array having repeated elements any number of time.
Given a element findMethod1 its no. of occurrences.
 */
public class SortedArrayFrequencyOfAnyElement {
    public static void main(String args[]){
        int[] arr = {1,1,2,3,3,3,4,5,7,7,7,7,7,8,9};
        try {
            System.out.println("Frequency: "+findFreq(arr,7));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static int findFreq(int[] arr, int x) throws Exception {
        // findMethod1 lower and higher element indices using binarysearch...
        int l = findIndex(arr,x,true);
        int r = findIndex(arr,x,false);
        System.out.println("lowest index of "+x+": "+l);
        System.out.println("greatest index of "+x+": "+r);
        return r-l+1;
    }

    // findMethod1 element lower/higher than num for sorted arr
    private static int findIndex(int[] arr, final int num, boolean lower) throws Exception {
        int l = 0;
        int r = arr.length-1;
        int mid;
        while (l<=r){
            mid =  l + (r-l)/2;
            if (arr[mid]==num){
                if (lower){
                    if (mid-1<0 || (mid-1>=0 && arr[mid-1]!=num)){
                        return mid;
                    }
                }
                else {
                    if (mid+1==arr.length || (mid+1<arr.length && arr[mid+1]!=num)){
                        return mid;
                    }
                }
            }

            if (arr[mid]==num) {
                if (lower){
                    r = mid-1;
                }
                else {
                    l = mid+1;
                }
            }
            else if (arr[mid]<num){
                l = mid+1;
            }
            else{
                r = mid-1;
            }
        }
        throw new Exception();
    }
}
