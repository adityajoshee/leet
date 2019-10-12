package adityajoshee.Y2K19.oct;

import java.util.Arrays;

/**
 * Created by aditya.joshee on 2019-10-06.
 */
public class LIS {
    public static void main(String[] args) {
        int[] arr = {6,3,4,2,1,5,0,7};
        System.out.println(find(arr));
    }

    // On*n solution but can be made much better
    private static int find(int[] arr) {
        int[] lis = new int[arr.length];
        Arrays.fill(lis, 1);
        for(int i=0; i<arr.length; i++){
            for (int j=i-1; j>=0; j--){
                if(arr[i]>arr[j]) {
                    lis[i] = Math.max(lis[i], 1 + lis[j]);
                }
            }
        }
        int max = Integer.MIN_VALUE;
        System.out.println(Arrays.toString(lis));
        for(int i=0; i<lis.length; i++){
            max = Math.max(max, lis[i]);
        }
        return max;
    }
}
