package adityajoshee.dsa.array;

import java.util.Arrays;

/**
 * Created by aditya on 8/13/16.
 */
public class ProductArray {
    public static void main(String args[]){
        int[] arr = new int[]{2,5,3,4};
        System.out.println(Arrays.toString(productArray(arr)));
    }
    private static int[] productArray(int[] arr){
        int[] productArray = new int[arr.length];
        productArray[0]=1; // init;

        for(int i=1; i<arr.length; i++){
            productArray[i] = arr[i-1]*productArray[i-1];
        }
        System.out.println(Arrays.toString(productArray));

        int rightProduct = arr[arr.length-1];
        for(int i=arr.length-2; i>=0; i--){
            productArray[i] = productArray[i]* rightProduct;
            rightProduct = rightProduct*arr[i];
        }
        return productArray;

    }
}
