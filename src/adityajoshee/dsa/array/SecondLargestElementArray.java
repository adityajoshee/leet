package adityajoshee.dsa.array;

/**
 * Created by aditya.joshee on 11/11/14.
 */
public class SecondLargestElementArray {
    public static void main(String... args){
        int[] arr={7,2,9,3,8,5,3};
        printSecondLargest(arr);
    }
    private static void printSecondLargest(int[] arr){
        int l1=Integer.MIN_VALUE;
        int l2=Integer.MIN_VALUE;

        for(int i=0;i<arr.length;i++){
            if(arr[i]>l1){
                l2=l1;
                l1=arr[i];
            }
            else if(arr[i]>l2){
                l2=arr[i];
            }
        }
        System.out.println("Second Largest Element : "+l2);
    }
}
