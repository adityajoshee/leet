package algorithms.arrays;

/**
 * Created by aditya on 8/13/16.
 */

// http://www.geeksforgeeks.org/union-and-intersection-of-two-sorted-arrays-2/

public class UnionIntersectionSorted {
    public static void main(String arg[]){
        int[] arr1 = new int[]{1, 3, 4, 5, 7};
        int[] arr2 = new int[]{2, 3, 5, 6};
        printIntersection(arr1,arr2);
        System.out.println();
        printUnion(arr1,arr2);
    }
    private static void printIntersection(int[] arr1, int[] arr2){
        int i=0,j=0;
        while(i<arr1.length && j<arr2.length){

            if( arr1[i]<arr2[j]){
                i++;
            }
            else if( arr1[i]>arr2[j]){
                j++;
            }
            else{
                System.out.print(" "+arr1[i]+" ");
                i++;j++;
            }
        }
    }
    private static void printUnion(int[] arr1, int[] arr2){
        int i=0,j=0;
        while(i<arr1.length && j<arr2.length){
            if(arr1[i]<arr2[j]){
                System.out.print(" "+arr1[i]+" ");
                i++;
            }
            else if( arr1[i]>arr2[j]){
                System.out.print(" "+arr2[j]+" ");
                j++;
            }
            else{
                System.out.print(" "+arr1[i]+" ");
                i++;j++;
            }
        }
        while(i<arr1.length){
            System.out.print(" "+arr1[i]+" ");
            i++;
        }
        while(j<arr2.length){
            System.out.print(" "+arr2[j]+" ");
            j++;
        }
    }
}
