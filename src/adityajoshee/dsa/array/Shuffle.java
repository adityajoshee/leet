package adityajoshee.dsa.array;

import java.util.Random;

/**
 * Created by adityajoshee on 08/05/16.
 */
public class Shuffle {

    private static Random random = new Random();

    public static void main(String args[]){
        int[] arr = {1,4,2,5,6,9,3,7};
        shuffle(arr,0,arr.length-1);

        System.out.println();

        int i=0;
        while(i<arr.length)
            System.out.print(arr[i++]+" ");
    }

    private static void shuffle(int[] arr,int start,int end){

        if(start<end){
            int randomIndex = start+random.nextInt(end-start);
            System.out.print(randomIndex+" ");
            swap(arr,end,randomIndex);
            shuffle(arr,start,end-1);
        }
    }

    private static void swap(int[] A, int i, int x) {
        int temp = A[i];
        A[i]=A[x];
        A[x]=temp;
    }


}
