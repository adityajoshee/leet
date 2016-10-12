package practice;

/**
 * Created by aditya on 8/13/16.
 */
public class MaxTrans {
    public static void main(String args[]){
        int[] arr =new int[]{10,1,1,1,11};
        System.out.println(findMaxStockTrans(arr));
    }
    private static int findMaxStockTrans(int[] arr){
        int currMax = 0;
        int min = arr[0];
        for(int e: arr){
            currMax = Math.max(currMax,e-min);
            min = Math.min(min,e);
        }
        return currMax;
    }
}
