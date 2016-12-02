package adityajoshee.dsa.sort;

/**
 * Created by aditya.joshee on 17/12/14.
 */
public class BubbleSort {

    public static void main(String ars[]){
        int[] input = new int[]{9,0,9,0,4,2,1,5,6,0,2,8};
        sort(input);
        for(int i=0;i<input.length;i++){
            System.out.print(" "+input[i]);
        }
    }

    public static void sort(int arr[]){
        if(arr!=null){
            int t;
            for(int i=0;i<arr.length;i++){
                for(int j=0;j<arr.length-1-i;j++){
                    if(arr[j]>arr[j+1]){
                        t=arr[j];
                        arr[j]=arr[j+1];
                        arr[j+1]=t;
                    }
                }
            }
        }
    }
}
