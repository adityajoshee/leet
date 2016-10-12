package datastructure.heap;

import static datastructure.heap.BuildHeapUsingSiftDownInPlace.buildHeap;

/**
 * Created by aditya on 8/26/16.
 */
public class KthSmallestInUnsortedArray {
    public static void main(String[] args){

        int arr[]={8,2,4,0,9,3,1,7};
        buildHeap(arr);  // converts arr in to minheap
        int x = 0;
        while(x<arr.length){
            System.out.print(arr[x]+" ");
            x++;
        }
        System.out.println();
        printTopKElements(arr,4);
    }
    public static void printTopKElements(int[] arr,int k){
        for(int i=0; i<k; i++){
            System.out.print(" "+ arr[i]+" ");
        }
    }
}
